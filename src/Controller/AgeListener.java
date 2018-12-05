package Controller;

import View.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

public class AgeListener implements ItemListener {
	private MoviePanel moviePanel;
	private AddMoviePanel addMoviePanel;

	public AgeListener(MoviePanel moviePanel, AddMoviePanel addMoviePanel) {
		this.moviePanel = moviePanel;
		this.addMoviePanel = addMoviePanel;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

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
