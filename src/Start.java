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

        Verify verifyAdd = new VerifyAddMovie(gui.getMoviePanel(), gui.getAddition());
        Verify verifyCheck_play = new VerifyCheckType(gui.getMoviePanel(), 0);
        Verify verifyCheck_beforeplay = new VerifyCheckType(gui.getMoviePanel(), 1);

        AdditionListener additionListener = new AdditionListener(gui.getMoviePanel(), gui.getAddition(), gui.getInputMovie(), totalMovieList);
        AgeListener ageListener = new AgeListener(gui.getMoviePanel(), verifyAdd);
        BeforePlayListener beforePlayListener = new BeforePlayListener(gui.getMoviePanel(), verifyCheck_beforeplay);
        CalenderListener calenderListener = new CalenderListener(gui.getCalender(), gui.getSchedulePanel());
        DateSalesListener dateSalesListener = new DateSalesListener(gui.getMoviePanel(), verifyAdd);
        ExeListener exeListener = new ExeListener(gui.getCalender(), gui.getSchedulePanel(), gui.getInputMovie(), timeScheduleList, totalMovieList);
        ExpectationListener expectationListener = new ExpectationListener(gui.getMoviePanel(),verifyAdd);
        GenreListener genreListener = new GenreListener(gui.getMoviePanel(), verifyAdd);
        NationListener nationListener = new NationListener(gui.getMoviePanel(), verifyAdd);
        PlayListener playListener = new PlayListener(gui.getMoviePanel(), verifyCheck_play);
        ReleaseDateListener releaseDateListener = new ReleaseDateListener(gui.getMoviePanel(), verifyAdd);
    }
}
