package aspfinal;

import java.util.Comparator;

public class ActivityComparator implements Comparator<Activity> {

	@Override
	public int compare(Activity a1, Activity a2) {
		// TODO Auto-generated method stub
		return a1.getFinishTime()-a2.getFinishTime();
	}

}
