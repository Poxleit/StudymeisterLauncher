package core;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Updated extends JDialog {

	private static final long serialVersionUID = 1L;

	public Updated(boolean updated, double oldVersion, double newVersion) {
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JLabel lblUpdate = new JLabel("UPDATE");
				lblUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
				lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
				lblUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				panel.add(lblUpdate, BorderLayout.NORTH);
			}
			{
				JTextArea textArea = new JTextArea();
				textArea.setEditable(false);
				panel.add(textArea, BorderLayout.CENTER);
				if (updated) {
					textArea.setText("PROJECT HAS BEEN UPDATED!\n\n" + "Previous version   :" + "  " + oldVersion + "\n"
							+ "Current version    :" + "  " + newVersion + "\n");
				} else {
					textArea.setText("PROJECT IS ALREADY UP TO DATE!\n" + "Current version    :" + "  " + newVersion + "\n");
				}
			}
			this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		}
	}

}
