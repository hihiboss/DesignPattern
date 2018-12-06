package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.*;

public class DateSalesListener implements ActionListener {

    private MoviePanelInterface moviePanel;
    private AddMoviePanelInterface addMoviePanel;

    public DateSalesListener(MoviePanelInterface moviePanel, AddMoviePanelInterface addMoviePanel) {
        this.moviePanel = moviePanel;
        this.addMoviePanel = addMoviePanel;
        moviePanel.setDateSalesListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Verify verify = new VerifyAddMovie(moviePanel, addMoviePanel);
        verify.verify();
    }
}