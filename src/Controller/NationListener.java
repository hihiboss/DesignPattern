package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

import View.GUI;

public class NationListener implements ItemListener {
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		JComboBox b = (JComboBox)e.getSource();
		Controller.getInstance().setNation((String)b.getSelectedItem());

		if (GUI.getInstance().genre_e.getSelectedIndex() != 0 &&
				GUI.getInstance().nation_e.getSelectedIndex() != 0 &&
				GUI.getInstance().age_e.getSelectedIndex() != 0 &&
				Controller.getInstance().getExpect() != -1 &&
				Controller.getInstance().getName() != null &&
				Controller.getInstance().getPlayTime() != -1 &&
				Controller.getInstance().getReleaseDate() != -1){
			GUI.getInstance().addInformation.setEnabled(true);
		}
	}
}
