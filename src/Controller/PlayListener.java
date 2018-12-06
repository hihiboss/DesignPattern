package Controller;

import View.*;
import java.awt.event.*;

public class PlayListener implements ItemListener {

	private MoviePanelInterface moviePanel;

	public PlayListener(MoviePanelInterface moviePanel){
		this.moviePanel = moviePanel;
		moviePanel.setPlayListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		boolean play_temp = true;
		boolean temp = false;
		
		if(e.getStateChange() == ItemEvent.SELECTED) {
			play_temp = false;
			temp = true;
        } 
		else {
			play_temp = true;
			temp = false;
        }

		moviePanel.getBeforeplay().setVisible(play_temp);
		moviePanel.getDatesales_t().setVisible(temp);
		moviePanel.getDatesales_e().setVisible(temp);

		moviePanel.getGenre_e().setVisible(false);
		moviePanel.getNation_e().setVisible(false);
		moviePanel.getAge_e().setVisible(false);
		moviePanel.getExpectation_e().setVisible(false);
		moviePanel.getReleasedate_e().setVisible(false);
	}
}
