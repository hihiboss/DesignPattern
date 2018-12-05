package Controller;

import View.Observer;

public interface SubjectTheaterList {
    public void add(Observer o);
    public void remove(Observer o);
    public void updateSubject(int index);
}
