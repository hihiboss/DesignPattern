package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.GUI;

public class PlayTimeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
			Controller.getInstance().setPlayTime(Integer.parseInt(GUI.getInstance().playtime_t.getText()));
		}
		catch(NumberFormatException e1){
			Controller.getInstance().setPlayTime(-1);
		}
	}
	
}
