package Controller;

import View.AddMoviePanel;
import View.AddMoviePanelInterface;
import View.MoviePanelInterface;

public abstract class Verify implements VerifyListener {
    protected MoviePanelInterface moviePanel;
    public Verify(MoviePanelInterface moviePanelInterface){
        this.moviePanel = moviePanelInterface;
    }
}
