package Model;

import java.util.ArrayList;

public class TotalMovieList {
	private static final TotalMovieList ourInstance = new TotalMovieList();
	public static TotalMovieList getInstance() {
		return ourInstance;
	}
	private final ArrayList<Integer> movieNumberList = new ArrayList<Integer>();
	private final ArrayList<Movie> movieList = new ArrayList<Movie>();
	private final ArrayList<Movie> mList = new ArrayList<Movie>();
	private final ArrayList<Movie> mSortList = new ArrayList<Movie>();
	private final ArrayList<String> movieNameList = new ArrayList<String>();
	private final ArrayList<Integer> priorityList = new ArrayList<Integer>();
	private int totalNumberMovie;

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public ArrayList<String> getMovieNameList() {
		return movieNameList;
	}

	public ArrayList<Integer> getPriorityList() {
		return priorityList;
	}

	public ArrayList<Integer> getMovieNumberList() {
		return movieNumberList;
	}

	public void addMList(Movie movie) {
		this.mList.add(movie);
	}

	public ArrayList<Movie> getmList() {
		return mList;
	}

	public ArrayList<Movie> getmSortList() {
		return mSortList;
	}

	public void q_sort(Movie[] movieArray, int left, int right){
		int l_hold, r_hold, pivot_index;
		Movie pivot;
		l_hold = left;
		r_hold = right;
		pivot_index = left;
		pivot = movieArray[left];
		while (left < right){
			while((movieArray[right].getPercentSales() <= pivot.getPercentSales()) && (left < right)){
				right--;
			}

			if (left != right){
				movieArray[left] = movieArray[right];
			}

			while ((movieArray[left].getPercentSales() >= pivot.getPercentSales()) && (left < right)){
				left++;
			}

			if (left != right){
				movieArray[right] = movieArray[left];
				right--;
			}
		}

		movieArray[left] = pivot;
		pivot_index = left;
		left = l_hold;
		right = r_hold;

		if (left < pivot_index){
			q_sort(movieArray, left, pivot_index - 1);
		}
		if (right > pivot_index){
			q_sort(movieArray, pivot_index + 1, right);
		}
	}

	public void setMSortlist() {
		Movie[] mArray = new Movie[mList.size()];
		Movie temp;

		for (int h = 0; h < mList.size(); h++){
			mArray[h] = this.mList.get(h);
		}
		if (mList.size() <= 15){
			for (int h = 0; h < mList.size(); h++){
				for (int i = 0; i < mList.size() - (h + 1); i++){
					if (mArray[i].getPercentSales() < mArray[i + 1].getPercentSales()){
						temp = mArray[i + 1];
						mArray[i + 1] = mArray[i];
						mArray[i] = temp;
					}
				}
			}
		}
		else {
			q_sort(mArray, 0 , mList.size()-1);
		}

		for (int h = 0; h < 4; h++){
			this.mSortList.add(mArray[h]);
		}
		for (int h = 4; h < mList.size(); h++){
			if (mArray[h].getPercentSales() >= 0.04){
				this.mSortList.add(mArray[h]);
			}
		}
	}

	public void setTotalNumberMovie() {
		double total = 0;
		int number = 0;
		for (Movie m : this.mList){
			total += m.getTime()*m.getPercentSales();
		}
		if(total != 0){
			number = (int)(24 * 6 * 60 / total);
		}
		number += (6 - number%6);
		this.totalNumberMovie = number;
	}

	public void setPriority(){
		this.priorityList.clear();
		int[] number = new int[this.movieNumberList.size()];
		int temp;
		for (int h = 0; h < this.movieNumberList.size(); h++){
			number[h] = movieNumberList.get(h);
		}
		for (int h = 0; h < movieNumberList.size(); h++){
			for (int i = 0; i < movieNumberList.size() - (h + 1); i++){
				if (number[i] < number[i + 1]){
					temp = number[i];
					number[i] = number[i+1];
					number[i+1] = temp;
				}
			}
		}
		int priority = 1;
		int[] prior = new int[this.movieNumberList.size()];
		for (Integer i : this.movieNumberList){
			for (int h = 0; h < this.movieNumberList.size(); h++){
				if (number[h] == i){
					if (prior[h] != 0){
						continue;
					}
					else{
						prior[h] = priority;
						priority++;
						break;
					}
				}
			}
		}
		for (int h = 0; h < this.movieNumberList.size(); h++){
			this.priorityList.add(prior[h]);
		}
	}
	
	public void setTimeList() {
		int h;
		for (Movie m : this.mSortList){
			for (h = 0; h < (int)(this.totalNumberMovie * m.getPercentSales()); h++){
				this.movieList.add(m);
			}
			h--;
			int number = h;
			this.movieNumberList.add(number);
			String name = m.getName();
			this.movieNameList.add(name);
		}
	}

	public int getTotalNumberMovie() {
		return totalNumberMovie;
	}
	
	public void setClear(){
		this.mList.clear();
		this.mSortList.clear();
		this.movieList.clear();
		this.movieNumberList.clear();
		this.movieNameList.clear();
		this.priorityList.clear();
		this.totalNumberMovie = 0;
	}
}
