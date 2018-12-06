package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SchedulePanel extends JPanel implements UpdateObserver, SchedulePanelInterface {

    private JButton execution = new JButton("½ÇÇà");

    public JButton getExecution() {
        return execution;
    }

    public void setExecutionListener(ActionListener actionListener){
        execution.addActionListener(actionListener);
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
