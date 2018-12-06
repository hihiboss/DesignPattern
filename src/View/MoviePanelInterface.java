package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public interface MoviePanelInterface {
    public JCheckBox getPlay();
    public JCheckBox getBeforeplay();
    public JButton getTitle_e();
    public JButton getPlaytime_e();
    public JComboBox getAge_e();
    public JComboBox getNation_e();
    public JComboBox getGenre_e();
    public JComboBox getReleasedate_e();
    public JButton getDatesales_e();
    public JTextField getExpectation_t();
    public JButton getExpectation_e();
    public JTextField getPlaytime_t();
    public JTextField getTitle_t();
    public JTextField getDatesales_t();

    public void setDateSalesListener(ActionListener actionListener);
    public void setBeforeplayListener(ItemListener itemListener);
    public void setGenreListener(ItemListener itemListener);
    public void setNationListener(ItemListener itemListener);
    public void setAgeListener(ItemListener itemListener);
    public void setExpectationListener(ActionListener actionListener);
    public void setReleasedateListener(ItemListener itemListener);
    public void setPlayListener(ItemListener itemListener);
}
