package Model;

import java.util.*;

public class TheaterList {
	private ArrayList<Theater> theaterList = new ArrayList<Theater>();
	
	public TheaterList(){
		Theater theater1 = new Theater(158, 360);
		Theater theater2 = new Theater(124, 370);
		Theater theater3 = new Theater(172, 360);
		Theater theater4 = new Theater(124, 380);
		Theater theater5 = new Theater(172, 370);
		Theater theater6 = new Theater(124, 380);
		this.theaterList.add(theater3);
		this.theaterList.add(theater5);
		this.theaterList.add(theater1);
		this.theaterList.add(theater2);
		this.theaterList.add(theater4);
		this.theaterList.add(theater6);
	}
	
	public ArrayList<Theater> getTheaterList() {
		return theaterList;
	}
	
	public void setTimeList(int get){
		TotalMovieList.getInstance().setPriority();
		String name = "";
		int index = 0;
		int location = 0;
		int priority = 1;
		for (int h = 0; h < TotalMovieList.getInstance().getPriorityList().size(); h++){
			if (TotalMovieList.getInstance().getPriorityList().get(h) == priority){
				index = h;
				name = TotalMovieList.getInstance().getMovieNameList().get(h);
				break;
			}
		}
		
		for (int h = 0; h < TotalMovieList.getInstance().getMovieList().size(); h++){
			if (TotalMovieList.getInstance().getMovieNumberList().get(index) == 0){
				priority++;
				for (int i = 0; i < TotalMovieList.getInstance().getPriorityList().size(); i++){
					if (TotalMovieList.getInstance().getPriorityList().get(i) == priority){
						index = i;
						name = TotalMovieList.getInstance().getMovieNameList().get(i);
						h = -1;
						location--;
						break;
					}
				}
			}
			else {
				if (name.equals(TotalMovieList.getInstance().getMovieList().get(h).getName())){
					if (this.theaterList.get(get).getPlayTime() > 1440){
						location--;
						if (location%2 == 0){
							TotalMovieList.getInstance().getMovieList().add(h,
									this.theaterList.get(get).getMovieList().get(0));
							this.theaterList.get(get).getMovieList().remove(0);
							TotalMovieList.getInstance().getMovieNumberList().set(index,
									TotalMovieList.getInstance().getMovieNumberList().get(index)+1);
						}
						else{
							TotalMovieList.getInstance().getMovieList().add(h,
									this.theaterList.get(get).getMovieList().get(
											this.theaterList.get(get).getMovieList().size()-1));
							this.theaterList.get(get).getMovieList().remove(
									this.theaterList.get(get).getMovieList().size()-1);
							TotalMovieList.getInstance().getMovieNumberList().set(index,
									TotalMovieList.getInstance().getMovieNumberList().get(index)+1);
						}
						break;
					}
					if (location % 2 == 0){
						this.theaterList.get(get).getMovieList().add(0,
								TotalMovieList.getInstance().getMovieList().get(h));
						this.theaterList.get(get).setPlayTime(
								this.theaterList.get(get).getPlayTime()
								+ TotalMovieList.getInstance().getMovieList().get(h).getTime());
						TotalMovieList.getInstance().getMovieList().remove(h);
						h = -1;
						TotalMovieList.getInstance().getMovieNumberList().set(index, 
								TotalMovieList.getInstance().getMovieNumberList().get(index)-1);
					}
					else {
						this.theaterList.get(get).getMovieList().add(
								TotalMovieList.getInstance().getMovieList().get(h));
						this.theaterList.get(get).setPlayTime(
								this.theaterList.get(get).getPlayTime()
								+ TotalMovieList.getInstance().getMovieList().get(h).getTime());
						TotalMovieList.getInstance().getMovieList().remove(h);
						h = -1;
						TotalMovieList.getInstance().getMovieNumberList().set(index, 
								TotalMovieList.getInstance().getMovieNumberList().get(index)-1);
					}
					location++;
				}
			}
		}
	}
}
