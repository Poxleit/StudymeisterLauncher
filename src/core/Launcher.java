package core;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Launcher extends JFrame {

	private static final long serialVersionUID = 5173147665573177980L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher frame = new Launcher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Launcher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblStudymeisterLauncher = new JLabel("STUDYMEISTER LAUNCHER");
		lblStudymeisterLauncher.setHorizontalTextPosition(SwingConstants.CENTER);
		lblStudymeisterLauncher.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudymeisterLauncher.setFont(new Font("Papyrus", Font.PLAIN, 22));
		contentPane.add(lblStudymeisterLauncher, BorderLayout.NORTH);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exit();
			}
		});
		contentPane.add(btnExit, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnStart = new JButton("START");
		btnStart.setMinimumSize(new Dimension(80, 23));
		btnStart.setMaximumSize(new Dimension(80, 23));
		panel.add(btnStart);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setMinimumSize(new Dimension(80, 23));
		btnUpdate.setMaximumSize(new Dimension(80, 23));
		panel.add(btnUpdate);
		
		JButton btnAbout = new JButton("ABOUT");
		btnAbout.setMaximumSize(new Dimension(80, 23));
		btnAbout.setMinimumSize(new Dimension(80, 23));
		panel.add(btnAbout);
	}

	private void exit(){
		System.exit(0);
	}
}
