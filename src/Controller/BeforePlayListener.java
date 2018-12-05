package Controller;

import View.*;
import java.awt.event.*;

public class BeforePlayListener implements ItemListener {

	public BeforePlayListener() {

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getStateChange() == ItemEvent.SELECTED) {
			GUI.getInstance().play.setVisible(false);
			GUI.getInstance().genre_e.setVisible(true);
			GUI.getInstance().nation_e.setVisible(true);
			GUI.getInstance().age_e.setVisible(true);
			GUI.getInstance().expectation_e.setVisible(true);
			GUI.getInstance().expectation_t.setVisible(true);
			GUI.getInstance().releasedate_e.setVisible(true);
			GUI.getInstance().datesales_e.setVisible(false);
			GUI.getInstance().datesales_t.setVisible(false);
        } 
		else {
			GUI.getInstance().play.setVisible(true);
			GUI.getInstance().genre_e.setVisible(false);
			GUI.getInstance().nation_e.setVisible(false);
			GUI.getInstance().age_e.setVisible(false);
			GUI.getInstance().expectation_e.setVisible(false);
			GUI.getInstance().expectation_t.setVisible(false);
			GUI.getInstance().releasedate_e.setVisible(false);
			GUI.getInstance().datesales_e.setVisible(false);
			GUI.getInstance().datesales_t.setVisible(false);
        }
	}
}
