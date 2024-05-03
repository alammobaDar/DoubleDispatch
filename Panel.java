package Package;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;


import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener, MouseMotionListener, ActionListener{
	
	static final int UNIT_SIZE = 5;
    static final int WIDTH = 940;
    static final int HEIGHT = 590;

    private Color[][] colors;
    private JButton resetButton, red, blue, green, yellow, erase, black;
    private Color designatedColor = Color.black;
    int row;
    int col;
    
    Panel(){
        this.setBounds(240,200,WIDTH,HEIGHT);
        this.setBackground(Color.white);
        this.setLayout(null);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        colors = new Color[HEIGHT / UNIT_SIZE][WIDTH / UNIT_SIZE];
        for(int i = 0; i < colors.length; i++) {
            for(int j = 0; j< colors[i].length;j++) {
                colors[i][j] = Color.WHITE;
            }
        }
        resetButton = new JButton("Clear");
        resetButton.addActionListener(this);
        resetButton.setBounds(10,10,100,30);
        resetButton.setFocusable(false);
        this.add(resetButton);
        
        red = new JButton();
        red.addActionListener(this);
        red.setBounds(500, 10, 15, 15);  
        red.setBackground(Color.red);
        this.add(red);
        
        blue = new JButton();
        blue.addActionListener(this);
        blue.setBounds(520, 10, 15, 15);  
        blue.setBackground(Color.blue);
        this.add(blue);
        
        green = new JButton();
        green.addActionListener(this);
        green.setBounds(540, 10, 15, 15);  
        green.setBackground(Color.green);
        this.add(green);
        
        yellow = new JButton();
        yellow.addActionListener(this);
        yellow.setBounds(560, 10, 15, 15);  
        yellow.setBackground(Color.yellow);
        this.add(yellow);
        
        erase = new JButton();
        erase.addActionListener(this);
        erase.setBounds(580, 10, 15, 15);  
        erase.setBackground(Color.white);
        this.add(erase);
        
        black = new JButton();
        black.addActionListener(this);
        black.setBounds(600, 10, 15, 15);  
        black.setBackground(Color.black);
        this.add(black);
        
        
        }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);

        //GridLines
        for(int i = 0; i<HEIGHT/UNIT_SIZE; i++ ) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, HEIGHT);
            g.drawLine(0, i*UNIT_SIZE, WIDTH, i*UNIT_SIZE);
        }

        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                g.setColor(colors[i][j]);
                g.fillRect(j * UNIT_SIZE, i * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Reset all colors to white
    	if(e.getSource() == resetButton)
        for(int i = 0; i < colors.length; i++) {
            for(int j = 0; j< colors[i].length;j++) {
                colors[i][j] = Color.WHITE;
            }
        }
    	if(e.getSource() == red) {
    		designatedColor = Color.red;
       	}
    	if(e.getSource() == blue) {
    		designatedColor = Color.blue;
       	}
    	if(e.getSource() == green) {
    		designatedColor = Color.green;
       	}
    	if(e.getSource() == yellow) {
    		designatedColor = Color.yellow;
       	}
    	if(e.getSource() == erase) {
    		designatedColor = Color.white;
       	}
    	if(e.getSource() == black) {
    		designatedColor = Color.black;
       	}
        repaint();
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        row = e.getY() / UNIT_SIZE;
        col = e.getX() / UNIT_SIZE;

        if (isValid(row, col)){
            colors[row][col] = designatedColor;
            repaint();
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        row = e.getY() / UNIT_SIZE;
        col = e.getX() / UNIT_SIZE;

        if (isValid(row, col)){
            colors[row][col] = designatedColor;
            repaint();
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }
    private boolean isValid(int row, int col) {
        return row >= 0 && row < colors.length && col >= 0 && col < colors[0].length;

    }
}
