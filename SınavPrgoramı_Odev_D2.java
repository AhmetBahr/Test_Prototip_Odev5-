import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SýnavPrgoramý_Odev_D2 extends JFrame implements  ActionListener{
    private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton NextButton, SonucButton;
	ButtonGroup bg;
	int Dogru = 0, SoruSay = 0;
	int m[] = new int[10];

	
	SýnavPrgoramý_Odev_D2(String s) {
		
		label = new JLabel();
		add(label);
		
		//Þýklarý ekrana getirmek içi 
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		
		//Buttonlarý ekrana getirme ve iþlemleri için
		NextButton = new JButton("Next");
		SonucButton = new JButton("Result");
		SonucButton.setVisible(false);
                NextButton.addActionListener(this);
                SonucButton.addActionListener(this);
		add(NextButton);
		add(SonucButton);
		set();
		label.setBounds(30, 40, 450, 20);

		//Butonlarýn konumu ve boyutu
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		NextButton.setBounds(100, 240, 100, 30);
		SonucButton.setBounds(270, 240, 100, 30);
		//Ana ekranýn iþlem kodlarý
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// Bittiðinde sonucu gösterme 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == NextButton) {
			if (check()) {
				Dogru = Dogru + 1;
			}
			SoruSay++;
			set();
			
			//Son soru için
			if (SoruSay == 9) {
				NextButton.setEnabled(false);
				SonucButton.setVisible(true);
                SonucButton.setText("Bitir");
			}
		}
		if (e.getActionCommand().equals("Bitir")) {
			if (check())
				Dogru = Dogru + 1;
			SoruSay++;
			JOptionPane.showMessageDialog(this, "Doðru cevap = " + Dogru);
			System.exit(0);
		}
	}

	// Soru ve þýklar
	void set() {
		radioButton[4].setSelected(true);
		if (SoruSay == 0) {
			label.setText("Soru1: 5+6 = ?");
			radioButton[0].setText("10");
			radioButton[1].setText("11");
			radioButton[2].setText("9");
			radioButton[3].setText("8");
		}
		if (SoruSay == 1) {
			label.setText("Soru2: 6-5 = ?");
			radioButton[0].setText("10");
			radioButton[1].setText("1");
			radioButton[2].setText("9");
			radioButton[3].setText("8");
		}
		if (SoruSay == 2) {
			label.setText("Soru3: 2+66 = ?");
			radioButton[0].setText("68");
			radioButton[1].setText("11");
			radioButton[2].setText("9");
			radioButton[3].setText("8");
		}
		if (SoruSay == 3) {
			label.setText("Soru4: 39-8 = ?");
			radioButton[0].setText("10");
			radioButton[1].setText("11");
			radioButton[2].setText("31");
			radioButton[3].setText("8");
		}
		if (SoruSay == 4) {
			label.setText("Soru5: 58-6 = ?");
			radioButton[0].setText("52");
			radioButton[1].setText("11");
			radioButton[2].setText("9");
			radioButton[3].setText("8");
		}
		if (SoruSay == 5) {
			label.setText("Soru6: 30+43 = ?");
			radioButton[0].setText("73");
			radioButton[1].setText("11");
			radioButton[2].setText("9");
			radioButton[3].setText("8");
		}
		if (SoruSay == 6) {
			label.setText("Soru7: 40-20 = ?");
			radioButton[0].setText("11");
			radioButton[1].setText("20");
			radioButton[2].setText("9");
			radioButton[3].setText("8");
		}
		if (SoruSay == 7) {
			label.setText("Soru8: 56+6 = ?");
			radioButton[0].setText("10");
			radioButton[1].setText("11");
			radioButton[2].setText("62");
			radioButton[3].setText("8");
		}
		if (SoruSay == 8) {
			label.setText("Soru9: 10/5 = ?");
			radioButton[0].setText("2");
			radioButton[1].setText("11");
			radioButton[2].setText("9");
			radioButton[3].setText("8");
		}
		if (SoruSay == 9) {
			label.setText("Soru10: 11*4 = ?");
			radioButton[0].setText("40");
			radioButton[1].setText("11");
			radioButton[2].setText("9");
			radioButton[3].setText("8");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// Cevap doðru mu kontrol 
	boolean check() {
		if (SoruSay == 0)
			return (radioButton[1].isSelected());
		if (SoruSay == 1)
			return (radioButton[1].isSelected());
		if (SoruSay == 2)
			return (radioButton[0].isSelected());
		if (SoruSay == 3)
			return (radioButton[2].isSelected());
		if (SoruSay == 4)
			return (radioButton[0].isSelected());
		if (SoruSay == 5)
			return (radioButton[0].isSelected());
		if (SoruSay == 6)
			return (radioButton[1].isSelected());
		if (SoruSay == 7)
			return (radioButton[2].isSelected());
		if (SoruSay == 8)
			return (radioButton[0].isSelected());
		if (SoruSay == 9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String args[]) {
		new SýnavPrgoramý_Odev_D2("SýnavPrgoramý_Odev2");
	}
    
}