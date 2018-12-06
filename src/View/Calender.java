package View;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import Controller.*;
import Model.*;

public class Calender extends JPanel implements CalenderInterface {
    String[] days = {"��", "��", "ȭ", "��", "��", "��", "��"};
    private int year, month, day, todays, memoday = 0;
    Font f;
    Color bc, fc;
    Calendar today;
    private Calendar cal;
    private JButton btnBefore, btnAfter;
    private JButton[] calBtn = new JButton[49];
    JLabel thing;
    JLabel time;
    private JPanel panWest;
    JPanel panSouth;
    JPanel panNorth;
    private JTextField txtMonth, txtYear;
    JTextField txtTime;
    BorderLayout bLayout = new BorderLayout();

    public void setMonth(int month) {
        this.month = month;
    }

    public void setTodays(int todays) {
        this.todays = todays;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getTodays() {
        return todays;
    }

    public int getMemoday() {
        return memoday;
    }

    public Calendar getCal() {
        return cal;
    }

    public JTextField getTxtMonth() {
        return txtMonth;
    }

    public JTextField getTxtYear() {
        return txtYear;
    }

    public void setCalButton(int index, JButton button){
        calBtn[index] = button;
    }

    public JButton[] getCalBtn() {
        return calBtn;
    }

    public JButton getCalButton(int index){
        return calBtn[index];
    }

    public JPanel getPanWest() {
        return panWest;
    }

    public JButton getBtnBefore() {
        return btnBefore;
    }

    public JButton getBtnAfter() {
        return btnAfter;
    }

    public void setBtnListener(ActionListener actionListener){
        btnAfter.addActionListener(actionListener);
        btnBefore.addActionListener(actionListener);
    }

    ////////////////////////////////////////
    public Calender() {
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
        this.add(panWest, bLayout.CENTER);

        setPreferredSize(new Dimension(600, 400));
        setMaximumSize(this.getPreferredSize());
        setMinimumSize(this.getPreferredSize());
        setVisible(true);
    }//end constuctor
}//end class