package View;

import java.awt.*;

import Model.*;

import javax.swing.*;

public class MovieSchedulePane extends JFrame{

    private int width, height;        //size

    public MovieSchedulePane(MovieSchedulePanel movieSchedulePanel) {        //6���� ���� ��ȭ list�� �ҷ��´�

        //�⺻ size ����
        setTitle("show movie time");
        width = 1490;
        height = 600;
        setSize(width, height);
        setVisible(true);

        //contentpane�� ����
        setContentPane(movieSchedulePanel);
    }
}
