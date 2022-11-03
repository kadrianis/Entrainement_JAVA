package TpServeurJava;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class ServerApp {

	private JFrame fenetreServerHttpJava;
	private JTextField portNumberTextField;
	private JTextField rootTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerApp window = new ServerApp();
					window.fenetreServerHttpJava.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Methods
	 */
	private boolean checkPath(Path p) {
		try {
			p.toRealPath();
		} catch (IOException e2) {

			return false;
		}
		return true;
	}

	/**
	 * Create the application.
	 */
	public ServerApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fenetreServerHttpJava = new JFrame();
		fenetreServerHttpJava.setFont(new Font("Monospaced", Font.PLAIN, 12));
		fenetreServerHttpJava.setTitle("Server Http Java");
		fenetreServerHttpJava.setResizable(false);
		fenetreServerHttpJava.setBounds(100, 100, 450, 300);
		fenetreServerHttpJava.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetreServerHttpJava.getContentPane().setLayout(null);

		portNumberTextField = new JTextField();
		portNumberTextField.setFont(new Font("Monospaced", Font.PLAIN, 14));
		portNumberTextField.setBounds(156, 79, 171, 30);
		fenetreServerHttpJava.getContentPane().add(portNumberTextField);
		portNumberTextField.setColumns(10);

		JButton lunchButton = new JButton("Start");
		lunchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Variables
				int portNumber = 7070;
				boolean portNumberIsOk;
				boolean rootIsOk;
				Path root;
				
				
				// Port Number
				if (portNumberTextField.getText().equals("")) {
					portNumberIsOk = true;
					// JOptionPane.showMessageDialog(fenetreServerHttpJava,"Your portNumber is :
					// "+portNumber);
				} else {
					try {
						portNumber = Integer.parseInt(portNumberTextField.getText());
						if (portNumber < 0) {
							JOptionPane.showMessageDialog(fenetreServerHttpJava,
									portNumberTextField.getText() + " is not a positive integer");
							portNumberIsOk = false;
						} else if (!(portNumber > 0 && portNumber < 65536)) {
							JOptionPane.showMessageDialog(fenetreServerHttpJava,
									"The port number must be between 0 and 65536");
							portNumberIsOk = false;
						} else
							portNumberIsOk = true;
						// JOptionPane.showMessageDialog(fenetreServerHttpJava,"Your portNumber is :
						// "+portNumber);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(fenetreServerHttpJava,
								portNumberTextField.getText() + " is not an integer");
						portNumberIsOk = false;

					}

				}

				// Server's path root
				if (portNumberIsOk) {
					portNumberTextField.setText(portNumber + "");

					if (rootTextField.getText().equals("")) {
						JOptionPane.showMessageDialog(fenetreServerHttpJava, "the root field cannot be empty");
					} else {
						root = Paths.get(rootTextField.getText());
						rootIsOk = checkPath(root);
						if (!rootIsOk)
							JOptionPane.showMessageDialog(fenetreServerHttpJava, root + " is not a real path");
						else
							JOptionPane.showMessageDialog(fenetreServerHttpJava,"                         Server config :"
									+ "\nportNumber : "+portNumber+"" + "\nroot : "+root+"\n\nEverything is fine, let's lunched the Server :)");
						ServerHttp server = new ServerHttp(portNumber, root);
					}
				
				}	
				
			}
			

		});
		lunchButton.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lunchButton.setBounds(183, 174, 89, 30);
		fenetreServerHttpJava.getContentPane().add(lunchButton);

		JLabel portNumberLabel = new JLabel("PortNumber :");
		portNumberLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
		portNumberLabel.setBounds(61, 78, 102, 30);
		fenetreServerHttpJava.getContentPane().add(portNumberLabel);

		JLabel rootLabel = new JLabel("Root :");
		rootLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
		rootLabel.setBounds(61, 120, 57, 30);
		fenetreServerHttpJava.getContentPane().add(rootLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter server's configuration to start ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1.setBounds(34, 11, 390, 41);
		fenetreServerHttpJava.getContentPane().add(lblNewLabel_1);

		rootTextField = new JTextField();
		rootTextField.setFont(new Font("Monospaced", Font.PLAIN, 14));
		rootTextField.setBounds(110, 120, 279, 30);
		fenetreServerHttpJava.getContentPane().add(rootTextField);
		rootTextField.setColumns(10);
	}
}
