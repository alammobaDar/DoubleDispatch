package Package;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	MainFrame(){
//		this.setSize(800, 550);
//		this.setResizable(false);
//		this.setLayout(null);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		this.setVisible(true);
		
		Circle circle = new Circle();
		Square square = new Square();
		Tool pen = new Pen();
		
		circle.drawWith(pen);
		square.drawWith(pen);
	}
	
}
