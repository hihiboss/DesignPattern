package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import Model.*;
import View.*;

public class AdditionListener implements ActionListener {
	private double dateSales;
	private String name;
	private int playTime;
	private double expect;
	private int releaseDate;
	private String genre;
	private String nation;
	private int age;

	public AdditionListener(double dateSales, String name, int playTime, double expect, int releaseDate,
							String genre, int age, String nation) {
		this.dateSales = dateSales;
		this.name = name;
		this.playTime = playTime;
		this.expect = expect;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.age = age;
		this.nation = nation;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (GUI.getInstance().addInformation.isEnabled() == true){
			if (GUI.getInstance().play.isSelected() == true){

				if (dateSales != -1 &&
						name != null &&
						playTime != -1){
					Movie movie = MovieFactory.getMovie(new ShowingMovieFactory(dateSales));
					movie.setName(name);
					movie.setTime(playTime);
					TotalMovieList.getInstance().addMList(movie);
					GUI.getInstance().addInformation.setEnabled(false);
					GUI.getInstance().title_t.setText("");
					GUI.getInstance().playtime_t.setText("");
					GUI.getInstance().datesales_t.setText("");
					GUI.getInstance().play.setSelected(false);
					GUI.getInstance().userRow = new Vector<String>();
					GUI.getInstance().userRow.addElement(movie.getName());
					GUI.getInstance().userRow.addElement(Integer.toString(movie.getTime()));
					GUI.getInstance().userRow.addElement(Double.toString(movie.getSales()));
					GUI.getInstance().model.addRow(GUI.getInstance().userRow);
				}
			}
			else if (GUI.getInstance().beforeplay.isSelected() == true){
				if (GUI.getInstance().genre_e.getSelectedIndex() != 0 &&
						GUI.getInstance().nation_e.getSelectedIndex() != 0 &&
						GUI.getInstance().age_e.getSelectedIndex() != 0 &&
						expect != -1 &&
						name != null &&
						playTime != -1 &&
						releaseDate != -1){
					Movie movie = MovieFactory.getMovie(new PreShowingMovieFactory(genre, age, expect, nation));
					movie.setName(name);
					movie.setTime(playTime);
					TotalMovieList.getInstance().addMList(movie);
					GUI.getInstance().addInformation.setEnabled(false);
					GUI.getInstance().title_t.setText("");
					GUI.getInstance().playtime_t.setText("");
					GUI.getInstance().genre_e.setSelectedIndex(0);
					GUI.getInstance().nation_e.setSelectedIndex(0);
					GUI.getInstance().age_e.setSelectedIndex(0);
					GUI.getInstance().expectation_t.setText("");
					GUI.getInstance().releasedate_e.setSelectedIndex(0);
					GUI.getInstance().beforeplay.setSelected(false);
					GUI.getInstance().userRow = new Vector<String>();
					GUI.getInstance().userRow.addElement(movie.getName());
					GUI.getInstance().userRow.addElement(Integer.toString(movie.getTime()));
					GUI.getInstance().userRow.addElement(Double.toString(movie.getSales()));
					GUI.getInstance().model.addRow(GUI.getInstance().userRow);
				}
			}
			Controller.getInstance().setName(null);
			Controller.getInstance().setPlayTime(-1);
			Controller.getInstance().setDateSales(-1);
			Controller.getInstance().setGenre(null);
			Controller.getInstance().setAge(0);
			Controller.getInstance().setExpect(-1);
			Controller.getInstance().setNation(null);
			Controller.getInstance().setReleaseDate(-1);
		}
	}
}
