package aspfinal;

public class Activity {

	private int startTime;
	private int finishTime;
	private int profit;
	
	public Activity(){}
	public Activity(int startTime,int finishTime,int profit){
		this.finishTime=finishTime;
		this.profit=profit;
		this.startTime=startTime;
	}
	
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	
	
}
