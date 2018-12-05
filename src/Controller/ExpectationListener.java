package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.GUI;

public class ExpectationListener implements ActionListener {

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
				Controller.getInstance().getExpect() != -1 &&
				Controller.getInstance().getName() != null &&
				Controller.getInstance().getPlayTime() != -1 &&
				Controller.getInstance().getReleaseDate() != -1){
			GUI.getInstance().addInformation.setEnabled(true);
		}
	}
}
