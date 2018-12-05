package Controller;

import View.GUI;
import View.MoviePanel;

public class DateSalesVerify implements VerifyListener {

    private MoviePanel moviePanel;

    public DateSalesVerify(MoviePanel moviePanel) {
        this.moviePanel = moviePanel;
    }

    @Override
    public void verify() {
        String name = moviePanel.getTitle_t().getText();
        int playTime = Integer.parseInt(moviePanel.getPlaytime_t().getText());

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
