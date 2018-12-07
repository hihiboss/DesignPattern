package Controller;

import View.*;
import java.awt.event.*;

public class BeforePlayListener extends VerifyAbstract implements ItemListener {

    public BeforePlayListener(MoviePanelInterface moviePanel, Verify verify) {
        super(verify);
        moviePanel.setBeforeplayListener(this);
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

        verify.verify(check, showing, preshowing);
    }
}