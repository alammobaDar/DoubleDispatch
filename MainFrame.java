package Package;

import java.awt.Graphics;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	Panel panel;
	
	MainFrame(){
		
		panel = new Panel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(panel);
		this.pack();
		this.setVisible(true);
	}
	
}
