package View;

import javax.swing.*;
import java.awt.*;

public class SchedulePanel extends JPanel implements UpdateObserver {

    private JButton execution = new JButton("½ÇÇà");

    public JButton getExecution() {
        return execution;
    }

    public SchedulePanel(){
        this.setLayout(new GridLayout(1, 3));

        this.add(new JLabel(""));
        this.add(execution);
        this.add(new JLabel(""));
        execution.setEnabled(false);
    }

    @Override
    public void update(Object data) {

    }
}
