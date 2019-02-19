package helloworld;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CustomPaint {
	
		public static void main(String[] args) {
			
			
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					createAndShowGUI();
					
				}
			});
			
			
		}
		
		private static void createAndShowGUI() {
			
			System.out.println("Created GUI on EDT? "+
					SwingUtilities.isEventDispatchThread());
			
			JFrame f = new JFrame ("Swing Paint Demo");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setSize(250, 250);
			f.setVisible(true);
		}

}
