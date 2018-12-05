package Controller;

import Model.TimeScheduleList;
import View.Observer;

import java.util.ArrayList;

public class SubjectSchedule {
    private ArrayList<Observer> observers = new ArrayList<>();
    public TimeScheduleList timeScheduleList;

    public TimeScheduleList getTimeScheduleList() {
        return timeScheduleList;
    }

    public void setTimeScheduleList(TimeScheduleList timeScheduleList) {
        this.timeScheduleList = timeScheduleList;
    }

    public void add(Observer o) {
        observers.add(o);
    }

    private void updateSubject() {
        for (Observer observer : observers) {
            observer.update(timeScheduleList);
        }
    }
}
