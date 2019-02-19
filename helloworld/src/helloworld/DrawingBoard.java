package helloworld;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingBoard extends JPanel {
	
	public DrawingBoard( ) {
		setBorder(BorderFactory.createLineBorder(Color.black));
		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(250, 200);
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawString("This is a custom drawing area",10,20);
	}



JFrame f = new JFrame("Swing Paint Demo");

f.add(new DrawingBoard());
f.pack();

f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

f.setVisible(True);

}