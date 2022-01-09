package character;

import java.awt.Image;

import javax.swing.ImageIcon;

import audio.Audio;
import frame.Main;
import object.Coin;
import object.Object;

public class Mario extends Character{
	private Image imgMario;
	private ImageIcon iconMario;
    private boolean jump; // checking variable jump of the mario
    private int counterJump; // counter Jump of the mario
	private int counterDead;
	
	//**** CONSTRUCTEUR	****//	
	public Mario(int x, int y) {

	super(x, y, 28, 50);		
	this.iconMario = new ImageIcon(getClass().getResource("/images/marioTurnRight2.png"));
	this.imgMario = this.iconMario.getImage();
	
	this.jump = false;
	this.counterJump = 0;
	this.counterDead = 0;

	}

		
	//**** GETTERS ****//		
	public Image getImgMario() {return imgMario;}

	public boolean isJump() {return jump;}
	
		
	//**** SETTERS ****//
	public void setJump(boolean jump) {this.jump = jump;}

	//**** METHODES ****//
	@Override	
	public Image walking(String name, int frequence){
		
		String string;
		ImageIcon icon;
		Image image;
		
		if(this.walking == false || Main.sreen.getxPos() <= 0 || Main.sreen.getxPos() > 5200){
			if(this.turnRight == true){string = "/images/" + name + "TurnRight1.png";}
			else{string = "/images/" + name + "TurnLeft1.png";}
		}else{
			this.counterSteps++;
			if(this.counterSteps / frequence == 0){
				if(this.turnRight == true){string = "/images/" + name + "TurnRight1.png";}
				else{string = "/images/" + name + "TurnLeft1.png";}
			}else{
				if(this.turnRight == true){string = "/images/" + name + "TurnRight2.png";}
				else{string = "/images/" + name + "TurnLeft2.png";}
			}
			if(this.counterSteps == 2 * frequence){this.counterSteps = 0;}
		}
		
		icon = new ImageIcon(getClass().getResource(string));
		image = icon.getImage();
		return image;
	}

	

    public Image jump(){
		
	    ImageIcon icon;
	    Image image;
	    String string;
	
		this.counterJump++;	
		if(this.counterJump <= 40){
			if(this.getY() > Main.sreen.getHeightOfWindow()){this.setY(this.getY() - 4);}
			else{this.counterJump = 41;}			
			if(this.isTurnRight() == true){string = "/images/marioJumpRight.png";}
			else{string = "/images/marioJumpLeft.png";}	
			
		
		}else if(this.getY() + this.getHeight() < Main.sreen.getySol()){this.setY(this.getY() + 1);
			if(this.isTurnRight() == true){string = "/images/marioJumpRight.png";}
			else{string = "/images/marioJumpLeft.png";}
			
	
		}else{				
			if(this.isTurnRight() == true){string = "/images/marioTurnRight1.png";}
			else{string = "/images/marioTurnLeft1.png";}	
			this.jump = false;
			this.counterJump = 0;
		}
		icon = new ImageIcon(getClass().getResource(string));
		image = icon.getImage();
		return image;
	}
    
	public void contact(Object object) {
		// contact horizontal window of the game 
		if((super.contactRight(object) == true && this.isTurnRight() == true) || (super.contactLeft(object) == true && this.isTurnRight() == false)){
			Main.sreen.setDx(0);
		    this.setWalking(false);
		}
		// contact with object under the mario
        if(super.contactUnder(object) == true && this.jump == true){ // when the mario jump over the object
			Main.sreen.setySol(object.getY());			
		}else if(super.contactUnder(object) == false){ // fall into the ground
			Main.sreen.setySol(293); //initial height of the ground
			if(this.jump == false){this.setY(243);} // initial position of the mario 
		}
        // contact with the object overhead of the mario
        if(super.contactOver(object) == true){
			Main.sreen.setHeightOfWindow(object.getY() + object.getHeight()); //
		}else if(super.contactOver(object) == false && this.jump == false){
			Main.sreen.setHeightOfWindow(0);// 
		}     
	}
	public boolean contactCoin(Coin coin){
		if(this.contactRight(coin) == true || this.contactLeft(coin) == true || this.contactOver(coin) == true || this.contactUnder(coin) == true){
			return true;
		}
		else {return false;}
	}

	public void contact(Character character) {		
		if((super.contactRight(character) == true) || (super.contactLeft(character) == true)){
			this.setWalking(false);
		    this.setAlive(false);
		}else if(super.contactUnder(character) == true){
			character.setWalking(false);
			character.setAlive(false);
		}
    }			
	
	
	public Image death(){		
		ImageIcon icon;
	    Image image;
	    String string;	
		
        string = "/images/boom.png";
        if(this.counterDead == 0){Audio.playSound("/sound/boom.wav");}
        this.counterDead++;       
        if(this.counterDead > 100){
        	string = "/images/marioDie.png";
        	this.setY(this.getY() - 1);
        }
		icon = new ImageIcon(getClass().getResource(string));
		image = icon.getImage();
		return image;
	} 
}
