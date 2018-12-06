package Controller;

import View.*;
import java.awt.event.*;

public class BeforePlayListener implements ItemListener, VerifyListener {

    private MoviePanelInterface moviePanel;
    private int state;

    public BeforePlayListener(MoviePanelInterface moviePanel) {
        moviePanel.setBeforeplayListener(this);
        this.moviePanel = moviePanel;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        this.state = e.getStateChange();
        verify();
    }

    @Override
    public void verify() {
        boolean play_temp = true;
        boolean temp = false;

        if(state == ItemEvent.SELECTED) {
            temp = true;
            play_temp = false;
        }
        else {
            temp = false;
            play_temp = true;
        }

        moviePanel.getPlay().setVisible(play_temp);
        moviePanel.getGenre_e().setVisible(temp);
        moviePanel.getNation_e().setVisible(temp);
        moviePanel.getAge_e().setVisible(temp);
        moviePanel.getExpectation_e().setVisible(temp);
        moviePanel.getExpectation_t().setVisible(temp);
        moviePanel.getReleasedate_e().setVisible(temp);


        moviePanel.getDatesales_e().setVisible(false);
        moviePanel.getDatesales_t().setVisible(false);
    }
}