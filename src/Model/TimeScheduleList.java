package Model;

import java.util.*;

public class TimeScheduleList {
	private static final TimeScheduleList ourInstance = new TimeScheduleList();
	public static TimeScheduleList getInstance() {
		return ourInstance;
	}
	
	private ArrayList<TimeSchedule> timeschedulelist = new ArrayList<TimeSchedule>();
	
	public void addTimeSchedule(TimeSchedule t){
		timeschedulelist.add(t);
	}
	public ArrayList<TimeSchedule> getTimeschedulelist(){
		return this.timeschedulelist;
	}
}
