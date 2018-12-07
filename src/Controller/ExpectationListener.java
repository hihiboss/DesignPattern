package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Movie;
import View.*;

public class ExpectationListener extends VerifyAbstract implements ActionListener {

    public ExpectationListener(MoviePanelInterface moviePanel, Verify verify) {
        super(verify);
        moviePanel.setExpectationListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        verify.verify();
    }
}
