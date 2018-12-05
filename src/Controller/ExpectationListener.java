package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.GUI;

public class ExpectationListener implements ActionListener {

	private double expect;
	private String name;
	private int playTime;
	private int releaseDate;

	public ExpectationListener(double expect, String name, int playTime, int releaseDate) {
			this.expect = expect;
			this.name = name;
			this.playTime = playTime;
			this.releaseDate = releaseDate;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
			Controller.getInstance().setExpect(Double.parseDouble(GUI.getInstance().expectation_t.getText()));
		}
		catch(NumberFormatException e1){
			Controller.getInstance().setExpect(-1);
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
