
package värdesaker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class guiWindow2 {

	private JFrame frame;
	private JTextField apparatNamnInmat;
	private JTextField apparatPrisInmat;
	private JTextField apparatSlitageInmat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiWindow2 window = new guiWindow2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guiWindow2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 506, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblApparatNamn = new JLabel("Namn");
		lblApparatNamn.setBounds(53, 28, 115, 33);
		frame.getContentPane().add(lblApparatNamn);
		
		apparatNamnInmat = new JTextField();
		apparatNamnInmat.setBounds(132, 25, 236, 39);
		frame.getContentPane().add(apparatNamnInmat);
		apparatNamnInmat.setColumns(10);
		
		JLabel lblApparatPris = new JLabel("Pris");
		lblApparatPris.setBounds(53, 77, 115, 33);
		frame.getContentPane().add(lblApparatPris);
		
		apparatPrisInmat = new JTextField();
		apparatPrisInmat.setColumns(10);
		apparatPrisInmat.setBounds(132, 74, 236, 39);
		frame.getContentPane().add(apparatPrisInmat);
		
		JButton apparatButtonOK = new JButton("OK");
		apparatButtonOK.setBounds(26, 191, 171, 41);
		frame.getContentPane().add(apparatButtonOK);
		
		JButton apparatCancelButton = new JButton("Cancel");
		apparatCancelButton.setBounds(277, 191, 171, 41);
		frame.getContentPane().add(apparatCancelButton);
		
		JLabel lblApparatSlitage = new JLabel("Slitage");
		lblApparatSlitage.setBounds(53, 138, 115, 33);
		frame.getContentPane().add(lblApparatSlitage);
		
		apparatSlitageInmat = new JTextField();
		apparatSlitageInmat.setBounds(132, 138, 236, 39);
		frame.getContentPane().add(apparatSlitageInmat);
		apparatSlitageInmat.setColumns(10);
	}
}
