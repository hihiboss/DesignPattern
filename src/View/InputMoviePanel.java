package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class InputMoviePanel extends JPanel implements UpdateObserver, InputMoviePanelInterface {

    private DefaultTableModel model;
    private Vector<String> userColumn = new Vector<>();
    private Vector<String> userRow;

    public void setUserRow(Vector<String> userRow) {
        this.userRow = userRow;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public Vector<String> getUserColumn() {
        return userColumn;
    }

    public Vector<String> getUserRow() {
        return userRow;
    }

    public InputMoviePanel(){
        this.setLayout(new BorderLayout());
        this.add(new JLabel("입력된 영화"), BorderLayout.NORTH);

        userColumn.addElement("Name");
        userColumn.addElement("PlayTime");
        userColumn.addElement("Sales");
        model = new DefaultTableModel(userColumn, 0);
        JTable inputedMovie = new JTable(model);
        JScrollPane listJs = new JScrollPane(inputedMovie);
        this.add(listJs, BorderLayout.CENTER);
    }

    @Override
    public void update(Object data) {
        model.setNumRows(0);
    }
}
