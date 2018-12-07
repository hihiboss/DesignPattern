package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

import View.*;

public class NationListener extends VerifyAbstract implements ItemListener {

    public NationListener(MoviePanelInterface moviePanel, Verify verify) {
        super(verify);
        moviePanel.setNationListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        verify.verify();
    }
}