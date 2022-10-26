package ihmDuree;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class AppliDuree {

    private Duree d;
    private JFrame frmExamen;
    char up = '\u25b2';
    char down = '\u25bc';
    JLabel nbsecAffichees;
    private JLabel nbsecAffichees_1;
    private JLabel nbsecondes;
    private JLabel nbminutes;
    private JLabel nbheures;

    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppliDuree window = new AppliDuree();
                    window.frmExamen.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    void plusmoins(int i) {
        try {
            d = new Duree(d.enSecondes() + i);
        } catch (Exception e) {

        }
        nbsecAffichees_1.setText("" + d.enSecondes());
        nbheures.setText("" + d.getHeures());
        nbsecondes.setText("" + d.getSecondes());
        nbminutes.setText("" + d.getMinutes());
    }

    void heut_bas(int i) {
        plusmoins(i);
    }


    /**
     * Create the application.
     */
    public AppliDuree() {
        // ----------------------------------------------------------------
        d = new Duree(1000);
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmExamen = new JFrame();
        frmExamen.setType(Type.UTILITY);
        frmExamen.setTitle("examen");
        frmExamen.setBounds(100, 100, 516, 371);
        frmExamen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmExamen.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frmExamen.getContentPane().add(panel, BorderLayout.SOUTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnNewButton = new JButton("  -  ");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plusmoins(-1);
            }
        });
        panel.add(btnNewButton);
        JLabel lblNewLabel_1 = new JLabel("Secondes");
        panel.add(lblNewLabel_1);
        nbsecAffichees_1 = new JLabel(d.enSecondes() + "");
        panel.add(nbsecAffichees_1);

        JButton btnNewButton_1 = new JButton("  +  ");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plusmoins(1);

            }
        });
        panel.add(btnNewButton_1);

        JPanel panel_1 = new JPanel();
        frmExamen.getContentPane().add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(1, 0, 0, 0));

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel_1.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));

        JPanel panel_5 = new JPanel();
        panel_2.add(panel_5, BorderLayout.EAST);
        panel_5.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_4 = new JLabel("  H  ");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        panel_5.add(lblNewLabel_4);

        JPanel panel_8 = new JPanel();
        panel_2.add(panel_8, BorderLayout.CENTER);
        panel_8.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_9 = new JPanel();
        panel_8.add(panel_9);
        panel_9.setLayout(new BorderLayout(0, 0));

        JButton btnNewButton_2 = new JButton(up + ""); // ---------------------------
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                heut_bas(3600);
            }
        });
        panel_9.add(btnNewButton_2, BorderLayout.CENTER);

        JPanel panel_10 = new JPanel();
        panel_8.add(panel_10);
        panel_10.setLayout(new BorderLayout(0, 0));

        nbheures = new JLabel(d.getHeures() + "");
        nbheures.setHorizontalAlignment(SwingConstants.CENTER);
        panel_10.add(nbheures, BorderLayout.CENTER);

        JPanel panel_11 = new JPanel();
        panel_8.add(panel_11);
        panel_11.setLayout(new BorderLayout(0, 0));

        JButton btnNewButton_3 = new JButton(down + "");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                heut_bas(-3600);
            }
        });
        panel_11.add(btnNewButton_3, BorderLayout.CENTER);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel_1.add(panel_3);
        panel_3.setLayout(new BorderLayout(0, 0));

        JPanel panel_6 = new JPanel();
        panel_3.add(panel_6, BorderLayout.EAST);
        panel_6.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_5 = new JLabel("   M   ");
        panel_6.add(lblNewLabel_5);

        JPanel panel_12 = new JPanel();
        panel_3.add(panel_12, BorderLayout.CENTER);
        panel_12.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_13 = new JPanel();
        panel_12.add(panel_13);
        panel_13.setLayout(new BorderLayout(0, 0));

        JButton btnNewButton_5 = new JButton("" + up);
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                heut_bas(60);

            }
        });
        panel_13.add(btnNewButton_5, BorderLayout.CENTER);

        JPanel panel_14 = new JPanel();
        panel_12.add(panel_14);
        panel_14.setLayout(new BorderLayout(0, 0));

        nbminutes = new JLabel(d.getMinutes() + "");
        nbminutes.setHorizontalAlignment(SwingConstants.CENTER);
        panel_14.add(nbminutes, BorderLayout.CENTER);

        JPanel panel_15 = new JPanel();
        panel_12.add(panel_15);
        panel_15.setLayout(new BorderLayout(0, 0));

        JButton btnNewButton_4 = new JButton(down + "");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                heut_bas(-60);

            }
        });
        panel_15.add(btnNewButton_4, BorderLayout.CENTER);

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel_1.add(panel_4);
        panel_4.setLayout(new BorderLayout(0, 0));

        JPanel panel_7 = new JPanel();
        panel_4.add(panel_7);
        panel_7.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_16 = new JPanel();
        panel_7.add(panel_16);
        panel_16.setLayout(new BorderLayout(0, 0));

        JButton btnNewButton_7 = new JButton(up + "");
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                heut_bas(1);

            }
        });
        panel_16.add(btnNewButton_7, BorderLayout.CENTER);

        JPanel panel_17 = new JPanel();
        panel_7.add(panel_17);
        panel_17.setLayout(new BorderLayout(0, 0));

        nbsecondes = new JLabel(d.getSecondes() + "");
        nbsecondes.setHorizontalAlignment(SwingConstants.CENTER);
        panel_17.add(nbsecondes, BorderLayout.CENTER);

        JPanel panel_18 = new JPanel();
        panel_7.add(panel_18);
        panel_18.setLayout(new BorderLayout(0, 0));

        JButton btnNewButton_6 = new JButton(down + "");
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                heut_bas(-1);
            }
        });
        panel_18.add(btnNewButton_6, BorderLayout.CENTER);

        JPanel panel_19 = new JPanel();
        panel_4.add(panel_19, BorderLayout.EAST);
        panel_19.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_6 = new JLabel("  S  ");
        panel_19.add(lblNewLabel_6);
    }

}
