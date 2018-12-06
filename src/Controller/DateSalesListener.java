package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.*;

public class DateSalesListener implements ActionListener, VerifyListener {

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
        verify();
    }

    @Override
    public void verify() {
        String name = moviePanel.getTitle_t().getText();
        int playTime = Integer.parseInt(moviePanel.getPlaytime_t().getText());
        double dataSales;

        try{
            dataSales = Double.parseDouble(moviePanel.getDatesales_t().getText());
        }
        catch(NumberFormatException e1){
            dataSales = -1;
        }

        if (dataSales != -1 &&
                name != null &&
                playTime != -1){
            addMoviePanel.getAddInformation().setEnabled(true);
        }
    }
}