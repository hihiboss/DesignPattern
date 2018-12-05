package Model;

import java.util.*;

public class TimeScheduleList implements Aggregate {
    private static final TimeScheduleList ourInstance = new TimeScheduleList();
    public static TimeScheduleList getInstance() {
        return ourInstance;
    }

    private ArrayList<TimeSchedule> timeschedulelist = new ArrayList<>();

    public TimeSchedule getTimeScheduleAt(int index) {
        return timeschedulelist.get(index);
    }

    public void addTimeSchedule(TimeSchedule timeSchedule) {
        this.timeschedulelist.add(timeSchedule);
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
}
