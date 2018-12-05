package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import View.GUI;

public class ReleaseDateListener implements ItemListener {

	private double expect;
	private String name;
	private int playTime;
	private int releaseDate;

	private VerifyListener verifyListener;

	public ReleaseDateListener(double expect, String name, int playTime, int releaseDate) {
		this.expect = expect;
		this.name = name;
		this.playTime = playTime;
		this.releaseDate = releaseDate;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		verifyListener = new ReleaseDateVerify();
		verifyListener.verify();
	}
}
