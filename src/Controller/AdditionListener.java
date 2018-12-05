package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import Model.*;
import View.*;

public class AdditionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (GUI.getInstance().addInformation.isEnabled() == true){
			if (GUI.getInstance().play.isSelected() == true){
				if (Controller.getInstance().getDateSales() != -1 &&
						Controller.getInstance().getName() != null &&
						Controller.getInstance().getPlayTime() != -1){
					ShowingMovie movie = new ShowingMovie(Controller.getInstance().getDateSales());
					movie.setName(Controller.getInstance().getName());
					movie.setTime(Controller.getInstance().getPlayTime());
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
						Controller.getInstance().getExpect() != -1 &&
						Controller.getInstance().getName() != null &&
						Controller.getInstance().getPlayTime() != -1 &&
						Controller.getInstance().getReleaseDate() != -1){
					PreShowingMovie movie = new PreShowingMovie(
							Controller.getInstance().getGenre()
							,Controller.getInstance().getAge()
							,Controller.getInstance().getExpect()
							,Controller.getInstance().getNation());
					movie.setName(Controller.getInstance().getName());
					movie.setTime(Controller.getInstance().getPlayTime());
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
