package Controller;

import View.*;
import java.awt.event.*;

public class BeforePlayListener implements ItemListener {

    private MoviePanelInterface moviePanel;

    public BeforePlayListener(MoviePanelInterface moviePanel) {
        moviePanel.setBeforeplayListener(this);
        this.moviePanel = moviePanel;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub

        boolean check;
        boolean showing = false;
        boolean preshowing;

        if(e.getStateChange() == ItemEvent.SELECTED) {
            preshowing = true;
            check = false;
        }
        else {
            preshowing = false;
            check = true;
        }

        Verify verify = new VerifyCheckType(moviePanel, check, showing, preshowing, 1);
        verify.verify();
    }
}