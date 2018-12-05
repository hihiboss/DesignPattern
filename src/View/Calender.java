package View;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import Controller.*;
import Model.*;

public class Calender extends JPanel {
    String[] days = {"��", "��", "ȭ", "��", "��", "��", "��"};
    int year, month, day, todays, memoday = 0;
    Font f;
    Color bc, fc;
    Calendar today;
    Calendar cal;
    JButton btnBefore, btnAfter;
    public JButton[] calBtn = new JButton[49];
    JLabel thing;
    JLabel time;
    JPanel panWest;
    JPanel panSouth;
    JPanel panNorth;
    JTextField txtMonth, txtYear;
    JTextField txtTime;
    BorderLayout bLayout = new BorderLayout();

    private JButton execution;

    ////////////////////////////////////////
    public Calender(JButton execution) {
        this.execution = execution;
        this.setLayout(bLayout);
        today = Calendar.getInstance(); //����Ʈ�� Ÿ�� �� �� �������� ����� �޷��� �����ɴϴ�.
        cal = new GregorianCalendar();
        year = today.get(Calendar.YEAR);
        month = today.get(Calendar.MONTH) + 1;//1���� ���� 0
        panNorth = new JPanel();
        panNorth.add(btnBefore = new JButton("Before"));
        btnBefore.setFont(new Font("San-Serif", Font.PLAIN, 35));
        panNorth.add(txtYear = new JTextField(year + "��"));

        panNorth.add(txtMonth = new JTextField(month + "��", 3));

        txtYear.setEnabled(false);
        txtMonth.setEnabled(false);
        panNorth.add(btnAfter = new JButton("After"));
        btnAfter.setFont(new Font("San-Serif", Font.PLAIN, 35));

        f = new Font("Sherif", Font.BOLD, 35);
        txtYear.setFont(f);
        txtMonth.setFont(f);
        this.add(panNorth, bLayout.NORTH);
        //�̳��� �޷¿� ���� �ش��ϴ� �κ�
        panWest = new JPanel(new GridLayout(7, 7));//���ڳ�,���������� ��ġ������
        f = new Font("Sherif", Font.BOLD, 12);
        CalenderListener calenderListener = new CalenderListener(execution, calBtn, cal, txtMonth, txtYear, panWest);
        this.add(panWest, bLayout.CENTER);

        btnBefore.addActionListener(calenderListener);
        btnAfter.addActionListener(calenderListener);


        setPreferredSize(new Dimension(600, 400));
        setMaximumSize(this.getPreferredSize());
        setMinimumSize(this.getPreferredSize());
        setVisible(true);
    }//end constuctor
}//end class