package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

import View.GUI;

public class GenreListener implements ItemListener {

	private double expect;
	private String name;
	private int playTime;
	private int releaseDate;

	public GenreListener(double expect, String name, int playTime, int releaseDate) {
		this.expect = expect;
		this.name = name;
		this.playTime = playTime;
		this.releaseDate = releaseDate;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		JComboBox b = (JComboBox)e.getSource();
		Controller.getInstance().setGenre((String)b.getSelectedItem());
		
		if (GUI.getInstance().genre_e.getSelectedIndex() != 0 &&
				GUI.getInstance().nation_e.getSelectedIndex() != 0 &&
				GUI.getInstance().age_e.getSelectedIndex() != 0 &&
				expect != -1 &&
				name != null &&
				playTime != -1 &&
				releaseDate != -1){
			GUI.getInstance().addInformation.setEnabled(true);
		}
	}
}
