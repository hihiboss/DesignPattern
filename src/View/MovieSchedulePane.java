package View;

import java.awt.*;

import Model.*;

import javax.swing.*;

public class MovieSchedulePane extends JFrame{

    private int width, height;        //size

    public MovieSchedulePane(MovieSchedulePanel movieSchedulePanel) {        //6개의 요일 영화 list를 불러온다

        //기본 size 설정
        setTitle("show movie time");
        width = 1490;
        height = 600;
        setSize(width, height);
        setVisible(true);

        //contentpane을 설정
        setContentPane(movieSchedulePanel);
    }
}
