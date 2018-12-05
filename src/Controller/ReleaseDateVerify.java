package Controller;

import View.GUI;

import javax.swing.*;

public class ReleaseDateVerify implements VerifyListener {

    public ReleaseDateVerify() {

    }

    @Override
    public void verify() {
        JComboBox b = (JComboBox)e.getSource();
        switch((String)b.getSelectedItem()){
            case"수요일":
                Controller.getInstance().setReleaseDate(0);
                break;
            case"목요일":
                Controller.getInstance().setReleaseDate(1);
                break;
            default:
                Controller.getInstance().setReleaseDate(-1);
                break;
        }

        if (GUI.getInstance().genre_e.getSelectedIndex() != 0 &&
                GUI.getInstance().nation_e.getSelectedIndex() != 0 &&
                GUI.getInstance().age_e.getSelectedIndex() != 0 &&
                expect != -1 &&
                name != null &&
                playTime != -1 &&
                releaseDate != -1){
            GUI.getInstance().addInformation.setEnabled(true);
        }
    }
}
