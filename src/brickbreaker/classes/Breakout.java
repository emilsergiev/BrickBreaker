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
		setMenuBarOptions();
		createEvents();
	}

	private void initGUI()
	{
		

		setTitle("Brick Breaker - Breakout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Commons.WIDTH, Commons.HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		add(board);
	}

	private void setMenuBarOptions()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource
				("/brickbreaker/resources/spider.png")));

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
				board.setPlay(true);
			}
		});

		menuItemPause.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//TODO pause game call...
			}
		});

		menuItemResume.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//TODO resume paused game call...
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
	}
}