package frame;



public class Moving implements Runnable{

	private final int PAUSE = 3; 
	
	
	//**** METHODES **//
	@Override
	public void run() {

		while(true){ 			
			Main.sreen.repaint(); 
			try {Thread.sleep(PAUSE);} // repaint the window of the game after 3milisecond
			catch (InterruptedException e) {}
		}
	}
}
