package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

import View.*;

public class ReleaseDateListener extends VerifyAbstract implements ItemListener {

	public ReleaseDateListener(MoviePanelInterface moviePanel, Verify verify) {
		super(verify);
		moviePanel.setReleasedateListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		verify.verify();
	}
}
