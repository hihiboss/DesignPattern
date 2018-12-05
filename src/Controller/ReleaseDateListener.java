package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import View.GUI;

public class ReleaseDateListener implements ItemListener {

	private double expect;
	private String name;
	private int playTime;
	private int releaseDate;

	public ReleaseDateListener(double expect, String name, int playTime, int releaseDate) {
		this.expect = expect;
		this.name = name;
		this.playTime = playTime;
		this.releaseDate = releaseDate;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		JComboBox b = (JComboBox)e.getSource();
		switch((String)b.getSelectedItem()){
		case"수요일":
			Controller.getInstance().setReleaseDate(0);
			break;
		case"목요일":
			Controller.getInstance().setReleaseDate(1);
			break;
		default:
			Controller.getInstance().setReleaseDate(-1);
			break;
		}

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
