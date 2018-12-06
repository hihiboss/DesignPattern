package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

import View.*;

public class ReleaseDateListener implements ItemListener {

	private MoviePanelInterface moviePanel;
	private AddMoviePanelInterface addMoviePanel;

	public ReleaseDateListener(MoviePanelInterface moviePanel, AddMoviePanelInterface addMoviePanel) {
		this.moviePanel = moviePanel;
		this.addMoviePanel = addMoviePanel;
		moviePanel.setReleasedateListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Verify verify = new VerifyAddMovie(moviePanel, addMoviePanel);
		verify.verify();
	}
}
