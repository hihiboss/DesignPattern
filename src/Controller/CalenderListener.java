package Controller;

import Model.TimeSchedule;
import Model.TimeScheduleList;
import View.Calender;
import View.CalenderInterface;
import View.SchedulePanelInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class CalenderListener implements ActionListener {

    String[] days = {"��", "��", "ȭ", "��", "��", "��", "��"};
    private CalenderInterface calenderInterface;
    private SchedulePanelInterface schedulePanel;
    private TimeScheduleList timeScheduleList;

    public CalenderListener(CalenderInterface calenderInterface, SchedulePanelInterface schedulePanel){
        this.calenderInterface = calenderInterface;
        this.schedulePanel = schedulePanel;
        timeScheduleList = new TimeScheduleList();

        calenderInterface.setBtnListener(this);
        gridInit();
        calSet();
        hideInit();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton button = (JButton)ae.getSource();
        if (button.getText() == "Before") {
            calenderInterface.getPanWest().removeAll();
            calInput(-1);
            gridInit();
            panelInit();
            calSet();
            hideInit();
            calenderInterface.getTxtYear().setText(calenderInterface.getYear() + "��");
            calenderInterface.getTxtMonth().setText(calenderInterface.getMonth() + "��");
        } else if (button.getText() == "After") {
            calenderInterface.getPanWest().removeAll();
            calInput(1);
            gridInit();
            panelInit();
            calSet();
            hideInit();
            calenderInterface.getTxtYear().setText(calenderInterface.getYear() + "��");
            calenderInterface.getTxtMonth().setText(calenderInterface.getMonth() + "��");
        } else if (Integer.parseInt(ae.getActionCommand()) >= 1 &&
                Integer.parseInt(ae.getActionCommand()) <= 31) {

            calenderInterface.setDay(Integer.parseInt(ae.getActionCommand()));
            //��ư�� ��� �� 1,2,3.... ���ڸ� ���������� ��ȯ�Ͽ� Ŭ���� ��¥�� �ٲ��ش�.
            schedulePanel.getExecution().setEnabled(true);
            for (int h = 0; h < 49; h++) {
                if (calenderInterface.getCalButton(h).getText().equals(ae.getActionCommand())) {
                    calenderInterface.getCalButton(h).setEnabled(false);
                } else {
                    calenderInterface.getCalButton(h).setEnabled(true);
                }
            }
            hideInit();
        }
    }

    public void calSet() {
        calenderInterface.getCal().set(Calendar.YEAR, calenderInterface.getYear());
        calenderInterface.getCal().set(Calendar.MONTH, (calenderInterface.getMonth() - 1));
        calenderInterface.getCal().set(Calendar.DATE, 1);
        int dayOfWeek = calenderInterface.getCal().get(Calendar.DAY_OF_WEEK);
        /*
         * get �� set �� ���� �ʵ�ġ��, ������ ��Ÿ���ϴ�.
         * �� �ʵ��� ����,SUNDAY,MONDAY,TUESDAY,WEDNESDAY
         * ,THURSDAY,FRIDAY, �� SATURDAY �� �˴ϴ�.
         * get()�޼ҵ��� ���� ������ ���ڷ� ��ȯ
         */
        int j = 0;
        int hopping = 0;
        calenderInterface.getCalButton(0).setForeground(new Color(255, 0, 0));//�Ͽ��� "��"
        calenderInterface.getCalButton(6).setForeground(new Color(0, 0, 255));//����� "��"
        for (int i = calenderInterface.getCal().getFirstDayOfWeek(); i < dayOfWeek; i++) {
            j++;
        }
        /*
         * �Ͽ��Ϻ��� �״��� ù���� ���ϱ��� ��ĭ���� �����ϱ� ����
         */
        hopping = j;
        for (int kk = 0; kk < hopping; kk++) {

            calenderInterface.getCalButton(kk+7).setText("");

        }
        for (int i = calenderInterface.getCal().getMinimum(Calendar.DAY_OF_MONTH);
             i <= calenderInterface.getCal().getMaximum(Calendar.DAY_OF_MONTH); i++) {
            calenderInterface.getCal().set(Calendar.DATE, i);
            if (calenderInterface.getCal().get(Calendar.MONTH) != calenderInterface.getMonth() - 1) {
                break;
            }

            calenderInterface.setTodays(i);
            if (calenderInterface.getMemoday() == 1) {
                calenderInterface.getCalButton(i + 6 + hopping).setForeground(new Color(0, 255, 0));
            } else {
                calenderInterface.getCalButton(i + 6 + hopping).setForeground(new Color(0, 0, 0));
                if ((i + hopping - 1) % 7 == 0) {//�Ͽ���
                    calenderInterface.getCalButton(i + 6 + hopping).setForeground(new Color(255, 0, 0));
                }
                if ((i + hopping) % 7 == 0) {//�����
                    calenderInterface.getCalButton(i + 6 + hopping).setForeground(new Color(0, 0, 255));
                }
            }
            /*
             * ������ ���� �������� ����ؾ� �ϴ� ������ ���� ��ư�� ������ ���ϰ�
             * �ε����� 0���� �����̴� -1�� ���� ������ ������ ���ְ�
             * ��ư�� ������ �������ش�.
             */
            calenderInterface.getCalButton(i + 6 + hopping).setFont(new Font("San-Serif", Font.PLAIN, 35));
            calenderInterface.getCalButton(i + 6 + hopping).setText((i) + "");
            TimeSchedule timeschedule = new TimeSchedule();
            timeschedule.setYear(calenderInterface.getYear());
            timeschedule.setMonth(calenderInterface.getMonth());
            timeschedule.setDate(i);
            timeScheduleList.addTimeSchedule(timeschedule);
        }//for
        for (int h = 1; h <= 4; h++) {
            TimeSchedule timeschedule = new TimeSchedule();
            timeschedule.setYear(calenderInterface.getYear());
            timeschedule.setMonth(calenderInterface.getMonth());
            timeschedule.setDate(timeScheduleList.getTimeScheduleAt(
                    timeScheduleList.getLength() - 1).getDate() + 1);
            timeScheduleList.addTimeSchedule(timeschedule);
        }
    }//end Calset()

    public void hideInit() {
        for (int i = 0; i < calenderInterface.getCalBtn().length; i++) {
            if ((calenderInterface.getCalButton(i).getText()).equals(""))
                calenderInterface.getCalButton(i).setEnabled(false);
            //���� ������ ���� ������ ��ư�� ��Ȱ��ȭ ��Ų��.
        }//end for
    }//end hideInit()

    public void gridInit() {
        //jPanel3�� ��ư ���̱�
        timeScheduleList.clear();
        for (int i = 0; i < days.length; i++) {
            calenderInterface.setCalButton(i, new JButton(days[i]));
            calenderInterface.getPanWest().add(calenderInterface.getCalButton(i));
            calenderInterface.getCalButton(i).setFont(new Font("San-Serif", Font.PLAIN, 25));
            calenderInterface.getCalButton(i).setContentAreaFilled(false);
            calenderInterface.getCalButton(i).setBorderPainted(false);

        }
        for (int i = days.length; i < 49; i++) {
            calenderInterface.setCalButton(i, new JButton(""));
            calenderInterface.getPanWest().add(calenderInterface.getCalButton(i));
            calenderInterface.getCalButton(i).addActionListener(this);
        }
    }//end gridInit()


    public void panelInit() {
        GridLayout gridLayout1 = new GridLayout(7, 7);
        calenderInterface.getPanWest().setLayout(gridLayout1);
    }//end panelInit()

    public void calInput(int gap) {
        int temp = calenderInterface.getMonth();
        temp += (gap);
        calenderInterface.setMonth(temp);
        if (calenderInterface.getMonth() <= 0) {
            calenderInterface.setMonth(12);
            calenderInterface.setYear(calenderInterface.getYear() - 1);
        } else if (calenderInterface.getMonth() >= 13) {
            calenderInterface.setMonth(1);
            calenderInterface.setYear(calenderInterface.getYear() + 1);
        }
    }//end calInput()
}
