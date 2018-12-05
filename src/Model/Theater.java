package Model;

import java.util.*;

public class Theater {
   private ArrayList <Movie> movieList = new ArrayList<Movie>();
   private int playTime = 0;
   private int seatingCapacity = 0;
   private int startTime = 0;
   
   public ArrayList<Movie> getMovieList() {
	   return movieList;
   }
   public void addMovieList(int get, Movie element){
	   this.movieList.add(get, element);
   }
   public int getPlayTime() {
	   return playTime;
   }
   public void setPlayTime(int playTime) {
	   this.playTime = playTime;
   }
   public Theater(int seatingCapacity, int start){
	   this.seatingCapacity = seatingCapacity;
	   this.startTime = start;
   }
   public int getSeatingCapacity() {
	   return seatingCapacity;
   }
   public int getStartTime() {
	   return startTime;
   }
   public void setStartTime(int startTime) {
	   this.startTime = startTime;
   }
}