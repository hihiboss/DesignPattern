package Controller;

import Model.TimeSchedule;
import Model.TimeScheduleList;
import View.Calender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class CalenderListener implements ActionListener {

    private String[] days = {"��", "��", "ȭ", "��", "��", "��", "��"};
    private JButton execution;
    private JButton[] calBtn;
    private Calendar cal;
    private int year, month, day, todays, memoday = 0;
    private JTextField txtMonth, txtYear;
    private JPanel panWest;

    private TimeScheduleList timeScheduleList;

    public CalenderListener(JButton execution, JButton[] calBtn, Calendar cal,
    JTextField txtMonth, JTextField txtYear, JPanel panWest){
        this.panWest = panWest;
        this.cal = cal;
        this.execution = execution;
        this.calBtn = calBtn;
        this.txtMonth = txtMonth;
        this.txtYear = txtYear;

        timeScheduleList = new TimeScheduleList();

        gridInit();
        calSet();
        hideInit();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton button = (JButton)ae.getSource();
        if (button.getText() == "Before") {
            this.panWest.removeAll();
            calInput(-1);
            gridInit();
            panelInit();
            calSet();
            hideInit();
            this.txtYear.setText(year + "��");
            this.txtMonth.setText(month + "��");
        } else if (button.getText() == "After") {
            this.panWest.removeAll();
            calInput(1);
            gridInit();
            panelInit();
            calSet();
            hideInit();
            this.txtYear.setText(year + "��");
            this.txtMonth.setText(month + "��");
        } else if (Integer.parseInt(ae.getActionCommand()) >= 1 &&
                Integer.parseInt(ae.getActionCommand()) <= 31) {

            day = Integer.parseInt(ae.getActionCommand())
            //��ư�� ��� �� 1,2,3.... ���ڸ� ���������� ��ȯ�Ͽ� Ŭ���� ��¥�� �ٲ��ش�.
            execution.setEnabled(true);
            for (int h = 0; h < 49; h++) {
                if (calBtn[h].getText().equals(ae.getActionCommand())) {
                    calBtn[h].setEnabled(false);
                } else {
                    calBtn[h].setEnabled(true);
                }
            }
            hideInit();
        }
    }

    public void calSet() {
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, (month - 1));
        cal.set(Calendar.DATE, 1);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        /*
         * get �� set �� ���� �ʵ�ġ��, ������ ��Ÿ���ϴ�.
         * �� �ʵ��� ����,SUNDAY,MONDAY,TUESDAY,WEDNESDAY
         * ,THURSDAY,FRIDAY, �� SATURDAY �� �˴ϴ�.
         * get()�޼ҵ��� ���� ������ ���ڷ� ��ȯ
         */
        int j = 0;
        int hopping = 0;
        calBtn[0].setForeground(new Color(255, 0, 0));//�Ͽ��� "��"
        calBtn[6].setForeground(new Color(0, 0, 255));//����� "��"
        for (int i = cal.getFirstDayOfWeek(); i < dayOfWeek; i++) {
            j++;
        }
        /*
         * �Ͽ��Ϻ��� �״��� ù���� ���ϱ��� ��ĭ���� �����ϱ� ����
         */
        hopping = j;
        for (int kk = 0; kk < hopping; kk++) {

            calBtn[kk + 7].setText("");

        }
        for (int i = cal.getMinimum(Calendar.DAY_OF_MONTH);
             i <= cal.getMaximum(Calendar.DAY_OF_MONTH); i++) {
            cal.set(Calendar.DATE, i);
            if (cal.get(Calendar.MONTH) != month - 1) {
                break;
            }

            todays = i;
            if (memoday == 1) {
                calBtn[i + 6 + hopping].setForeground(new Color(0, 255, 0));
            } else {
                calBtn[i + 6 + hopping].setForeground(new Color(0, 0, 0));
                if ((i + hopping - 1) % 7 == 0) {//�Ͽ���
                    calBtn[i + 6 + hopping].setForeground(new Color(255, 0, 0));
                }
                if ((i + hopping) % 7 == 0) {//�����
                    calBtn[i + 6 + hopping].setForeground(new Color(0, 0, 255));
                }
            }
            /*
             * ������ ���� �������� ����ؾ� �ϴ� ������ ���� ��ư�� ������ ���ϰ�
             * �ε����� 0���� �����̴� -1�� ���� ������ ������ ���ְ�
             * ��ư�� ������ �������ش�.
             */
            calBtn[i + 6 + hopping].setFont(new Font("San-Serif", Font.PLAIN, 35));
            calBtn[i + 6 + hopping].setText((i) + "");
            TimeSchedule timeschedule = new TimeSchedule();
            timeschedule.setYear(year);
            timeschedule.setMonth(month);
            timeschedule.setDate(i);
            timeScheduleList.addTimeSchedule(timeschedule);
        }//for
        for (int h = 1; h <= 4; h++) {
            TimeSchedule timeschedule = new TimeSchedule();
            timeschedule.setYear(year);
            timeschedule.setMonth(month);
            timeschedule.setDate(timeScheduleList.getTimeschedulelist().get(
                    timeScheduleList.getTimeschedulelist().size() - 1).getDate() + 1);
            timeScheduleList.addTimeSchedule(timeschedule);
        }
        if (timeScheduleList.getTimeschedulelist().size() != 0) {
            for (int h = 0; h <= 4; h++) {
                timeScheduleList.getTimeschedulelist().get(h).setTheaterlist(
                        Controller.getInstance().getTimeschedule().get(h).getTheaterlist());
            }
        }
    }//end Calset()

    public void hideInit() {
        for (int i = 0; i < calBtn.length; i++) {
            if ((calBtn[i].getText()).equals(""))
                calBtn[i].setEnabled(false);
            //���� ������ ���� ������ ��ư�� ��Ȱ��ȭ ��Ų��.
        }//end for
    }//end hideInit()

    public void gridInit() {
        //jPanel3�� ��ư ���̱�
        timeScheduleList.getTimeschedulelist().clear();
        for (int i = 0; i < days.length; i++) {
            panWest.add(calBtn[i] = new JButton(days[i]));
            calBtn[i].setFont(new Font("San-Serif", Font.PLAIN, 25));
            calBtn[i].setContentAreaFilled(false);
            calBtn[i].setBorderPainted(false);

        }
        for (int i = days.length; i < 49; i++) {
            panWest.add(calBtn[i] = new JButton(""));
            calBtn[i].addActionListener(this);
        }
    }//end gridInit()


    public void panelInit() {
        GridLayout gridLayout1 = new GridLayout(7, 7);
        panWest.setLayout(gridLayout1);
    }//end panelInit()

    public void calInput(int gap) {
        month += (gap);
        if (month <= 0) {
            month = 12;
            year = year - 1;
        } else if (month >= 13) {
            month = 1;
            year = year + 1;
        }
    }//end calInput()
}
