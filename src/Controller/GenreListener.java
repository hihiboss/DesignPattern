package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

import View.*;

public class GenreListener implements ItemListener {
    private MoviePanelInterface moviePanel;
    private AddMoviePanelInterface addMoviePanel;

    public GenreListener(MoviePanelInterface moviePanel, AddMoviePanelInterface addMoviePanel) {
        this.moviePanel = moviePanel;
        this.addMoviePanel = addMoviePanel;
        moviePanel.setGenreListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        Verify verify = new VerifyAddMovie(moviePanel, addMoviePanel);
        verify.verify();
    }
}
