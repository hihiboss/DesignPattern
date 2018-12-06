package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Calendar;

public interface CalenderInterface {
    public void setCalButton(int index, JButton button);
    public JButton[] getCalBtn();
    public JButton getCalButton(int index);
    public JPanel getPanWest();
    public JButton getBtnBefore();
    public JButton getBtnAfter();
    public void setBtnListener(ActionListener actionListener);
    public JTextField getTxtMonth();
    public JTextField getTxtYear();
    public Calendar getCal();
    public int getYear();
    public int getMonth();
    public int getDay();
    public int getTodays();
    public int getMemoday();
    public void setYear(int year);
    public void setDay(int day);
    public void setMonth(int month);
    public void setTodays(int todays);
}
