import Controller.*;
import Model.TheaterList;
import Model.TimeScheduleList;
import Model.TotalMovieList;
import View.GUI;

public class Start {

    public static void main(String args[]){
        TotalMovieList totalMovieList = new TotalMovieList();
        TheaterList theaterList = new TheaterList();
        TimeScheduleList timeScheduleList = new TimeScheduleList();

        GUI gui = new GUI();
        AdditionListener additionListener = new AdditionListener(gui.getMoviePanel(), gui.getAddition(), gui.getInputMovie(), totalMovieList);
        AgeListener ageListener = new AgeListener(gui.getMoviePanel(), gui.getAddition());
        BeforePlayListener beforePlayListener = new BeforePlayListener(gui.getMoviePanel());
        CalenderListener calenderListener = new CalenderListener(gui.getCalender(), gui.getSchedulePanel());
        DateSalesListener dateSalesListener = new DateSalesListener(gui.getMoviePanel(), gui.getAddition());
        ExeListener exeListener = new ExeListener(gui.getCalender(), gui.getSchedulePanel(), gui.getInputMovie(), timeScheduleList, totalMovieList);
        ExpectationListener expectationListener = new ExpectationListener(gui.getMoviePanel(), gui.getAddition());
        GenreListener genreListener = new GenreListener(gui.getMoviePanel(), gui.getAddition());
        NationListener nationListener = new NationListener(gui.getMoviePanel(), gui.getAddition());
        PlayListener playListener = new PlayListener(gui.getMoviePanel());
        ReleaseDateListener releaseDateListener = new ReleaseDateListener(gui.getMoviePanel(), gui.getAddition());
    }
}
