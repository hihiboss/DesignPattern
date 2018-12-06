package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

import View.*;

public class NationListener implements ItemListener {

    private MoviePanelInterface moviePanel;
    private AddMoviePanelInterface addMoviePanel;

    public NationListener(MoviePanelInterface moviePanel, AddMoviePanelInterface addMoviePanel) {
        this.moviePanel = moviePanel;
        this.addMoviePanel = addMoviePanel;
        moviePanel.setNationListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        Verify verify = new VerifyAddMovie(moviePanel, addMoviePanel);
        verify.verify();
    }
}