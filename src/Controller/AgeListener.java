package Controller;

import View.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

public class AgeListener implements ItemListener {
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		JComboBox b = (JComboBox)e.getSource();
		switch((String)b.getSelectedItem()){
		case"��ü �̿밡":
			Controller.getInstance().setAge(1);
			break;
		case"12�� �̿밡":
			Controller.getInstance().setAge(12);
			break;
		case"15�� �̿밡":
			Controller.getInstance().setAge(15);
			break;
		case"19�� �̿밡":
			Controller.getInstance().setAge(19);
			break;
		default:
			Controller.getInstance().setAge(0);
			break;
		}
		
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
