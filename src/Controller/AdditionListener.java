package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import Model.*;
import View.*;

public class AdditionListener implements ActionListener {

    private MoviePanelInterface moviePanel;
    private AddMoviePanelInterface addMoviePanel;
    private InputMoviePanelInterface inputMoviePanel;
    private TotalMovieList totalMovieList;

    public AdditionListener(MoviePanelInterface moviePanel, AddMoviePanelInterface addMoviePanel, InputMoviePanelInterface inputMoviePanel, TotalMovieList totalMovieList) {
        this.moviePanel = moviePanel;
        this.addMoviePanel = addMoviePanel;
        this.inputMoviePanel = inputMoviePanel;
        this.totalMovieList = totalMovieList;
        addMoviePanel.setAddInformationListener(this);
    }

    protected void settingMovieGUI(Movie movie){
        addMoviePanel.getAddInformation().setEnabled(false);
        moviePanel.getTitle_t().setText("");
        moviePanel.getPlaytime_t().setText("");
        inputMoviePanel.setUserRow(new Vector<>());
        inputMoviePanel.getUserRow().addElement(movie.getName());
        inputMoviePanel.getUserRow().addElement(Integer.toString(movie.getTime()));
        inputMoviePanel.getUserRow().addElement(Double.toString(movie.getSales()));
        inputMoviePanel.getModel().addRow(inputMoviePanel.getUserRow());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (addMoviePanel.getAddInformation().isEnabled() == true){
            String name = moviePanel.getTitle_t().getText();
            int playTime = Integer.parseInt(moviePanel.getPlaytime_t().getText());

            if (moviePanel.getPlay().isSelected() == true){

                double dateSales = Double.parseDouble(moviePanel.getDatesales_t().getText());

                if (dateSales != -1 &&
                        name != null &&
                        playTime != -1){
                    Movie movie = MovieFactory.getInstance().getMovie(new ShowingMovieFactory(dateSales));
                    movie.setName(name);
                    movie.setTime(playTime);
                    totalMovieList.addMList(movie);


                    settingMovieGUI(movie);
                    moviePanel.getDatesales_t().setText("");
                    moviePanel.getPlay().setSelected(false);
                }
            }
            else if (moviePanel.getBeforeplay().isSelected() == true){

                String genre = moviePanel.getGenre_e().getSelectedItem().toString();
                String age = moviePanel.getAge_e().getSelectedItem().toString();
                double expect = Double.parseDouble(moviePanel.getExpectation_t().getText());
                String nation = moviePanel.getNation_e().getSelectedItem().toString();
                String releaseDate = moviePanel.getReleasedate_e().getSelectedItem().toString();

                if (moviePanel.getGenre_e().getSelectedIndex() != 0 &&
                        moviePanel.getNation_e().getSelectedIndex() != 0 &&
                        moviePanel.getAge_e().getSelectedIndex() != 0 &&
                        expect != -1 &&
                        name != null &&
                        playTime != -1 &&
                        releaseDate != null){
                    Movie movie = MovieFactory.getInstance().getMovie(new PreShowingMovieFactory(genre, age, expect, nation, releaseDate));
                    movie.setName(name);
                    movie.setTime(playTime);
                    totalMovieList.addMList(movie);

                    settingMovieGUI(movie);
                    moviePanel.getGenre_e().setSelectedIndex(0);
                    moviePanel.getNation_e().setSelectedIndex(0);
                    moviePanel.getAge_e().setSelectedIndex(0);
                    moviePanel.getExpectation_t().setText("");
                    moviePanel.getReleasedate_e().setSelectedIndex(0);
                    moviePanel.getBeforeplay().setSelected(false);
                }
            }
        }
    }
}