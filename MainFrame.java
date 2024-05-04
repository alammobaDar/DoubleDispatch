package Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame implements ActionListener {
    Shape circle = new Circle();
    Shape square = new Square();
    Tool pen = new Pen();

    Circle c = new Circle();
    Square s = new Square();
    static Pen p;

     Panel whiteBoard;
    
     JFrame frame = new JFrame("Simple Whiteboard");
     static String[] shapesOptions = {"Default", "Circle" ,"Square"};
     String[] toolsOptions = {"Pen","Brush"};
     static JComboBox shapes = new JComboBox(shapesOptions);
     static JLabel text = new JLabel("Using pen on ______");
     ImageIcon logoImage = new ImageIcon("C:\\Users\\Jonel Villaver\\Downloads\\appLogo.png");
     JLabel title = new JLabel("Shape Canvas");
     
     ImageIcon CIRCLE = new ImageIcon("C:\\Users\\Admin\\Downloads\\circle (2).png");
     ImageIcon SQUARE = new ImageIcon("C:\\Users\\Admin\\Downloads\\square.png");

    MainFrame(){

        whiteBoard = new Panel();
        p = new Pen();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(whiteBoard);
        frame.getContentPane().setBackground(new Color(237, 235, 235));
        frame.setLayout(null);
        frame.setSize(1250, 900);

        whiteBoard.setBorder(BorderFactory.createLineBorder(new Color(122, 122, 122),5));

        title.setBounds(25,30,400,50);
        title.setFont(new Font("Poppins", Font.BOLD, 35));
        title.setIconTextGap(20);
        title.setIcon(logoImage);

        shapes.setBounds(15,250,150,40);
        shapes.setFont(new Font("Poppins", Font.BOLD, 20));
        shapes.addActionListener(this);

        text.setBounds(550,150,350,35);
        text.setFont(new Font("Poppins", Font.BOLD, 30));
        text.setOpaque(true);
        text.setVisible(true);

        frame.add(shapes);
        frame.add(title);
        frame.add(text);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==shapes) {
            
        	if(shapes.getSelectedItem().equals("Default")){
        		whiteBoard.Imagelabel.setIcon(null);
            }
        	
        	else if(shapes.getSelectedItem().equals("Circle")){
                circle.drawWith(pen);
                whiteBoard.Imagelabel.setIcon(CIRCLE);
                
            }
            else if(shapes.getSelectedItem().equals("Square")){
                square.drawWith(pen);
                whiteBoard.Imagelabel.setIcon(SQUARE);
            }
        }
    }
}