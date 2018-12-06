package View;

import Model.TimeSchedule;
import Model.TimeScheduleList;

import javax.swing.*;
import java.awt.*;

public class MovieSchedulePanel extends JPanel implements UpdateObserver {

    private Graphics2D g;
    private int width;
    private int height;

    public MovieSchedulePanel() {
        width = 1490;
        height = 600;
        setSize(width, height);
    }

    public void paintComponent(Graphics gp) {

        g = (Graphics2D) gp;

        //큰 테두리 그리기
        g.setColor(Color.black);
        g.drawRect(0, 0, width, height);

        //배경색글 흰색으로
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        //기본 테두리 그리기
        g.setColor(Color.black);
        for (int i = 0; i < 6; i++)
            g.drawLine(0, height / 6 * i, width, height / 6 * i);
        g.drawLine(50, 0, 50, height);

        //관표시하기
        for (int i = 0; i < 6; i++)
            g.drawString(i + 1 + "관", 20, height / 6 * i + height / 12);

    }

    @Override
    public void update(Object data) {
        TimeSchedule timeschedule = (TimeSchedule) data;
        int startx = 50;                        //출력이 시간되는 x축의 좌표
        int timewidth = width - startx;                    //전체시간의 길이
        int breaktime = timewidth * 20 / 60 / 24;            //쉬는시간의 길이s
        //영화배치표를 그리기
        for (int j = 0; j < 6; j++)        //6관까지
        {
            int writespot = startx;
            int hour = timeschedule.getTheaterlist().getTheaterAt(j).getStartTime() / 60;
            int minute = timeschedule.getTheaterlist().getTheaterAt(j).getStartTime() % 60;

            for (int i = 0; i < timeschedule.getTheaterlist().getTheaterAt(j).getMovieList().getLength(); i++)            //각 관의 상영횟수만큼 배치
            {
                g.drawString(timeschedule.getTheaterlist().getTheaterAt(j).getMovieList().getMovieAt(i).getName()
                        , writespot + startx / 10, height / 6 * j + height / 24);        //영화이름
                g.drawString(hour + "시 " + minute + "분", writespot + startx / 7, height / 6 * j + height / 12);
                writespot += ((timeschedule.getTheaterlist().getTheaterAt(j).getMovieList().getMovieAt(i).getTime()) / 60.0 / 24) * timewidth;
                minute += (timeschedule.getTheaterlist().getTheaterAt(j).getMovieList().getMovieAt(i).getTime() % 60);
                hour += (timeschedule.getTheaterlist().getTheaterAt(j).getMovieList().getMovieAt(i).getTime() / 60);
                if (minute >= 60) {
                    minute -= 60;
                    hour++;
                }
                g.drawLine(writespot, height / 6 * j, writespot, height / 6 * (j + 1));
                writespot -= breaktime;
                g.drawLine(writespot, height / 6 * j, writespot, height / 6 * (j + 1));
                writespot += breaktime;
            }
        }
        //상영관마다 상영횟수
    }
}
