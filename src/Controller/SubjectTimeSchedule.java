package Controller;


import View.UpdateObserver;

public interface SubjectTimeSchedule {
    public void add(UpdateObserver o);
    public void remove(UpdateObserver o);
    public void updateSubject(Object index);
}
