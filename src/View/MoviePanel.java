package View;

import Controller.*;

import javax.swing.*;
import java.awt.*;

public class MoviePanel extends JPanel {

    private JCheckBox play = new JCheckBox();
    private JCheckBox beforeplay = new JCheckBox();
    private JTextField title_t = new JTextField();
    private JButton title_e = new JButton("확인");
    private JTextField playtime_t = new JTextField();
    private JButton playtime_e = new JButton("확인");

    private JComboBox age_e = new JComboBox(new String[]{"", "전체 이용가", "12세 이용가", "15세 이용가", "19세 이용가"});
    private JComboBox nation_e = new JComboBox(new String[]{"", "Korea", "USA", "Europe", "Japan", "China", "ex"});
    private JComboBox genre_e = new JComboBox(new String[]{"", "Action", "Thriller", "Drama", "SF", "Adventure", "Fantasy", "Romance", "Crime", "Comedy", "Mystery", "Animation", "War", "Horror"});
    private JComboBox releasedate_e = new JComboBox(new String[]{"", "수요일", "목요일"});

    private JTextField datesales_t = new JTextField();
    private JButton datesales_e = new JButton("확인");
    private JTextField expectation_t = new JTextField();
    private JButton expectation_e = new JButton("확인");

    public MoviePanel(){

        //
        JPanel playing = new JPanel();
        PlayListener playlistener = new PlayListener();
        play.addItemListener(playlistener);
        playing.setLayout(new BorderLayout());

        //
        JPanel playing_w = new JPanel();

        playing_w.setLayout(new GridLayout(1, 2));
        playing_w.add(new JLabel("상영 "));
        playing_w.add(play);

        playing.add(playing_w, BorderLayout.WEST);
        playing.add(new JLabel(""), BorderLayout.EAST);

        JPanel datesales = new JPanel();
        DateSalesListener datesaleslistener = new DateSalesListener();
        datesales_e.addActionListener(datesaleslistener);
        datesales.setLayout(new BorderLayout());
        datesales.add(new JLabel("일별 매출액 : "), BorderLayout.WEST);
        datesales.add(datesales_t, BorderLayout.CENTER);
        datesales.add(datesales_e, BorderLayout.EAST);

        //
        JPanel beforeplaying = new JPanel();
        BeforePlayListener beforeplaylistener = new BeforePlayListener();
        beforeplay.addItemListener(beforeplaylistener);
        beforeplaying.setLayout(new BorderLayout());
        JPanel beforeplaying_w = new JPanel();

        beforeplaying_w.setLayout(new GridLayout(1, 2));
        beforeplaying_w.add(new JLabel("개봉 전 "));
        beforeplaying_w.add(beforeplay);

        beforeplaying.add(beforeplaying_w, BorderLayout.WEST);
        beforeplaying.add(new JLabel(""), BorderLayout.EAST);

        JPanel genre = new JPanel();
        GenreListener genrelistener = new GenreListener();
        genre_e.addItemListener(genrelistener);
        genre.setLayout(new BorderLayout());
        genre.add(new JLabel("      장르   :   "), BorderLayout.WEST);
        genre.add(genre_e, BorderLayout.CENTER);

        JPanel nation = new JPanel();
        NationListener nationlistener = new NationListener();
        nation_e.addItemListener(nationlistener);
        nation.setLayout(new BorderLayout());
        nation.add(new JLabel("  제작 국가 :   "), BorderLayout.WEST);
        nation.add(nation_e, BorderLayout.CENTER);

        JPanel age = new JPanel();
        AgeListener agelistener = new AgeListener();
        age_e.addItemListener(agelistener);
        age.setLayout(new BorderLayout());
        age.add(new JLabel("  관람 연령 :   "), BorderLayout.WEST);
        age.add(age_e, BorderLayout.CENTER);

        JPanel expectation = new JPanel();
        ExpectationListener expectationlistener = new ExpectationListener();
        expectation_e.addActionListener(expectationlistener);
        expectation.setLayout(new BorderLayout());
        expectation.add(new JLabel("기대해요  : "), BorderLayout.WEST);
        expectation.add(expectation_t, BorderLayout.CENTER);
        expectation.add(expectation_e, BorderLayout.EAST);

        JPanel title = new JPanel();
        TitleListener titlelistener = new TitleListener();
        title_e.addActionListener(titlelistener);
        title.setLayout(new BorderLayout());
        title.add(new JLabel("영화제목 : "), BorderLayout.WEST);
        title.add(title_t, BorderLayout.CENTER);
        title.add(title_e, BorderLayout.EAST);

        JPanel playtime = new JPanel();
        PlayTimeListener playtimelistener = new PlayTimeListener();
        playtime_e.addActionListener(playtimelistener);
        playtime.setLayout(new BorderLayout());
        playtime.add(new JLabel("상영시간 : "), BorderLayout.WEST);
        playtime.add(playtime_t, BorderLayout.CENTER);
        playtime.add(playtime_e, BorderLayout.EAST);

        JPanel releasedate = new JPanel();
        ReleaseDateListener releasedatelistener = new ReleaseDateListener();
        releasedate_e.addItemListener(releasedatelistener);
        releasedate.setLayout(new BorderLayout());
        releasedate.add(new JLabel("개봉요일  : "), BorderLayout.WEST);
        releasedate.add(releasedate_e, BorderLayout.CENTER);

        this.setLayout(new GridLayout(28, 1));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(title);
        this.add(playtime);
        this.add(new JLabel(""));
        this.add(playing);
        this.add(datesales);
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));

        this.add(beforeplaying);
        this.add(nation);
        this.add(age);
        this.add(genre);
        this.add(expectation);
        this.add(releasedate);
        this.add(new JLabel(""));
        this.add(new JLabel(""));

        genre_e.setVisible(false);
        nation_e.setVisible(false);
        age_e.setVisible(false);
        expectation_t.setVisible(false);
        expectation_e.setVisible(false);
        datesales_t.setVisible(false);
        datesales_e.setVisible(false);
        releasedate_e.setVisible(false);
    }
}
