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

    private String[] days = {"일", "월", "화", "수", "목", "금", "토"};
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
            this.txtYear.setText(year + "년");
            this.txtMonth.setText(month + "월");
        } else if (button.getText() == "After") {
            this.panWest.removeAll();
            calInput(1);
            gridInit();
            panelInit();
            calSet();
            hideInit();
            this.txtYear.setText(year + "년");
            this.txtMonth.setText(month + "월");
        } else if (Integer.parseInt(ae.getActionCommand()) >= 1 &&
                Integer.parseInt(ae.getActionCommand()) <= 31) {

            day = Integer.parseInt(ae.getActionCommand())
            //버튼의 밸류 즉 1,2,3.... 문자를 정수형으로 변환하여 클릭한 날짜를 바꿔준다.
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
         * get 및 set 를 위한 필드치로, 요일을 나타냅니다.
         * 이 필드의 값은,SUNDAY,MONDAY,TUESDAY,WEDNESDAY
         * ,THURSDAY,FRIDAY, 및 SATURDAY 가 됩니다.
         * get()메소드의 의해 요일이 숫자로 반환
         */
        int j = 0;
        int hopping = 0;
        calBtn[0].setForeground(new Color(255, 0, 0));//일요일 "일"
        calBtn[6].setForeground(new Color(0, 0, 255));//토요일 "토"
        for (int i = cal.getFirstDayOfWeek(); i < dayOfWeek; i++) {
            j++;
        }
        /*
         * 일요일부터 그달의 첫시작 요일까지 빈칸으로 셋팅하기 위해
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
                if ((i + hopping - 1) % 7 == 0) {//일요일
                    calBtn[i + 6 + hopping].setForeground(new Color(255, 0, 0));
                }
                if ((i + hopping) % 7 == 0) {//토요일
                    calBtn[i + 6 + hopping].setForeground(new Color(0, 0, 255));
                }
            }
            /*
             * 요일을 찍은 다음부터 계산해야 하니 요일을 찍은 버튼의 갯수를 더하고
             * 인덱스가 0부터 시작이니 -1을 해준 값으로 연산을 해주고
             * 버튼의 색깔을 변경해준다.
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
            //일이 찍히지 않은 나머지 버튼을 비활성화 시킨다.
        }//end for
    }//end hideInit()

    public void gridInit() {
        //jPanel3에 버튼 붙이기
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
