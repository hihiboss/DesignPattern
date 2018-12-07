package Controller;

import View.*;
import java.awt.event.*;

public class PlayListener extends VerifyAbstract implements ItemListener {

    public PlayListener(MoviePanelInterface moviePanel, Verify verify){
        super(verify);
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

        verify.verify(check, showing, preshowing);
    }
}
