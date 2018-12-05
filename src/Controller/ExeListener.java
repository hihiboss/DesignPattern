package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Model.Movie;
import Model.TimeScheduleList;
import Model.TotalMovieList;
import View.Calender;
import View.MovieSchedulePane;

public class ExeListener implements ActionListener {

	private Calender calender;
	private JButton execution;
	private DefaultTableModel model;
	private TimeScheduleList timeScheduleList;
	private int day;

	public ExeListener (Calender calender, JButton execution, DefaultTableModel model, TimeScheduleList timeScheduleList,
						int day){
		this.calender = calender;
		this.execution = execution;
		this.model = model;
		this.timeScheduleList = timeScheduleList;
		this.day = day;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton b = (JButton)e.getSource();
		switch(b.getText()){
		case "실행":
			for (int h = 0; h < TotalMovieList.getInstance().getmList().getLength(); h++){
				TotalMovieList.getInstance().getmList().getMovieAt(h).setPercentSales();
			}
			if (TotalMovieList.getInstance().getmList().getLength() >= 4 && day != -1){
				TotalMovieList.getInstance().setTotalNumberMovie();
				TotalMovieList.getInstance().setMSortlist();
				TotalMovieList.getInstance().setTimeList();
				// 시간 조정... -> 이건 TimeScheduling 한후 해야됨.
				for (int h = 0; h < 49; h++){
					if (calender.calBtn[h].getText().equals(Integer.toString(day))){
						if (h % 7 == 6){
							for(int i=0; i < 6; i++){
								timeScheduleList.getTimeScheduleAt(
										day+1).getTheaterlist().setTimeList(i);
								calender.calBtn[h+2].setBackground(Color.PINK);
								timeScheduleList.getTimeScheduleAt(
										day+2).getTheaterlist().setTimeList(i);
								calender.calBtn[h+3].setBackground(Color.PINK);
								
								
							}
							MovieSchedulePane pane = new MovieSchedulePane(timeScheduleList.getTimeScheduleAt(day+1));
						}
						else if (h % 7 == 0){
							for(int i=0; i < 6; i++){
								timeScheduleList.getTimeScheduleAt(
										day+2).getTheaterlist().setTimeList(i);
								calender.calBtn[h+3].setBackground(Color.PINK);
								timeScheduleList.getTimeScheduleAt(
										day+3).getTheaterlist().setTimeList(i);
								calender.calBtn[h+4].setBackground(Color.PINK);
							}
							MovieSchedulePane pane = new MovieSchedulePane(timeScheduleList.getTimeScheduleAt(day+2));
						}
						else {
							for(int i=0; i < 6; i++){
								timeScheduleList.getTimeScheduleAt(day+1).getTheaterlist().setTimeList(i);
								calender.calBtn[h+2].setBackground(Color.PINK);
							}
							MovieSchedulePane pane = new MovieSchedulePane(timeScheduleList.getTimeScheduleAt(day+1));
						}
					}
				}
				
				//
				//**********************************************************
				//*****************TimeScheduling***************************
				//**********************************************************
				//
				
				// ButtonSet
				for (JButton n : calender.calBtn){
					if (n.getText().equals(Integer.toString(day))){
						n.setEnabled(true);
					}
				}
				execution.setEnabled(false);
				Movie.setTotalSales(0);
				TotalMovieList.getInstance().setClear();
				model.setNumRows(0);
				Movie.setTotalSales(0);
			}
			break;
		default:
			break;
		}
	}
}
