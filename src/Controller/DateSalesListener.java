package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.GUI;

public class DateSalesListener implements ActionListener {

	private double dataSales;


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
			Controller.getInstance().setDateSales(Double.parseDouble(GUI.getInstance().datesales_t.getText()));
		}
		catch(NumberFormatException e1){
			Controller.getInstance().setDateSales(-1);
		}
		
		if (Controller.getInstance().getDateSales() != -1 &&
				Controller.getInstance().getName() != null &&
				Controller.getInstance().getPlayTime() != -1){
			GUI.getInstance().addInformation.setEnabled(true);
		}
	}
}