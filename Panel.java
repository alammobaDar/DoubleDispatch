package Package;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener, MouseMotionListener{
	
	static final int UNIT_SIZE = 5;
	static final int WIDTH = 550;
	static final int HEIGHT = 550;
	
	private Color[][] colors;	
	Panel(){
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setBackground(Color.white);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		colors = new Color[HEIGHT / UNIT_SIZE][WIDTH / UNIT_SIZE];
		System.out.println(colors);
		for(int i = 0; i < colors.length; i++) {
			for(int j = 0; j< colors[i].length;j++) {
				colors[i][j] = Color.WHITE;
			}
			
		}
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
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = e.getY() / UNIT_SIZE;		
		int col = e.getX() / UNIT_SIZE;
		
		if (isValid(row, col)){
			colors[row][col] = Color.red;
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
		int row = e.getY() / UNIT_SIZE;		
		int col = e.getX() / UNIT_SIZE;
		
		if (isValid(row, col)){
			colors[row][col] = Color.red;
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
