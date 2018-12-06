package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface SchedulePanelInterface {
    public JButton getExecution();
    public void setExecutionListener(ActionListener actionListener);
}