package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

import View.*;

public class GenreListener extends VerifyAbstract implements ItemListener {

    public GenreListener(MoviePanelInterface moviePanel, Verify verify) {
        super(verify);
        moviePanel.setGenreListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        verify.verify();
    }
}
