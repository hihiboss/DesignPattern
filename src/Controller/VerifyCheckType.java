package Controller;

import View.MoviePanel;
import View.MoviePanelInterface;

public class VerifyCheckType extends Verify {

    private int flag;

    public VerifyCheckType(MoviePanelInterface moviePanelInterface
            , int flag){
        super(moviePanelInterface);
        this.flag = flag;
    }

    @Override
    public void verify() {

    }

    @Override
    public void verify(boolean check, boolean showing, boolean preshowing) {

        if (flag == 0){
            moviePanel.getBeforeplay().setVisible(check);
        } else {
            moviePanel.getPlay().setVisible(check);
        }


        moviePanel.getGenre_e().setVisible(preshowing);
        moviePanel.getNation_e().setVisible(preshowing);
        moviePanel.getAge_e().setVisible(preshowing);
        moviePanel.getExpectation_e().setVisible(preshowing);
        moviePanel.getExpectation_t().setVisible(preshowing);
        moviePanel.getReleasedate_e().setVisible(preshowing);


        moviePanel.getDatesales_e().setVisible(showing);
        moviePanel.getDatesales_t().setVisible(showing);
    }
}
