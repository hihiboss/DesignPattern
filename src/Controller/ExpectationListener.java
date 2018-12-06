package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Movie;
import View.*;

public class ExpectationListener implements ActionListener, VerifyListener {

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
        verify();
    }

    @Override
    public void verify() {

        String name = moviePanel.getTitle_t().getText();
        int playTime = Integer.parseInt(moviePanel.getPlaytime_t().getText());
        String releaseDate = moviePanel.getReleasedate_e().getSelectedItem().toString();
        double expect;

        try{
            expect = Double.parseDouble(moviePanel.getExpectation_t().getText());
        }
        catch(NumberFormatException e1){
            expect = -1;
        }

        if (moviePanel.getGenre_e().getSelectedIndex() != 0 &&
                moviePanel.getAge_e().getSelectedIndex() != 0 &&
                moviePanel.getNation_e().getSelectedIndex() != 0 &&
                expect != -1 &&
                name != null &&
                playTime != -1 &&
                releaseDate != null){
            addMoviePanel.getAddInformation().setEnabled(true);
        }
    }
}
