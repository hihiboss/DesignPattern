package Model;

import java.util.ArrayList;

public class TimeSchedule {
	private int year;
	private int month;
	private int date;
	private TheaterList theaterlist = new TheaterList();
	private ArrayList<Movie> mList = new ArrayList<Movie>();
	
	
	public void setTheaterlist(TheaterList theaterlist) {
		this.theaterlist = theaterlist;
	}
	public ArrayList<Movie> getmList() {
		return mList;
	}
	public void setmList(ArrayList<Movie> mList) {
		for (Movie m : mList){
			this.mList.add(m);
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
		return theaterlist;
	}
}
