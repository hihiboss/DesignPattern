package Model;

import Controller.SubjectTimeSchedule;
import View.UpdateObserver;

import java.util.*;

public class TimeScheduleList implements Aggregate, SubjectTimeSchedule {
    private ArrayList<TimeSchedule> timeschedulelist = new ArrayList<>();
    private ArrayList<UpdateObserver> observers = new ArrayList<>();

    public TimeSchedule getTimeScheduleAt(int index) {
        return timeschedulelist.get(index);
    }

    public void addTimeSchedule(TimeSchedule timeSchedule) {
        this.timeschedulelist.add(timeSchedule);

    }

    public void complete(int index){
        updateSubject(index);
    }

    public int getLength() {
        return timeschedulelist.size();
    }

    public void clear() {
        this.timeschedulelist.clear();
    }

    @Override
    public Iterator iterator() {
        return new TimeScheduleListIterator(this);
    }

    @Override
    public void add(UpdateObserver o) {
        observers.add(o);
    }

    @Override
    public void remove(UpdateObserver o) {
        observers.remove(o);
    }

    @Override
    public void updateSubject(Object index) {
        for (int i = 0; i < observers.size(); i++){
            observers.get(i).update(index);
        }
    }
}
