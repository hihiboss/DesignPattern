package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.GUI;
import View.MoviePanel;

public class DateSalesListener implements ActionListener {

	private MoviePanel moviePanel;
	private VerifyListener verifyListener;

	public DateSalesListener(MoviePanel moviePanel) {
		this.moviePanel = moviePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		verifyListener = new DateSalesVerify(moviePanel);
		verifyListener.verify();
	}
}