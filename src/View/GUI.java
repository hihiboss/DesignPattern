package View;

import java.awt.*;

import Controller.*;

import javax.swing.*;

public class GUI extends JFrame {
    public GUI() {
        this.setTitle("Movie Scheduling");

        JPanel West = new JPanel();
        West.setLayout(new BorderLayout());

        SchedulePanel schedulePanel = new SchedulePanel();
        Calender calender = new Calender(schedulePanel.getExecution());
        West.add(calender, BorderLayout.CENTER);

        InputMoviePanel inputMovie = new InputMoviePanel();

        MoviePanel moviePanel = new MoviePanel();


        AddMoviePanel addition = new AddMoviePanel();
        AdditionListener additionlistener = new AdditionListener();
        addition.getAddInformation().addActionListener(additionlistener);

        ExeListener exelistener = new ExeListener();
        schedulePanel.getExecution().addActionListener(exelistener);

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

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
