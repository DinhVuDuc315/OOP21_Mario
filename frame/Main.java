package frame;

import javax.swing.JFrame;


public class Main {
public static Screen sreen;


	public static void main(String[] args) { 
		// initial the Window Of the game 
		JFrame frame = new JFrame("Mario Game Project Demo Final");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 360);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		
	
		sreen = new Screen();
				
		frame.setContentPane(sreen); 
		frame.setVisible(true);		
	}
}
