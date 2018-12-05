package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.GUI;

public class ExpectationListener implements ActionListener {

	private double expect;
	private String name;
	private int playTime;
	private int releaseDate;

	private VerifyListener verifyListener;

	public ExpectationListener(double expect, String name, int playTime, int releaseDate) {
			this.expect = expect;
			this.name = name;
			this.playTime = playTime;
			this.releaseDate = releaseDate;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		verifyListener = new ExpectationVerify();
		verifyListener.verify();
	}
}
