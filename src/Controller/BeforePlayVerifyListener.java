package Controller;

import View.MoviePanel;

import java.awt.event.ItemEvent;

public class BeforePlayVerifyListener implements VerifyListener {

    private MoviePanel moviePanel;
    private ItemEvent e;

    public BeforePlayVerifyListener(MoviePanel moviePanel, ItemEvent e) {
        this.moviePanel = moviePanel;
        this.e = e;
    }

    @Override
    public void verify() {
        boolean play_temp = true;
        boolean temp = false;

        if(e.getStateChange() == ItemEvent.SELECTED) {
            temp = true;
            play_temp = false;
        }
        else {
            temp = false;
            play_temp = true;
        }

        moviePanel.getPlay().setVisible(play_temp);
        moviePanel.getGenre_e().setVisible(temp);
        moviePanel.getNation_e().setVisible(temp);
        moviePanel.getAge_e().setVisible(temp);
        moviePanel.getExpectation_e().setVisible(temp);
        moviePanel.getExpectation_t().setVisible(temp);
        moviePanel.getReleasedate_e().setVisible(temp);


        moviePanel.getDatesales_e().setVisible(false);
        moviePanel.getDatesales_t().setVisible(false);
    }
}
