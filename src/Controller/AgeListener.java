package Controller;

import View.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AgeListener extends VerifyAbstract implements ItemListener{

    public AgeListener(MoviePanelInterface moviePanel, Verify verify) {
        super(verify);
        moviePanel.setAgeListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        verify.verify();
    }
}