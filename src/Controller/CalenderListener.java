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

    String[] days = {"일", "월", "화", "수", "목", "금", "토"};
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
            calenderInterface.getTxtYear().setText(calenderInterface.getYear() + "년");
            calenderInterface.getTxtMonth().setText(calenderInterface.getMonth() + "월");
        } else if (button.getText() == "After") {
            calenderInterface.getPanWest().removeAll();
            calInput(1);
            gridInit();
            panelInit();
            calSet();
            hideInit();
            calenderInterface.getTxtYear().setText(calenderInterface.getYear() + "년");
            calenderInterface.getTxtMonth().setText(calenderInterface.getMonth() + "월");
        } else if (Integer.parseInt(ae.getActionCommand()) >= 1 &&
                Integer.parseInt(ae.getActionCommand()) <= 31) {

            calenderInterface.setDay(Integer.parseInt(ae.getActionCommand()));
            //버튼의 밸류 즉 1,2,3.... 문자를 정수형으로 변환하여 클릭한 날짜를 바꿔준다.
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
         * get 및 set 를 위한 필드치로, 요일을 나타냅니다.
         * 이 필드의 값은,SUNDAY,MONDAY,TUESDAY,WEDNESDAY
         * ,THURSDAY,FRIDAY, 및 SATURDAY 가 됩니다.
         * get()메소드의 의해 요일이 숫자로 반환
         */
        int j = 0;
        int hopping = 0;
        calenderInterface.getCalButton(0).setForeground(new Color(255, 0, 0));//일요일 "일"
        calenderInterface.getCalButton(6).setForeground(new Color(0, 0, 255));//토요일 "토"
        for (int i = calenderInterface.getCal().getFirstDayOfWeek(); i < dayOfWeek; i++) {
            j++;
        }
        /*
         * 일요일부터 그달의 첫시작 요일까지 빈칸으로 셋팅하기 위해
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
                if ((i + hopping - 1) % 7 == 0) {//일요일
                    calenderInterface.getCalButton(i + 6 + hopping).setForeground(new Color(255, 0, 0));
                }
                if ((i + hopping) % 7 == 0) {//토요일
                    calenderInterface.getCalButton(i + 6 + hopping).setForeground(new Color(0, 0, 255));
                }
            }
            /*
             * 요일을 찍은 다음부터 계산해야 하니 요일을 찍은 버튼의 갯수를 더하고
             * 인덱스가 0부터 시작이니 -1을 해준 값으로 연산을 해주고
             * 버튼의 색깔을 변경해준다.
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
            //일이 찍히지 않은 나머지 버튼을 비활성화 시킨다.
        }//end for
    }//end hideInit()

    public void gridInit() {
        //jPanel3에 버튼 붙이기
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
