package Model;

import java.util.ArrayList;

public class TheaterList implements Aggregate {
    private ArrayList<Theater> theaterList = new ArrayList<Theater>();

    public TheaterList() {
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

    public Theater getTheaterAt(int index) {
        return theaterList.get(index);
    }

    public void addTheater(Theater theater) {
        this.theaterList.add(theater);
    }

    public int getLength() {
        return theaterList.size();
    }

    @Override
    public Iterator iterator() {
        return new TheaterListIterator(this);
    }

    public void setTimeList(int get, TotalMovieList totalMovieList) {
        totalMovieList.setPriority();
        String name = "";
        int index = 0;
        int location = 0;
        int priority = 1;
        for (int h = 0; h < totalMovieList.getPriorityList().size(); h++){
            if (totalMovieList.getPriorityList().get(h) == priority){
                index = h;
                name = totalMovieList.getMovieNameList().get(h);
                break;
            }
        }

        for (int h = 0; h < totalMovieList.getMovieList().getLength(); h++){
            if (totalMovieList.getMovieNumberList().get(index) == 0){
                priority++;
                for (int i = 0; i < totalMovieList.getPriorityList().size(); i++){
                    if (totalMovieList.getPriorityList().get(i) == priority){
                        index = i;
                        name = totalMovieList.getMovieNameList().get(i);
                        h = -1;
                        location--;
                        break;
                    }
                }
            }
            else {
                if (name.equals(totalMovieList.getMovieList().getMovieAt(h).getName())){
                    if (this.theaterList.get(get).getPlayTime() > 1440){
                        location--;
                        if (location%2 == 0){
                            totalMovieList.getMovieList().addMovieAt(h,
                                    this.theaterList.get(get).getMovieList().getMovieAt(0));
                            this.theaterList.get(get).getMovieList().removeMovieAt(0);
                            totalMovieList.getMovieNumberList().set(index,
                                    totalMovieList.getMovieNumberList().get(index)+1);
                        }
                        else{
                            totalMovieList.getMovieList().addMovieAt(h,
                                    this.theaterList.get(get).getMovieList().getMovieAt(
                                            this.theaterList.get(get).getMovieList().getLength()-1));
                            this.theaterList.get(get).getMovieList().removeMovieAt(
                                    this.theaterList.get(get).getMovieList().getLength()-1);
                            totalMovieList.getMovieNumberList().set(index,
                                    totalMovieList.getMovieNumberList().get(index)+1);
                        }
                        break;
                    }
                    if (location % 2 == 0){
                        this.theaterList.get(get).getMovieList().addMovieAt(0,
                                totalMovieList.getMovieList().getMovieAt(h));
                        this.theaterList.get(get).setPlayTime(
                                this.theaterList.get(get).getPlayTime()
                                        + totalMovieList.getMovieList().getMovieAt(h).getTime());
                        totalMovieList.getMovieList().removeMovieAt(h);
                        h = -1;
                        totalMovieList.getMovieNumberList().set(index,
                                totalMovieList.getMovieNumberList().get(index)-1);
                    }
                    else {
                        this.theaterList.get(get).getMovieList().addMovie(
                                totalMovieList.getMovieList().getMovieAt(h));
                        this.theaterList.get(get).setPlayTime(
                                this.theaterList.get(get).getPlayTime()
                                        + totalMovieList.getMovieList().getMovieAt(h).getTime());
                        totalMovieList.getMovieList().removeMovieAt(h);
                        h = -1;
                        totalMovieList.getMovieNumberList().set(index,
                                totalMovieList.getMovieNumberList().get(index)-1);
                    }
                    location++;
                }
            }
        }
    }
}
