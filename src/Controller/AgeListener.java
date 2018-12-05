package Controller;

import View.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AgeListener implements ItemListener {
	private MoviePanel moviePanel;
	private AddMoviePanel addMoviePanel;
	private VerifyListener verifyListener;

	public AgeListener(MoviePanel moviePanel, AddMoviePanel addMoviePanel) {
		this.moviePanel = moviePanel;
		this.addMoviePanel = addMoviePanel;

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		verifyListener = new AgeVerifyListener(moviePanel, addMoviePanel);
		verifyListener.verify();
	}
}
