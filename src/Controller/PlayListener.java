package Controller;

import View.*;
import java.awt.event.*;

public class PlayListener implements ItemListener {
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getStateChange() == ItemEvent.SELECTED) {
			GUI.getInstance().beforeplay.setVisible(false);
			GUI.getInstance().genre_e.setVisible(false);
			GUI.getInstance().nation_e.setVisible(false);
			GUI.getInstance().age_e.setVisible(false);
			GUI.getInstance().expectation_e.setVisible(false);
			GUI.getInstance().releasedate_e.setVisible(false);
			GUI.getInstance().datesales_t.setVisible(true);
			GUI.getInstance().datesales_e.setVisible(true);
        } 
		else {
			GUI.getInstance().beforeplay.setVisible(true);
			GUI.getInstance().genre_e.setVisible(false);
			GUI.getInstance().nation_e.setVisible(false);
			GUI.getInstance().age_e.setVisible(false);
			GUI.getInstance().expectation_e.setVisible(false);
			GUI.getInstance().releasedate_e.setVisible(false);
			GUI.getInstance().datesales_t.setVisible(false);
			GUI.getInstance().datesales_e.setVisible(false);
        }
	}
}
