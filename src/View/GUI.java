package View;

import java.awt.*;

import Controller.*;

import javax.swing.*;

public class GUI extends JFrame {
    private MoviePanel moviePanel;
    private AddMoviePanel addition;
    private InputMoviePanel inputMovie;
    private SchedulePanel schedulePanel;
    private Calender calender;

    public MoviePanel getMoviePanel() {
        return moviePanel;
    }

    public AddMoviePanel getAddition() {
        return addition;
    }

    public Calender getCalender() {
        return calender;
    }

    public InputMoviePanel getInputMovie() {
        return inputMovie;
    }

    public SchedulePanel getSchedulePanel() {
        return schedulePanel;
    }

    public GUI() {
        this.setTitle("Movie Scheduling");

        JPanel West = new JPanel();
        West.setLayout(new BorderLayout());

        schedulePanel = new SchedulePanel();
        calender = new Calender();
        West.add(calender, BorderLayout.CENTER);

        inputMovie = new InputMoviePanel();

        addition = new AddMoviePanel();
        moviePanel = new MoviePanel(addition);

        moviePanel.add(addition);
        moviePanel.add(new JLabel(""));

        moviePanel.add(new JLabel(""));

        moviePanel.add(schedulePanel);
        moviePanel.add(new JLabel(""));
        moviePanel.add(new JLabel(""));

        JPanel East = new JPanel();
        East.setLayout(new GridLayout(1, 2));
        East.add(inputMovie);
        East.add(moviePanel);

        this.setLayout(new GridLayout(1, 2));
        this.add(West);
        this.add(East);
        this.setVisible(true);
        this.setSize(2300, 1000);
    }
}
