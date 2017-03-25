package brickbreaker.classes;

import java.awt.Toolkit;

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
	private JMenuItem menuItemLoad;
	private JMenuItem menuItemSave;
	private JMenuItem menuItemExit;
	private JMenuItem menuItemAbout;
	private JRadioButtonMenuItem btnSound;
	private JRadioButtonMenuItem btnMute;

	protected Breakout()
	{
		initGUI();
	}

	private void initGUI()
	{
		setMenuBarOptions();

		setTitle("Brick Breaker - Breakout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Commons.WIDTH, Commons.HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		add(new Board());
	}

	private void setMenuBarOptions()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource
				("/brickbreaker/resources/spider.png")));

		JMenuBar menuBar = new JMenuBar();
		JMenu menuGame = new JMenu("Game");
		JMenu menuSettings = new JMenu("Settings");
		JMenu menuHelp = new JMenu("Help");

		menuItemStart = new JMenuItem("New Game");
		menuItemPause = new JMenuItem("Pause Game");
		menuItemLoad = new JMenuItem("Load Game");
		menuItemSave = new JMenuItem("Save Game");
		menuItemExit = new JMenuItem("Exit");
		btnSound = new JRadioButtonMenuItem("Sound ON");
		btnMute = new JRadioButtonMenuItem("Sound OFF");
		menuItemAbout = new JMenuItem("About");

		buttonGroup.add(btnSound);
		buttonGroup.add(btnMute);
		btnSound.setSelected(true);

		setJMenuBar(menuBar);
		menuBar.add(menuGame);
		menuBar.add(menuSettings);
		menuBar.add(menuHelp);

		menuGame.add(menuItemStart);
		menuGame.add(menuItemPause);
		menuGame.add(menuItemLoad);
		menuGame.add(menuItemSave);
		menuGame.add(menuItemExit);

		menuSettings.add(btnSound);
		menuSettings.add(btnMute);

		menuHelp.add(menuItemAbout);
		
	}
}
