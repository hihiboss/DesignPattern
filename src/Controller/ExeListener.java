package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Model.Movie;
import Model.TimeScheduleList;
import Model.TotalMovieList;
import View.*;

public class ExeListener implements ActionListener {

	private CalenderInterface calender;
	private SchedulePanelInterface schedulePanel;
	private InputMoviePanelInterface inputMoviePanel;
	private TimeScheduleList timeScheduleList;
	private TotalMovieList totalMovieList;

	public ExeListener (CalenderInterface calender, SchedulePanelInterface schedulePanel
			, InputMoviePanelInterface inputMoviePanel, TimeScheduleList timeScheduleList, TotalMovieList totalMovieList){
		this.calender = calender;
		this.totalMovieList = totalMovieList;
		this.schedulePanel = schedulePanel;
		this.inputMoviePanel = inputMoviePanel;
		this.timeScheduleList = timeScheduleList;
		schedulePanel.setExecutionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton b = (JButton)e.getSource();
		switch(b.getText()){
			case "실행":
				for (int h = 0; h < totalMovieList.getmList().getLength(); h++){
					totalMovieList.getmList().getMovieAt(h).setPercentSales();
				}
				if (totalMovieList.getmList().getLength() >= 4 && calender.getDay() != -1){
					totalMovieList.setTotalNumberMovie();
					totalMovieList.setMSortlist();
					totalMovieList.setTimeList();
					// 시간 조정... -> 이건 TimeScheduling 한후 해야됨.
					for (int h = 0; h < 49; h++){
						if (calender.getCalButton(h).getText().equals(Integer.toString(calender.getDay()))){
							if (h % 7 == 6){
								for(int i=0; i < 6; i++){
									timeScheduleList.getTimeScheduleAt(
											calender.getDay()+1).getTheaterlist().setTimeList(i, totalMovieList);
									calender.getCalButton(h+2).setBackground(Color.PINK);
									timeScheduleList.getTimeScheduleAt(
											calender.getDay()+2).getTheaterlist().setTimeList(i, totalMovieList);
									calender.getCalButton(h+3).setBackground(Color.PINK);


								}
								MovieSchedulePanel movieSchedulePanel = new MovieSchedulePanel();
								MovieSchedulePane pane = new MovieSchedulePane(movieSchedulePanel);

								timeScheduleList.add(movieSchedulePanel);

								timeScheduleList.updateSubject(timeScheduleList.getTimeScheduleAt(calender.getDay()+1));

								timeScheduleList.remove(movieSchedulePanel);
							}
							else if (h % 7 == 0){
								for(int i=0; i < 6; i++){
									timeScheduleList.getTimeScheduleAt(
											calender.getDay()+2).getTheaterlist().setTimeList(i, totalMovieList);
									calender.getCalButton(h+3).setBackground(Color.PINK);
									timeScheduleList.getTimeScheduleAt(
											calender.getDay()+3).getTheaterlist().setTimeList(i, totalMovieList);
									calender.getCalButton(h+4).setBackground(Color.PINK);
								}
								MovieSchedulePanel movieSchedulePanel = new MovieSchedulePanel();
								MovieSchedulePane pane = new MovieSchedulePane(movieSchedulePanel);

								timeScheduleList.add(movieSchedulePanel);

								timeScheduleList.updateSubject(timeScheduleList.getTimeScheduleAt(calender.getDay()+2));
								timeScheduleList.remove(movieSchedulePanel);
							}
							else {
								for(int i=0; i < 6; i++){
									timeScheduleList.getTimeScheduleAt(calender.getDay()+1).getTheaterlist().setTimeList(i, totalMovieList);
									calender.getCalButton(h+2).setBackground(Color.PINK);
								}
								MovieSchedulePanel movieSchedulePanel = new MovieSchedulePanel();
								MovieSchedulePane pane = new MovieSchedulePane(movieSchedulePanel);

								timeScheduleList.add(movieSchedulePanel);

								timeScheduleList.updateSubject(timeScheduleList.getTimeScheduleAt(calender.getDay()+1));
								timeScheduleList.remove(movieSchedulePanel);
							}
						}
					}

					//
					//**********************************************************
					//*****************TimeScheduling***************************
					//**********************************************************
					//

					// ButtonSet
					for (JButton n : calender.getCalBtn()){
						if (n.getText().equals(Integer.toString(calender.getDay()))){
							n.setEnabled(true);
						}
					}
					schedulePanel.getExecution().setEnabled(false);
					Movie.setTotalSales(0);
					totalMovieList.setClear();
					inputMoviePanel.getModel().setNumRows(0);
					Movie.setTotalSales(0);
				}
				break;
			default:
				break;
		}
	}
}