package brickbreaker.source;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

class Breakout extends JFrame {
	private static final long serialVersionUID = 1L;
	private final ButtonGroup groupSound = new ButtonGroup();
	private final ButtonGroup groupBackground = new ButtonGroup();
	private final ButtonGroup groupSoundEffects = new ButtonGroup();
	private Board board = new Board();
	private JMenuItem menuItemStart;
	private JMenuItem menuItemPause;
	private JMenuItem menuItemResume;
	private JMenuItem menuItemExit;
	private JMenuItem menuItemAbout;
	private JRadioButtonMenuItem btnSoundON;
	private JRadioButtonMenuItem btnSoundOFF;
	private JMenu backgroundMusic;
	private JMenu soundEffects;
	private JMenuItem bgLow;
	private JMenuItem bgMed;
	private JMenuItem bgHigh;
	private JMenuItem seLow;
	private JMenuItem seMed;
	private JMenuItem seHigh;

	Breakout() {
		initGUI();
		setMenuBar();
		createEvents();
		Sound.init();
	}

	private void initGUI() {
		setTitle("Wall Breaker - Breakout");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(Commons.WIDTH, Commons.HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		add(board);
	}

	private void setMenuBar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource
				("/brickbreaker/images/wall.png")));

		JMenuBar menuBar = new JMenuBar();
		JMenu menuGame = new JMenu("Game");
		JMenu menuSound = new JMenu("Sound");
		JMenu menuHelp = new JMenu("Help");

		menuItemStart = new JMenuItem("Start");
		menuItemPause = new JMenuItem("Pause");
		menuItemResume = new JMenuItem("Resume");
		menuItemExit = new JMenuItem("Exit");
		menuItemAbout = new JMenuItem("About");
		btnSoundON = new JRadioButtonMenuItem("Sound ON");
		btnSoundOFF = new JRadioButtonMenuItem("Sound OFF");
		backgroundMusic = new JMenu("Background Music");
		bgLow = new JRadioButtonMenuItem("LOW");
		bgMed = new JRadioButtonMenuItem("MEDUIM");
		bgHigh = new JRadioButtonMenuItem("HIGH");
		soundEffects = new JMenu("Sound Effects");
		seLow = new JRadioButtonMenuItem("LOW");
		seMed = new JRadioButtonMenuItem("MEDUIM");
		seHigh = new JRadioButtonMenuItem("HIGH");

		backgroundMusic.add(bgLow);
		backgroundMusic.add(bgMed);
		backgroundMusic.add(bgHigh);
		soundEffects.add(seLow);
		soundEffects.add(seMed);
		soundEffects.add(seHigh);

		groupSound.add(btnSoundON);
		groupSound.add(btnSoundOFF);
		btnSoundON.setSelected(true);

		groupBackground.add(bgLow);
		groupBackground.add(bgMed);
		groupBackground.add(bgHigh);
		bgMed.setSelected(true);

		groupSoundEffects.add(seLow);
		groupSoundEffects.add(seMed);
		groupSoundEffects.add(seHigh);
		seMed.setSelected(true);

		setJMenuBar(menuBar);
		menuBar.add(menuGame);
		menuBar.add(menuSound);
		menuBar.add(menuHelp);

		menuGame.add(menuItemStart);
		menuGame.add(menuItemPause);
		menuGame.add(menuItemResume);
		menuGame.add(menuItemExit);

		menuSound.add(btnSoundON);
		menuSound.add(btnSoundOFF);
		menuSound.addSeparator();
		menuSound.add(soundEffects);
		menuSound.add(backgroundMusic);

		menuHelp.add(menuItemAbout);
	}

	private void createEvents() {
		menuItemStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				board.playGame();
				board.soundON();
			}
		});

		menuItemPause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				board.pause();
			}
		});

		menuItemResume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				board.resume();
			}
		});

		menuItemExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int prompt = JOptionPane.showOptionDialog(Breakout.this,
						"Are you sure you want to exit?",
						"Wall Breaker", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (prompt == JOptionPane.YES_OPTION) {
					System.exit(0); 
				}
			}
		});

		menuItemAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setModal(true);
				about.setVisible(true);
			}
		});

		btnSoundON.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				board.soundON();
			}
		});

		btnSoundOFF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				board.soundOFF();
			}
		});

		bgLow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				board.volume = -25;
				board.soundOFF();
				board.soundON();
			}
		});

		bgMed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				board.volume = -15;
				board.soundOFF();
				board.soundON();
			}
		});

		bgHigh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				board.volume = -5;
				board.soundOFF();
				board.soundON();
			}
		});

		seLow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Sound.volume = -10;
			}
		});

		seMed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Sound.volume = -5;
			}
		});

		seHigh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Sound.volume = 0;
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				int prompt = JOptionPane.showOptionDialog(Breakout.this,
						"Are you sure you want to exit?",
						"Wall Breaker", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				if(prompt == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}
}
