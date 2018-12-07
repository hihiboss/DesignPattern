package Controller;

import View.AddMoviePanelInterface;
import View.MoviePanelInterface;

public class VerifyAddMovie extends Verify {

    private AddMoviePanelInterface addMoviePanel;

    public VerifyAddMovie(MoviePanelInterface moviePanelInterface, AddMoviePanelInterface addMoviePanel){
        super(moviePanelInterface);
        this.addMoviePanel = addMoviePanel;
    }

    @Override
    public void verify() {
        String name = moviePanel.getTitle_t().getText();
        double expect = Double.parseDouble(moviePanel.getExpectation_t().getText());
        String releaseDate = moviePanel.getReleasedate_e().getSelectedItem().toString();
        int playTime = Integer.parseInt(moviePanel.getPlaytime_t().getText());

        if (moviePanel.getGenre_e().getSelectedIndex() != 0 &&
                moviePanel.getNation_e().getSelectedIndex() != 0 &&
                moviePanel.getAge_e().getSelectedIndex() != 0 &&
                expect != -1 &&
                name != null &&
                playTime != -1 &&
                releaseDate != null){
            addMoviePanel.getAddInformation().setEnabled(true);
        }
    }

    @Override
    public void verify(boolean check, boolean showing, boolean preshowing) {

    }
}
