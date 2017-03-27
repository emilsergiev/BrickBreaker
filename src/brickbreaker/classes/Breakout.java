package brickbreaker.classes;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Breakout extends JFrame
{
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JMenuItem menuItemStart;
	private JMenuItem menuItemPause;
	private JMenuItem menuItemResume;
	private JMenuItem menuItemLoad;
	private JMenuItem menuItemSave;
	private JMenuItem menuItemExit;
	private JMenuItem menuItemAbout;
	private JRadioButtonMenuItem btnSound;
	private JRadioButtonMenuItem btnMute;
	private Board board = new Board();

	protected Breakout()
	{
		initGUI();
		setMenuBar();
		createEvents();
	}

	private void initGUI()
	{
		setTitle("Wall Breaker - Breakout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Commons.WIDTH, Commons.HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		add(board);
	}

	private void setMenuBar()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource
				("/brickbreaker/resources/wall.png")));

		JMenuBar menuBar = new JMenuBar();
		JMenu menuGame = new JMenu("Game");
		JMenu menuSettings = new JMenu("Settings");
		JMenu menuHelp = new JMenu("Help");

		menuItemStart = new JMenuItem("Start");
		menuItemPause = new JMenuItem("Pause");
		menuItemResume = new JMenuItem("Resume");
		menuItemLoad = new JMenuItem("Load");
		menuItemSave = new JMenuItem("Save");
		menuItemExit = new JMenuItem("Exit");
		menuItemAbout = new JMenuItem("About");
		btnSound = new JRadioButtonMenuItem("Sound ON");
		btnMute = new JRadioButtonMenuItem("Sound OFF");

		buttonGroup.add(btnSound);
		buttonGroup.add(btnMute);
		btnSound.setSelected(true);

		setJMenuBar(menuBar);
		menuBar.add(menuGame);
		menuBar.add(menuSettings);
		menuBar.add(menuHelp);

		menuGame.add(menuItemStart);
		menuGame.add(menuItemPause);
		menuGame.add(menuItemResume);
		menuGame.add(menuItemLoad);
		menuGame.add(menuItemSave);
		menuGame.add(menuItemExit);

		menuSettings.add(btnSound);
		menuSettings.add(btnMute);

		menuHelp.add(menuItemAbout);
	}

	private void createEvents()
	{
		menuItemStart.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				board.playGame();
			}
		});

		menuItemPause.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				board.pause();
			}
		});

		menuItemResume.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				board.resume();
			}
		});

		menuItemLoad.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//TODO load saved game...
			}
		});

		menuItemSave.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//TODO save the current game progress...
			}
		});

		menuItemExit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//TODO ask for confirmation before exiting...
			}
		});

		menuItemAbout.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//TODO the about window...
			}
		});

		btnSound.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//TODO turn ON sound...
			}
		});

		btnMute.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//TODO turn OFF sound...
			}
		});
	}
}
