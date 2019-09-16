package igra;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Igra {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Tenis");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(new IgraOkvir(), BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
