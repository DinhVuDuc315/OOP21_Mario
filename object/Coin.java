package object;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Coin extends Object implements Runnable{

	//**** VARIABLES ****//
	private final int PAUSE = 15; //waiting time in ms between 2 loop turns
	private int counter;
    //**** CONSTRUCTEUR	****//	
	public Coin(int x, int y) {
		super(x, y, 30, 30);		
		super.iconObject = new ImageIcon(getClass().getResource("/images/coin1.png"));
		super.imgObject = this.iconObject.getImage();
	}
	
	
	//**** GETTERS ****//		

	//**** SETTERS ****//
	
	//**** METHODES ****//
	public Image move(){ // Movement of the coin   
    	
    	String string;
		ImageIcon icon;
		Image image;
		
        this.counter++;
		if (this.counter / 100 == 0) {string = "/images/coin1.png";}
		else{string = "/images/coin2.png";}							    
		if (this.counter == 200) {this.counter = 0;}
		
		// Display the character's image
		icon = new ImageIcon(getClass().getResource(string));
        image = icon.getImage();
		return image;
    	
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{Thread.sleep(20);} // wait 20 ms before calling move so that all the objects are completely created
		catch (InterruptedException e){}		
			
		while(true){ 										
			this.move();// infinite loop
			try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
		}	
	}
}
// hello