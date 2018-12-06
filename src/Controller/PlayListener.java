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

        boolean check;
        boolean showing;
        boolean preshowing = false;

        if(e.getStateChange() == ItemEvent.SELECTED) {
            showing = true;
            check = false;
        }
        else {
            showing = false;
            check = true;
        }

        Verify verify = new VerifyCheckType(moviePanel, check, showing, preshowing, 0);
        verify.verify();
    }
}
