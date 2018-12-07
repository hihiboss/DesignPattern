package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.*;

public class DateSalesListener extends VerifyAbstract implements ActionListener {

    public DateSalesListener(MoviePanelInterface moviePanel, Verify verify) {
        super(verify);
        moviePanel.setDateSalesListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        verify.verify();
    }
}