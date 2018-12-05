package View;

import javax.swing.*;
import java.awt.*;

public class AddMoviePanel extends JPanel implements UpdateObserver {

    public JButton getAddInformation() {
        return addInformation;
    }

    private JButton addInformation = new JButton("Ãß°¡");

    public AddMoviePanel(){
        this.setLayout(new GridLayout(1, 3));

        this.add(new JLabel(""));
        this.add(addInformation);

        this.add(new JLabel(""));

        addInformation.setEnabled(false);
    }

    @Override
    public void update(Object data) {

    }
}
