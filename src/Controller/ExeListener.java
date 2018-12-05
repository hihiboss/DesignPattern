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
import View.GUI;
import View.MovieSchedulePane;

public class ExeListener implements ActionListener {

	private Calender calender;
	private JButton execution;
	private DefaultTableModel model;
	private TimeScheduleList timeScheduleList;

	public ExeListener (Calender calender, JButton execution, DefaultTableModel model, TimeScheduleList timeScheduleList){
		this.calender = calender;
		this.execution = execution;
		this.model = model;
		this.timeScheduleList = timeScheduleList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton b = (JButton)e.getSource();
		switch(b.getText()){
		case "실행":
			for (int h = 0; h < TotalMovieList.getInstance().getmList().size(); h++){
				TotalMovieList.getInstance().getmList().get(h).setPercentSales();
			}
			if (TotalMovieList.getInstance().getmList().size() >= 4 && Controller.getInstance().getDay() != -1){
				TotalMovieList.getInstance().setTotalNumberMovie();
				TotalMovieList.getInstance().setMSortlist();
				TotalMovieList.getInstance().setTimeList();
				// 시간 조정... -> 이건 TimeScheduling 한후 해야됨.
				for (int h = 0; h < 49; h++){
					if (calender.calBtn[h].getText().equals(Integer.toString(Controller.getInstance().getDay()))){
						if (h % 7 == 6){
							for(int i=0; i < 6; i++){
								timeScheduleList.getTimeschedulelist().get(
										Controller.getInstance().getDay()+1).getTheaterlist().setTimeList(i);
								calender.calBtn[h+2].setBackground(Color.PINK);
								timeScheduleList.getTimeschedulelist().get(
										Controller.getInstance().getDay()+2).getTheaterlist().setTimeList(i);
								calender.calBtn[h+3].setBackground(Color.PINK);
								
								
							}
							MovieSchedulePane pane = new MovieSchedulePane(timeScheduleList.getTimeschedulelist().get(
									Controller.getInstance().getDay()+1));
						}
						else if (h % 7 == 0){
							for(int i=0; i < 6; i++){
								timeScheduleList.getTimeschedulelist().get(
										Controller.getInstance().getDay()+2).getTheaterlist().setTimeList(i);
								calender.calBtn[h+3].setBackground(Color.PINK);
								TimeScheduleList.getInstance().getTimeschedulelist().get(
										Controller.getInstance().getDay()+3).getTheaterlist().setTimeList(i);
								calender.calBtn[h+4].setBackground(Color.PINK);
							}
							MovieSchedulePane pane = new MovieSchedulePane(timeScheduleList.getTimeschedulelist().get(
									Controller.getInstance().getDay()+2));
						}
						else {
							for(int i=0; i < 6; i++){
								timeScheduleList.getTimeschedulelist().get(
										Controller.getInstance().getDay()+1).getTheaterlist().setTimeList(i);
								calender.calBtn[h+2].setBackground(Color.PINK);
							}
							MovieSchedulePane pane = new MovieSchedulePane(timeScheduleList.getTimeschedulelist().get(
									Controller.getInstance().getDay()+1));
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
					if (n.getText().equals(Integer.toString(Controller.getInstance().getDay()))){
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
