package Model;

import java.util.*;

public class TimeScheduleList {
	private ArrayList<TimeSchedule> timeScheduleList = new ArrayList<>();


	public void addTimeSchedule(TimeSchedule t){
		timeScheduleList.add(t);
	}
	public ArrayList<TimeSchedule> getTimeschedulelist(){
		return this.timeScheduleList;
	}
}
