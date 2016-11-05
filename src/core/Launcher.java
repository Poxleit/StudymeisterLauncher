package core;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import resources.FileManager;

public class Launcher extends JFrame {

	private static final long serialVersionUID = 5173147665573177980L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
					Launcher frame = new Launcher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(new File(Locations.getLocation()+"/Studymeister/StudymeisterFONIS.jar").isFile())){
					FileManager.getFiles(Locations.REPO_URL, Locations.getLocation() + "/Studymeister");
				}
				start();
				
			}
		});
		btnStart.setMinimumSize(new Dimension(80, 23));
		btnStart.setMaximumSize(new Dimension(80, 23));
		panel.add(btnStart);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((new File(Locations.getLocation() + "/Studymeister/StudymeisterFONIS.jar")).isFile()) { //To check if Studymeister has been downloaded previously
					FileManager.getFiles(Locations.REPO_URL, Locations.getLocation() + "/StudymeisterC");
					System.out.println(Locations.getLocation());
					double versionNew = 0;
					double versionOld = 0;
					try (Scanner scanner1 = new Scanner(
							new File(Locations.getLocation() + "/StudymeisterC/version.txt"));
							Scanner scanner2 = new Scanner(
									new File(Locations.getLocation() + "/Studymeister/version.txt"))) {
						versionNew = scanner1.nextDouble();
						versionOld = scanner2.nextDouble();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

					if (versionNew > versionOld) {
						FileManager.replaceFile(Locations.getLocation() + "/StudymeisterC/StudymeisterFONIS.jar",
								Locations.getLocation() + "/Studymeister/StudymeisterFONIS.jar");
						FileManager.replaceFile(Locations.getLocation() + "/StudymeisterC/StudymeisterFONIS.jar",
								Locations.getLocation() + "/Studymeister/StudymeisterFONIS.jar");
						Updated up = new Updated(true, versionOld, versionNew);
						up.setVisible(true);
					} else {
						Updated up = new Updated(false, versionOld, versionNew);
						up.setVisible(true);
					}
					FileManager.deleteFolder(new File(Locations.getLocation()+"/StudymeisterC")); //Clears the folder used for updates
				}else{ //Downloads the Studymeister
					FileManager.getFiles(Locations.REPO_URL, Locations.getLocation() + "/Studymeister");
					System.out.println("?");
				}
			}
		});
		btnUpdate.setMinimumSize(new Dimension(80, 23));
		btnUpdate.setMaximumSize(new Dimension(80, 23));
		panel.add(btnUpdate);

		JButton btnAbout = new JButton("ABOUT");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About ab = new About();
				ab.setVisible(true);
			}
		});
		btnAbout.setMaximumSize(new Dimension(80, 23));
		btnAbout.setMinimumSize(new Dimension(80, 23));
		panel.add(btnAbout);
	}

	private void exit() {
		System.exit(0);
	}

	private void start() {
		String location = Locations.getLocation() + "/Studymeister";
		ProcessBuilder studymeister = new ProcessBuilder("java", "-jar", location + "/StudymeisterFONIS.jar");
		studymeister.directory(new File(location));
		try {
			studymeister.start();
			exit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
