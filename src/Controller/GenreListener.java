package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

import View.*;

public class GenreListener implements ItemListener, VerifyListener {
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
		verify();
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
}
