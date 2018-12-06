package View;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public interface InputMoviePanelInterface {
    public void setUserRow(Vector<String> userRow);

    public DefaultTableModel getModel();

    public Vector<String> getUserColumn();

    public Vector<String> getUserRow();

}
