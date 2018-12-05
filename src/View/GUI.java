package View;

import java.awt.*;
import java.util.Vector;

import Controller.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame {
	private static final GUI ourInstance = new GUI();
	public static GUI getInstance() {
		return ourInstance;
	}
	public Calender calender = new Calender();
    public JCheckBox play = new JCheckBox();
    public JTextField datesales_t = new JTextField();
    public JButton datesales_e = new JButton("확인");
    public JCheckBox beforeplay = new JCheckBox();
    public JComboBox age_e = new JComboBox(new String[]{"","전체 이용가","12세 이용가","15세 이용가","19세 이용가"});
    public JComboBox nation_e = new JComboBox(new String[]{"","Korea","USA","Europe", "Japan", "China", "ex"});
    public JComboBox genre_e = new JComboBox(new String[]{"","Action","Thriller","Drama","SF","Adventure","Fantasy","Romance","Crime","Comedy","Mystery","Animation","War","Horror"});
    public JComboBox releasedate_e = new JComboBox( new String[]{"", "수요일", "목요일"});
    public JTextField expectation_t = new JTextField();
    public JButton expectation_e = new JButton("확인");
    public JTextField title_t = new JTextField();
    public JButton title_e = new JButton("확인");
    public JTextField playtime_t = new JTextField();
    public JButton playtime_e = new JButton("확인");
    public JButton addInformation = new JButton("추가");
    public JButton execution = new JButton("실행");
    public Vector<String> userColumn = new Vector<String>();
    public Vector<String> userRow;
    public DefaultTableModel model;
    public GUI(){
      this.setTitle("Movie Scheduling");
      
      JPanel West = new JPanel();
      West.setLayout(new BorderLayout());
      
      West.add(calender,BorderLayout.CENTER);
      
      JPanel inform = new JPanel();
      inform.setLayout(new BorderLayout());
      inform.add(new JLabel("입력된 영화"),BorderLayout.NORTH);
      
      userColumn.addElement("Name");
      userColumn.addElement("PlayTime");
      userColumn.addElement("Sales");
      model = new DefaultTableModel(userColumn, 0);
      JTable movieinform = new JTable(model);
      JScrollPane listJs = new JScrollPane(movieinform);
      inform.add(listJs, BorderLayout.CENTER);

      JPanel input = new JPanel();
      
      JPanel playing = new JPanel();
      PlayListener playlistener = new PlayListener();
      play.addItemListener(playlistener);
      playing.setLayout(new BorderLayout());
      JPanel playing_w = new JPanel();
      
      playing_w.setLayout(new GridLayout(1,2));
      playing_w.add( new JLabel("상영 ") );
      playing_w.add( play);
      
      playing.add(playing_w,BorderLayout.WEST);
      playing.add(new JLabel(""),BorderLayout.EAST);
      
      JPanel datesales = new JPanel();
      DateSalesListener datesaleslistener = new DateSalesListener();
      datesales_e.addActionListener(datesaleslistener);
      datesales.setLayout(new BorderLayout());
      datesales.add(new JLabel("일별 매출액 : "),BorderLayout.WEST);
      datesales.add(datesales_t,BorderLayout.CENTER );
      datesales.add(datesales_e,BorderLayout.EAST);
      
      JPanel beforeplaying = new JPanel();
      BeforePlayListener beforeplaylistener = new BeforePlayListener();
      beforeplay.addItemListener(beforeplaylistener);
      beforeplaying.setLayout(new BorderLayout());
      JPanel beforeplaying_w = new JPanel();
      
      beforeplaying_w.setLayout(new GridLayout(1,2));
      beforeplaying_w.add( new JLabel("개봉 전 ") );
      beforeplaying_w.add( beforeplay);
      
      beforeplaying.add(beforeplaying_w,BorderLayout.WEST);
      beforeplaying.add(new JLabel(""),BorderLayout.EAST);
      
      JPanel genre = new JPanel();
      GenreListener genrelistener = new GenreListener();
      genre_e.addItemListener(genrelistener);
      genre.setLayout(new BorderLayout());
      genre.add(new JLabel("      장르   :   "),BorderLayout.WEST);
      genre.add(genre_e,BorderLayout.CENTER );
      
      JPanel nation = new JPanel();
      NationListener nationlistener = new NationListener();
      nation_e.addItemListener(nationlistener);
      nation.setLayout(new BorderLayout());
      nation.add(new JLabel("  제작 국가 :   "),BorderLayout.WEST);
      nation.add(nation_e,BorderLayout.CENTER );
      
      JPanel age = new JPanel();
      AgeListener agelistener = new AgeListener();
      age_e.addItemListener(agelistener);
      age.setLayout(new BorderLayout());
      age.add(new JLabel("  관람 연령 :   "),BorderLayout.WEST);
      age.add(age_e,BorderLayout.CENTER );
      
      JPanel expectation = new JPanel();
      ExpectationListener expectationlistener = new ExpectationListener();
      expectation_e.addActionListener(expectationlistener);
      expectation.setLayout(new BorderLayout());
      expectation.add(new JLabel("기대해요  : "),BorderLayout.WEST);
      expectation.add(expectation_t,BorderLayout.CENTER );
      expectation.add(expectation_e,BorderLayout.EAST);
      
      JPanel title = new JPanel();
      TitleListener titlelistener = new TitleListener();
      title_e.addActionListener(titlelistener);
      title.setLayout(new BorderLayout());
      title.add(new JLabel("영화제목 : "),BorderLayout.WEST);
      title.add(title_t,BorderLayout.CENTER );
      title.add(title_e,BorderLayout.EAST );
      
      JPanel playtime = new JPanel();
      PlayTimeListener playtimelistener = new PlayTimeListener();
      playtime_e.addActionListener(playtimelistener);
      playtime.setLayout(new BorderLayout());
      playtime.add(new JLabel("상영시간 : "),BorderLayout.WEST);
      playtime.add(playtime_t,BorderLayout.CENTER );
      playtime.add(playtime_e,BorderLayout.EAST);
      
      JPanel releasedate = new JPanel();
      ReleaseDateListener releasedatelistener = new ReleaseDateListener();
      releasedate_e.addItemListener(releasedatelistener);
      releasedate.setLayout(new BorderLayout());
      releasedate.add(new JLabel("개봉요일  : "),BorderLayout.WEST);
      releasedate.add(releasedate_e,BorderLayout.CENTER );
      
      
      JPanel addition = new JPanel();
      AdditionListener additionlistener = new AdditionListener();
      addInformation.addActionListener(additionlistener);
      addition.setLayout(new GridLayout(1,3));
      
      addition.add(new JLabel(""));
      addition.add(addInformation);
    
      addition.add(new JLabel(""));
      
      JPanel exe = new JPanel();
      ExeListener exelistener = new ExeListener();
      execution.addActionListener(exelistener);
      exe.setLayout(new GridLayout(1,3));

      exe.add(new JLabel(""));
      exe.add(execution);
      exe.add(new JLabel(""));
      
      input.setLayout(new GridLayout(28,1));
      input.add(new JLabel(""));
      input.add(new JLabel(""));
      input.add(title);
      input.add(playtime);
      input.add(new JLabel(""));
      input.add(playing);
      input.add(datesales);
      input.add(new JLabel(""));
      input.add(new JLabel(""));
      input.add(new JLabel(""));
      
      input.add(beforeplaying);
      input.add(nation);
      input.add(age);
      input.add(genre);
      input.add(expectation);
      input.add(releasedate);
      input.add(new JLabel(""));
      input.add(new JLabel(""));
      
      input.add(addition);
      input.add(new JLabel(""));
      
      input.add(new JLabel(""));
      
      input.add(exe);
      input.add(new JLabel(""));
      input.add(new JLabel(""));
      
      JPanel East = new JPanel();
      East.setLayout(new GridLayout(1,2));
      East.add(inform);
      East.add(input);
      
      this.setLayout(new GridLayout(1,2));
      this.add(West);
      this.add(East);
      
      genre_e.setVisible(false);
      nation_e.setVisible(false);
      age_e.setVisible(false);
      expectation_t.setVisible(false);
      expectation_e.setVisible(false);
      datesales_t.setVisible(false);
      datesales_e.setVisible(false);
      releasedate_e.setVisible(false);
      addInformation.setEnabled(false);
      execution.setEnabled(false);
      
      this.setVisible(true);
      this.setSize(2300, 1000);
   }
   
   public static void main(String[] args){
	   
   }
}
