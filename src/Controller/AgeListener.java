package Controller;

import View.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AgeListener implements ItemListener{
    private MoviePanelInterface moviePanel;
    private AddMoviePanelInterface addMoviePanel;

    public AgeListener(MoviePanelInterface moviePanel, AddMoviePanelInterface addMoviePanel) {
        this.moviePanel = moviePanel;
        this.addMoviePanel = addMoviePanel;
        moviePanel.setAgeListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        Verify verify = new VerifyAddMovie(moviePanel, addMoviePanel);
        verify.verify();
    }
}