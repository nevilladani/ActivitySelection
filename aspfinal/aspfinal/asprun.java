

//Nevil Ladani
//npl130030@utdallas.edu


package aspfinal;


import java.io.*;
import java.util.*;
public class asprun
{
	private static List<Activity> activities=new ArrayList<Activity>();
	
    public static void main(String[] args) throws Exception
    {
    	System.out.println("Algotrithm Project");
    	System.out.println("By Nevil Ladani");
    	System.out.println("Email: npl130030@utdallas.edu");
    	System.out.println();
    	System.out.println("Activity Selection Problem");
    	
    	File f = new File("t4.txt");
    	int n = 0;
    	try{
    		
        	Scanner scanner = new Scanner(f);
        	n = scanner.nextInt();
    		System.out.println("Number of Activities: "+ n);
        	while(scanner.hasNextLine())
        	{
				
				activities.add(new Activity(scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
        	
        	}
        	Collections.sort(activities,new ActivityComparator());
       
		scanner.close();
    	}
        catch(FileNotFoundException filenotfoundexception)
    	{
       		System.out.println("File not found.");
    	}
    	     
		catch(IOException ioexception)
    	{
       		System.out.println("File input error occured!");
       
    	}		
		/*for(int i=0;i<n ;i++)
		{
				System.out.print(activities.get(i).getStartTime()+" ");
				System.out.print(activities.get(i).getFinishTime()+ " ");
				System.out.println(activities.get(i).getProfit());

		}*/
		
		int [][] Pre = new int[n+1][2*n+1];
		int [][] slDiff = new int[n+1][2*n+1];
		for(int i = 0; i<2*n+1; i++)
		{
			slDiff[0][i] = -1;
		}
		int c=0;
		
		for( int i = 1; i<n; i++)
		{
			for(int j=0; j<2*n+1; j++)
			{
				slDiff[i][j] = slDiff [i-1][j];
				Pre[i][j] = -1;
			}
			
			c=i-1;
			while ((activities.get(i).getStartTime() < activities.get(c).getFinishTime()) )
			{	
				c--;
			}
			if (activities.get(i).getFinishTime() - activities.get(i).getStartTime() <5)
			{
				if ( slDiff[c][n] == -1)
				{
					slDiff[i][n+1] = activities.get(i).getProfit();
					Pre[i][n+1] = -5;
				}
				for(int k =1; k<2*n; k++)
				{
					if ((slDiff[i][k] < slDiff[c][k-1] + activities.get(i).getProfit()) && slDiff[c][k-1] > -1) //&& (activities.get(c).getFinishTime()>0)
					{
						slDiff[i][k] = slDiff[c][k-1] + activities.get(i).getProfit();
						Pre[i][k] = c;
						
					}
					
				}
			}
			else 
			{
				if ( slDiff[c][n] == -1)
				{
					slDiff[i][n-1] = activities.get(i).getProfit();
					Pre[i][n+1] = -5;
				}
				for(int k =0; k<2*n-1; k++)
				{
					if ((slDiff[i][k] < slDiff[c][k+1] + activities.get(i).getProfit()) && slDiff[c][k+1] > -1) //&& (activities.get(c).getFinishTime()>0)
					{
						slDiff[i][k] = slDiff[c][k+1] + activities.get(i).getProfit();
						Pre[i][k] = c;
					}
				}
			}
			
		}
		
		int r=0;
		int pMax=0;
		for(int i=n+1;i<2*n+1;i++)
		{
			if(pMax<slDiff[n-1][i])
			{
				pMax = slDiff[n-1][i];
				r = i;
			}
			
		}
		System.out.println();
		System.out.println("Profit = "+pMax);
		System.out.println("Excess Small = " + (r-n));
		
		System.out.println();
		
		int k = n-1;
		while (k>=0)
		{
			
			if(Pre[k][r] > 0 || Pre[k][r] == -5)
			{
				if(activities.get(k).getFinishTime() - activities.get(k).getStartTime()<5)
				{
					System.out.print("[S]");
				}
				else
				{
				
					System.out.print("[B]");
				
				}
				System.out.print(activities.get(k).getStartTime()+"  ");
				System.out.print(activities.get(k).getFinishTime()+"  ");
				System.out.println(activities.get(k).getProfit()+ "  ");
				if(activities.get(k).getFinishTime() - activities.get(k).getStartTime()<5)
				{
					k = Pre[k][r];
					r=r-1;
				}
				else
				{
					k = Pre[k][r];
					r++;
				}
			}
			else
			{
				k = k-1;
			}
					
		}
				
    }
       
}

