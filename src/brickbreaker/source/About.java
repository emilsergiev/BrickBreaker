package brickbreaker.source;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

class About extends JDialog
{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args)
	{
		About dialog = new About();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	About()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(About.class.getResource("/brickbreaker/images/wall.png")));
		setAlwaysOnTop(true);
		setResizable(false);
		setBackground(SystemColor.windowBorder);
		setTitle("Wall Breaker - About");
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 17));
		setSize(450, 200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.menu);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JTextArea txtAbout = new JTextArea();
		txtAbout.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtAbout.setBackground(SystemColor.menu);
		txtAbout.setEditable(false);
		contentPanel.add(txtAbout);
		txtAbout.setText("\nAuthors: Emil Sergiev & Preslava Kuzova\n\nRelease Date: April 8, 2017\n\nVersion: 1.0a.brick.wall");

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(SystemColor.menu);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
	}
}
