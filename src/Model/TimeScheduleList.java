package Model;

import java.util.*;

public class TimeScheduleList {
	
	private ArrayList<TimeSchedule> timeschedulelist = new ArrayList<TimeSchedule>();
	
	public void addTimeSchedule(TimeSchedule t){
		timeschedulelist.add(t);
	}
	public ArrayList<TimeSchedule> getTimeschedulelist(){
		return this.timeschedulelist;
	}
}
