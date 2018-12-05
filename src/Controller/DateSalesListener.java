package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.GUI;

public class DateSalesListener implements ActionListener {

	private double dataSales;
	private String name;
	private int playTime;

	public DateSalesListener(double dataSales, String name, int playTime) {
		this.dataSales = dataSales;
		this.name = name;
		this.playTime = playTime;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
			Controller.getInstance().setDateSales(Double.parseDouble(GUI.getInstance().datesales_t.getText()));
		}
		catch(NumberFormatException e1){
			Controller.getInstance().setDateSales(-1);
		}
		
		if (dataSales != -1 &&
				name != null &&
				playTime != -1){
			GUI.getInstance().addInformation.setEnabled(true);
		}
	}
}