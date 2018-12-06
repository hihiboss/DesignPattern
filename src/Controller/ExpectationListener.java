package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Movie;
import View.*;

public class ExpectationListener implements ActionListener {

    private MoviePanelInterface moviePanel;
    private AddMoviePanelInterface addMoviePanel;

    public ExpectationListener(MoviePanelInterface moviePanel, AddMoviePanelInterface addMoviePanel) {
        this.moviePanel = moviePanel;
        this.addMoviePanel = addMoviePanel;
        moviePanel.setExpectationListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Verify verify = new VerifyAddMovie(moviePanel, addMoviePanel);
        verify.verify();
    }
}
