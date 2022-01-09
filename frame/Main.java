package frame;

import javax.swing.JFrame;


public class Main {
public static Screen screen;


	public static void main(String[] args) { 
		// initial the Window Of the game 
		JFrame frame = new JFrame("Game Mario");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 360);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		
	
		screen = new Screen();
				
		frame.setContentPane(screen); 
		frame.setVisible(true);		
	}
}
