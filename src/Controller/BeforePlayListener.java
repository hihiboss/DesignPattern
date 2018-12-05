package Controller;

import View.*;
import java.awt.event.*;

public class BeforePlayListener implements ItemListener {

	private MoviePanel moviePanel;
	private VerifyListener verifyListener;

	public BeforePlayListener(MoviePanel moviePanel) {
		this.moviePanel = moviePanel;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		verifyListener = new BeforePlayVerifyListener(moviePanel, e);
		verifyListener.verify();
	}
}
