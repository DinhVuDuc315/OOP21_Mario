package character;

import java.awt.Image;
import javax.swing.ImageIcon;
import frame.Main;
import object.Object;

public class Character {
	private int width; // width of image's character
	private int height; // height of image's character
	protected int x; //position of image's character	
	private int y;
	protected boolean walking; // variable checking walking of character
	protected boolean turnRight; // turn right checking variable of character
	public int counterSteps; 
	protected boolean alive; 
	

	//**** CONSTRUCTEUR ****//
	public Character(int x, int y, int width, int height){
				
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;		
		this.counterSteps = 0;
		this.walking = false;
		this.turnRight = true;		
		this.alive = true;
	}
	

	//**** GETTERS ****//		
	public int getX() {return x;}

	public int getY() {return y;}

    public int getWidth() {return width;}
	
	public int getHeight() {return height;}

	public boolean isWalking() {return walking;}

	public boolean isTurnRight() {return turnRight;}

	public int getCounterSteps() {return counterSteps;}
	
	public boolean isAlive() {return alive;}


	


	//**** SETTERS ****//	
	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}
	
	public void setWalking(boolean walking) {this.walking = walking;}
	
	public void setTurnRight(boolean turnRight) {this.turnRight = turnRight;}

	public void setCounterSteps(int counterSteps) {this.counterSteps = counterSteps;}
	
	public void setAlive(boolean alive) {this.alive = alive;}



	 //**** METHODES ****//
	public Image walking(String name, int frequence){
		
		String string;
		ImageIcon icon;
		Image image;
		
		if(this.walking == false ){
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
    
	public void displacement(){		
		if(Main.sreen.getxPos() >= 0){this.x = this.x - Main.sreen.getDx();}
	}
	
    // collision of right hand side of the mario
    protected boolean contactRight(Object object){
	    if(this.x + this.width < object.getX() || this.x + this.width > object.getX() + 5 ||
	       this.y + this.height <= object.getY() || this.y >= object.getY() + object.getHeight()){return false;}
		else{return true;}
	} 
    
    // collision of the left hand side of the mario
    protected boolean contactLeft(Object object){		
		if(this.x > object.getX() + object.getWidth() || this.x + this.width < object.getX() + object.getWidth() - 5 || 
		   this.y + this.height <= object.getY() || this.y >= object.getY() + object.getHeight()){return false;}
		else{return true;}
	}

    // collsion of the under side of the mario
    protected boolean contactUnder(Object object){		
		if(this.x + this.width < object.getX() + 5 || this.x > object.getX() + object.getWidth() - 5 || 
		   this.y + this.height < object.getY() || this.y + this.height > object.getY() + 5){return false;}
		else{return true;}		
	}

    // collision of the overhead side of the mario
    protected boolean contactOver(Object object){
		if(this.x + this.width < object.getX() + 5 || this.x > object.getX() + object.getWidth() - 5 || 
		   this.y < object.getY() + object.getHeight() || this.y > object.getY() + object.getHeight() + 5){return false;}
		else{return true;}
	}   


    public boolean closeContact(Object object){  	
    	if((this.x > object.getX() - 10 && this.x < object.getX() + object.getWidth() + 10) 
    	|| (this.x + this.width > object.getX() - 10 && this.x + this.width < object.getX() + object.getWidth() + 10)){return true;}
    	else{return false;}
    }

	protected boolean contactRight(Character character){
		if(this.isTurnRight() == true){
			if(this.x + this.width < character.getX() || this.x + this.width > character.getX() + 5 || 
			this.y + this.height <=character.getY() || this.y >= character.getY() + character.getHeight()){return false;}
			else{return true;}
		}else{return false;}
	} 
    
	
    protected boolean contactLeft(Character character){		
		if(this.x >character.getX() + character.getWidth() || this.x + this.width < character.getX() +character.getWidth() - 5 ||
		 this.y + this.height <= character.getY() || this.y >= character.getY() + character.getHeight()){return false;}
		else{return true;}
	}

	protected boolean contactUnder(Character character){
    	if(this.x + this.width < character.getX() || this.x > character.getX() +character.getWidth() || 
    	   this.y + this.height < character.getY() || this.y + this.height >character.getY()){return false;}
		else{return true;}
	}
    
    public boolean closeContact(Character character){  	
    	if((this.x > character.getX() - 10 && this.x < character.getX() + character.getWidth() + 10) 
    	|| (this.x + this.width > character.getX() - 10 && this.x + this.width < character.getX() + character.getWidth() + 10)){
			return true;}
    	else{return false;}
    }

}


