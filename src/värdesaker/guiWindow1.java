
package värdesaker;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class guiWindow1 {

	private JFrame MainFrame;
	
	private JFrame smallFrameSmycke;
	private JTextField smyckeNamnInmat;
	private JTextField smyckeStenarInmat;
	
	private JFrame smallFrameAktie;
	private JTextField aktieNamnInmat;
	private JTextField aktieAntalInmat;
	private JTextField aktieKursInmat;
	
	private JFrame smallFrameApparat;
	private JTextField apparatNamnInmat;
	private JTextField apparatPrisInmat;
	private JTextField apparatSlitageInmat;
	
	private ArrayList<Smycken> ArrayListSmycken = new ArrayList<Smycken>();
	private ArrayList<Aktie> ArrayListAktie = new ArrayList<Aktie>();
	private ArrayList<Apparater> ArrayListApparater = new ArrayList<Apparater>();
	private DefaultListModel DLM = new DefaultListModel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiWindow1 window = new guiWindow1();
					window.MainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public guiWindow1() {
		MainFrame();
	} 

	private void MainFrame() {
		MainFrame = new JFrame();
		MainFrame.setBounds(100, 100, 627, 421);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getContentPane().setLayout(null);
		
		JList outputList = new JList();
		outputList.setBounds(26, 38, 415, 238);
		MainFrame.getContentPane().add(outputList);
		
		JLabel lblVrdesaker = new JLabel("V\u00E4rdesaker");
		lblVrdesaker.setBounds(185, 0, 208, 33);
		MainFrame.getContentPane().add(lblVrdesaker);
		
		JLabel lblSortering = new JLabel("Sortering");
		lblSortering.setBounds(456, 64, 172, 80);
		MainFrame.getContentPane().add(lblSortering);
		
		JRadioButton rdbtnName = new JRadioButton("Name");
		rdbtnName.setBounds(456, 132, 131, 33);
		MainFrame.getContentPane().add(rdbtnName);
		
		JRadioButton rdbtnPrice = new JRadioButton("Price");
		rdbtnPrice.setBounds(456, 185, 251, 41);
		MainFrame.getContentPane().add(rdbtnPrice);
		
		JButton btnVisa = new JButton("Visa");
		btnVisa.setBounds(204, 280, 171, 41);
		MainFrame.getContentPane().add(btnVisa);
		btnVisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Smycken s : ArrayListSmycken)
                {
                    DLM.addElement("Namn: "+s.getName()+" Stenar: "+s.getStones()+" Pris: "+s.getPrice());
                }
				for (Aktie ak : ArrayListAktie) {
					DLM.addElement("Namn: "+ak.getName()+" Antal: "+ak.getAmount()+" Kurs: "+ak.getStockPrice()+" Pris: "+ak.getPrice());
				}
				for (Apparater ap : ArrayListApparater) {
					DLM.addElement("Namn: "+ap.getName()+" Pris: "+ap.getbuyPrice()+" Slitage: "+ap.getSlitage()+" Värde: "+ap.getPrice());
				}
				outputList.setModel(DLM);
            }			
		});
		
		JButton btnBrskrasch = new JButton("Börskrasch");
		btnBrskrasch.setBounds(382, 280, 171, 41);
		MainFrame.getContentPane().add(btnBrskrasch);
		btnBrskrasch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Aktie i : ArrayListAktie) {
					i.krasch();
				}
			}
		});
		
		String[] comboBoxVal = {"Smycke", "Aktie", "Apparater"};
		JComboBox comboBox = new JComboBox(comboBoxVal);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox.getSelectedItem();
				switch(selectedItem) {
				case "Smycke":
					smallFrameSmycke();
					break;
					
				case "Aktie":
					smallFrameAktie();
					break;
					
				case "Apparater":
					smallFrameApparat();
					break;
				}

			}
		});
		comboBox.setBounds(98, 281, 96, 39);
		MainFrame.getContentPane().add(comboBox);
		
		JLabel lblNytt = new JLabel("Nytt");
		lblNytt.setBounds(36, 284, 58, 33);
		MainFrame.getContentPane().add(lblNytt);
	}
	
	private void smallFrameSmycke() {

		smallFrameSmycke = new JFrame();
		smallFrameSmycke.setBounds(100, 100, 450, 300);
		smallFrameSmycke.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		smallFrameSmycke.getContentPane().setLayout(null);
		
		JLabel lblSmyckeNamn = new JLabel("Namn");
		lblSmyckeNamn.setBounds(53, 28, 115, 33);
		smallFrameSmycke.getContentPane().add(lblSmyckeNamn);
		
		smyckeNamnInmat = new JTextField();
		smyckeNamnInmat.setBounds(132, 25, 236, 39);
		smallFrameSmycke.getContentPane().add(smyckeNamnInmat);
		smyckeNamnInmat.setColumns(10);
		
		JLabel lblSmyckeStenar = new JLabel("Stenar");
		lblSmyckeStenar.setBounds(53, 77, 115, 33);
		smallFrameSmycke.getContentPane().add(lblSmyckeStenar);
		
		smyckeStenarInmat = new JTextField();
		smyckeStenarInmat.setColumns(10);
		smyckeStenarInmat.setBounds(132, 74, 236, 39);
		smallFrameSmycke.getContentPane().add(smyckeStenarInmat);
		
		JCheckBox isGoldCheckBox = new JCheckBox("Guld");
		isGoldCheckBox.setBounds(175, 115, 221, 41);
		smallFrameSmycke.getContentPane().add(isGoldCheckBox);
		
		JButton smyckeButtonOK = new JButton("OK");
		smyckeButtonOK.setBounds(26, 156, 171, 41);
		smallFrameSmycke.getContentPane().add(smyckeButtonOK);
		smyckeButtonOK.addActionListener((new ActionListener(){				
			public void actionPerformed(ActionEvent event) {				
				boolean checked = isGoldCheckBox.isSelected();
				int smyckeStenar;
				String smyckeNamn;
				smyckeNamn = ((String.valueOf(smyckeNamnInmat.getText())));
				smyckeStenar = ((Integer.valueOf(smyckeStenarInmat.getText())));
				Smycken s = new Smycken(smyckeNamn,smyckeStenar, checked);
				ArrayListSmycken.add(s);							
				smallFrameSmycke.dispose();							
			}		
		}));
		
		JButton smyckeCancelButton = new JButton("Cancel");
		smyckeCancelButton.setBounds(221, 156, 171, 41);
		smallFrameSmycke.getContentPane().add(smyckeCancelButton);
		smyckeCancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				smallFrameSmycke.dispose();
			}
		});
		
		smallFrameSmycke.setVisible(true);
	}
	
	private void smallFrameAktie() {
		smallFrameAktie = new JFrame();
		smallFrameAktie.setBounds(100, 100, 506, 348);
		smallFrameAktie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		smallFrameAktie.getContentPane().setLayout(null);
			
		JLabel lblAktieNamn = new JLabel("Namn");
		lblAktieNamn.setBounds(53, 28, 115, 33);
		smallFrameAktie.getContentPane().add(lblAktieNamn);
		
		aktieNamnInmat = new JTextField();
		aktieNamnInmat.setBounds(132, 25, 236, 39);
		smallFrameAktie.getContentPane().add(aktieNamnInmat);
		aktieNamnInmat.setColumns(10);
			
		JLabel lblAktieAntal = new JLabel("Antal");
		lblAktieAntal.setBounds(53, 77, 115, 33);
		smallFrameAktie.getContentPane().add(lblAktieAntal);
		
		aktieAntalInmat = new JTextField();
		aktieAntalInmat.setColumns(10);
		aktieAntalInmat.setBounds(132, 74, 236, 39);
		smallFrameAktie.getContentPane().add(aktieAntalInmat);
		
		JButton aktieButtonOK = new JButton("OK");
		aktieButtonOK.setBounds(26, 191, 171, 41);
		smallFrameAktie.getContentPane().add(aktieButtonOK);
		aktieButtonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aktieNamn = ((String.valueOf(aktieNamnInmat.getText())));
				int aktieAntal = ((Integer.valueOf(aktieAntalInmat.getText())));
				int aktieKurs = ((Integer.valueOf(aktieKursInmat.getText())));
				Aktie ak = new Aktie(aktieNamn,aktieAntal, aktieKurs);
				ArrayListAktie.add(ak);					
				smallFrameAktie.dispose();	
			}
		});
			
		JButton aktieCancelButton = new JButton("Cancel");
		aktieCancelButton.setBounds(277, 191, 171, 41);
		smallFrameAktie.getContentPane().add(aktieCancelButton);
		aktieCancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				smallFrameAktie.dispose();
			}			
		});
		
		JLabel lblAktieKurs = new JLabel("Kurs");
		lblAktieKurs.setBounds(53, 138, 115, 33);
		smallFrameAktie.getContentPane().add(lblAktieKurs);			
		aktieKursInmat = new JTextField();
		aktieKursInmat.setBounds(132, 138, 236, 39);
		smallFrameAktie.getContentPane().add(aktieKursInmat);
		aktieKursInmat.setColumns(10);
			
		smallFrameAktie.setVisible(true);
	}

	private void smallFrameApparat() {
		smallFrameApparat = new JFrame();
		smallFrameApparat.setBounds(100, 100, 506, 348);
		smallFrameApparat.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		smallFrameApparat.getContentPane().setLayout(null);
		
		JLabel lblApparatNamn = new JLabel("Namn");
		lblApparatNamn.setBounds(53, 28, 115, 33);
		smallFrameApparat.getContentPane().add(lblApparatNamn);
		
		apparatNamnInmat = new JTextField();
		apparatNamnInmat.setBounds(132, 25, 236, 39);
		smallFrameApparat.getContentPane().add(apparatNamnInmat);
		apparatNamnInmat.setColumns(10);
		
		JLabel lblApparatPris = new JLabel("Pris");
		lblApparatPris.setBounds(53, 77, 115, 33);
		smallFrameApparat.getContentPane().add(lblApparatPris);
		
		apparatPrisInmat = new JTextField();
		apparatPrisInmat.setColumns(10);
		apparatPrisInmat.setBounds(132, 74, 236, 39);
		smallFrameApparat.getContentPane().add(apparatPrisInmat);
		
		JButton apparatButtonOK = new JButton("OK");
		apparatButtonOK.setBounds(26, 191, 171, 41);
		smallFrameApparat.getContentPane().add(apparatButtonOK);
		apparatButtonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String apparatNamn = ((String.valueOf(apparatNamnInmat.getText())));
				int apparatPris = ((Integer.valueOf(apparatPrisInmat.getText())));
				int apparatSlitage = ((Integer.valueOf(apparatSlitageInmat.getText())));
				Apparater ap = new Apparater(apparatNamn,apparatPris, apparatSlitage);
				ArrayListApparater.add(ap);					
				smallFrameApparat.dispose();	
			}
		});
		
		JButton apparatCancelButton = new JButton("Cancel");
		apparatCancelButton.setBounds(277, 191, 171, 41);
		smallFrameApparat.getContentPane().add(apparatCancelButton);
		apparatCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smallFrameApparat.dispose();			
			}			
		});
		
		JLabel lblApparatSlitage = new JLabel("Slitage");
		lblApparatSlitage.setBounds(53, 138, 115, 33);
		smallFrameApparat.getContentPane().add(lblApparatSlitage);
		
		apparatSlitageInmat = new JTextField();
		apparatSlitageInmat.setBounds(132, 138, 236, 39);
		smallFrameApparat.getContentPane().add(apparatSlitageInmat);
		apparatSlitageInmat.setColumns(10);
		
		smallFrameApparat.setVisible(true);
	}
}


