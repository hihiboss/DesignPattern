package Controller;

import View.GUI;

import javax.swing.*;

public class NationVerify implements VerifyListener {

    public NationVerify() {

    }

    @Override
    public void verify() {
        JComboBox b = (JComboBox)e.getSource();
        Controller.getInstance().setNation((String)b.getSelectedItem());

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
