package Model;

import java.util.ArrayList;

public class TimeSchedule {
    private int year;
    private int month;
    private int date;
    private TheaterList theaterList = new TheaterList();
    private MovieList mList = new MovieList();


    public void setTheaterlist(TheaterList theaterList) {
        this.theaterList = theaterList;
    }
    public MovieList getmList() {
        return mList;
    }
    public void setmList(MovieList mList) {
        Iterator it = mList.iterator();

        while (it.hasNext()) {
            this.mList.addMovie((Movie) it.next());
        }
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public TheaterList getTheaterlist() {
        return theaterList;
    }
}
