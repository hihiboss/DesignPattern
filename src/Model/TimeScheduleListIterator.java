package Model;

public class TimeScheduleListIterator implements Iterator {
    private TimeScheduleList timeScheduleList;
    private int index;

    public TimeScheduleListIterator(TimeScheduleList timeScheduleList) {
        this.timeScheduleList = timeScheduleList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < timeScheduleList.getLength()) {
            return true;
        }

        return false;
    }

    @Override
    public Object next() {
        TimeSchedule timeSchedule = timeScheduleList.getTimeScheduleAt(index);
        index++;
        return timeSchedule;
    }
}
