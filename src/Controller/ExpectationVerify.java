package Controller;

import View.GUI;

public class ExpectationVerify implements VerifyListener {

    public ExpectationVerify() {

    }

    @Override
    public void verify() {
        try{
            Controller.getInstance().setExpect(Double.parseDouble(GUI.getInstance().expectation_t.getText()));
        }
        catch(NumberFormatException e1){
            Controller.getInstance().setExpect(-1);
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
