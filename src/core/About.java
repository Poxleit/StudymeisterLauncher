package core;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class About extends JDialog {

	private static final long serialVersionUID = 8972986733458833488L;

	public About() {
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		JLabel lblAbout = new JLabel("ABOUT");
		lblAbout.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAbout.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		getContentPane().add(lblAbout, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		getContentPane().add(textArea, BorderLayout.CENTER);
		textArea.setText("STUDYMEISTER FONIS PROJECT\n\n" +
				"-This project consists of two parts, the Launcher and the StudymeisterFONIS\n application.\n"+
				"-This project has been created for the FONIS hackhaton.\n"+
				"-This project has been coded by Poxleit(Nemanja Kurcubic).\n"+
				"-This project is an open source project located at github.com/Poxleit .\n");
		
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

	}

}
