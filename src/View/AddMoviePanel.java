package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddMoviePanel extends JPanel implements AddMoviePanelInterface {

    public JButton getAddInformation() {
        return addInformation;
    }

    public void setAddInformationListener(ActionListener addInformationListener){
        addInformation.addActionListener(addInformationListener);
    }

    private JButton addInformation = new JButton("추가");

    public AddMoviePanel(){
        this.setLayout(new GridLayout(1, 3));

        this.add(new JLabel(""));
        this.add(addInformation);

        this.add(new JLabel(""));

        addInformation.setEnabled(false);
    }
}