package _LabWorks.IhmDuree02.src.duree;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppliDuree {

	private JFrame frame;
	private JButton btnNewButton_2;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_7;
	private Duree d;
	char up ='\u25b2';
	char down ='\u25bc';
	private JLabel totalSec;
	private JLabel nbheures;
	private JLabel nbminutes;
	private JLabel nbsecondes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppliDuree window = new AppliDuree();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void plus_ou_moins(int i){
		try {
			d= new Duree(d.enSecondes()+i);
		}catch (Exception e){}
		totalSec.setText(""+d.enSecondes());
		nbheures.setText(""+d.getHeures());
		nbminutes.setText(""+d.getMinutes());
		nbsecondes.setText(""+d.getSecondes());	
	}
		
	private void Compt2(int a, int i) {
		int heures,minutes,secondes;
		
		heures = Integer.valueOf(nbheures.getText());
		minutes = Integer.parseInt(nbminutes.getText());
		secondes = Integer.parseInt(nbsecondes.getText());
		
		if (a>0){
			if((heures + i) % 24 ==0)
				heures = 0;
			else if (heures + i == -1)
				heures = 23;
			else
				heures =heures+i;
			nbheures.setText(""+heures);
			d = new Duree(heures,minutes,secondes);
			totalSec.setText(d.enSecondes()+"");}
			
			else if (a==0) {
			if(minutes + i == 60)
				minutes = 0;
			else if (minutes + i == -1)
				minutes = 59;
			else
				minutes =minutes +i;
			nbminutes.setText(""+minutes);
			
			d = new Duree(heures,minutes,secondes);
			
			totalSec.setText(d.enSecondes()+"");
			
			}
			else {
			
			if(secondes + i == 60)
				secondes = 0;
			else if (secondes + i == - 1)
				secondes = 59;
			else
				secondes +=i;
			nbsecondes.setText(""+secondes);
			d = new Duree(heures,minutes,secondes);
			totalSec.setText(d.enSecondes()+"");
			}
		}
	/**
	 * Create the application.
	 */
	public AppliDuree() {
		d=new Duree(3599);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("  -  ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plus_ou_moins(-1);

			}
		});
		panel.add(btnNewButton_1);
		
		totalSec = new JLabel(d.enSecondes()+"");
		panel.add(totalSec);
		
		JLabel lblNewLabel = new JLabel("secondes");
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("  +  ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plus_ou_moins(1);
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("  h  ");
		panel_5.add(lblNewLabel_2, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		btnNewButton_2 = new JButton(up+"");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//plus_ou_moins(3600);
				Compt2(1,1);

			}
		});
		panel_9.add(btnNewButton_2, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		nbheures = new JLabel("7");
		nbheures.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(nbheures, BorderLayout.CENTER);
		
		JPanel panel_11 = new JPanel();
		panel_8.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		btnNewButton_3 = new JButton(down+"");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//plus_ou_moins(-3600);
				Compt2(1,-1);

			}
		});
		panel_11.add(btnNewButton_3, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.EAST);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("  m  ");
		panel_6.add(lblNewLabel_3, BorderLayout.CENTER);
		
		JPanel panel_12 = new JPanel();
		panel_3.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_12.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		btnNewButton_5 = new JButton(up+"");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//plus_ou_moins(60);
				Compt2(0,1);

			}
		});
		panel_13.add(btnNewButton_5, BorderLayout.CENTER);
		
		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		nbminutes = new JLabel("6");
		nbminutes.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(nbminutes, BorderLayout.CENTER);
		
		JPanel panel_15 = new JPanel();
		panel_12.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		btnNewButton_4 = new JButton(down+"");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//plus_ou_moins(-60);
				Compt2(0,-1);

			}
		});
		panel_15.add(btnNewButton_4, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7, BorderLayout.EAST);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("  s  ");
		panel_7.add(lblNewLabel_4, BorderLayout.CENTER);
		
		JPanel panel_16 = new JPanel();
		panel_4.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_16.add(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		btnNewButton_6 = new JButton(up+"");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//plus_ou_moins(1);
				Compt2(-1,1);
			}
		});
		panel_17.add(btnNewButton_6, BorderLayout.CENTER);
		
		JPanel panel_18 = new JPanel();
		panel_16.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));
		
		nbsecondes = new JLabel("5");
		nbsecondes.setHorizontalAlignment(SwingConstants.CENTER);
		panel_18.add(nbsecondes, BorderLayout.CENTER);
		
		JPanel panel_19 = new JPanel();
		panel_16.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		btnNewButton_7 = new JButton(down+"");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//plus_ou_moins(-1);
				Compt2(-1,-1);
			}
		});
		panel_19.add(btnNewButton_7, BorderLayout.CENTER);
	}

}
