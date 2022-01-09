package character;

import javax.swing.ImageIcon;
import java.awt.Image;
import object.Object;

public class Turtle extends Character implements Runnable{
    private Image imgTurtle;
    private ImageIcon iconTurtle;
    private final int PAUSE = 15;
    private int dxTurtle;

    //**** CONSTRUCTER ****//
    public Turtle(int x, int y) {
        super(x, y, 43, 50);
        super.setTurnRight(true);
        super.setWalking(true);
        this.dxTurtle = 1;
        
        this.iconTurtle = new ImageIcon(getClass().getResource("/images/turtleTurnRight1.png"));
        this.imgTurtle = this.iconTurtle.getImage();

        Thread movingTurtle = new Thread(this);
        movingTurtle.start();
    }

     //**** GETTER ****//
     public Image getImgTurtle() {
        return imgTurtle;
    }

    //**** METHODS ****//   
    public void move(){ 

    		if(super.isTurnRight() == true){this.dxTurtle = 1;}
    		else{this.dxTurtle = -1;}
        	super.setX(super.getX() + this.dxTurtle);
    		
    }

    public void contact(Object object) {			
		if(super.contactRight(object) == true && this.isTurnRight() == true){					
            super.setTurnRight(false);
	    	this.dxTurtle = -1; 
	    }else if(super.contactLeft(object) == true && this.isTurnRight() == false){
	    	super.setTurnRight(true);
	    	this.dxTurtle = 1;     
	    }	
	}

    public void contact(Character character) {			
		if(super.contactRight(character) == true && this.isTurnRight() == true){					
            super.setTurnRight(false);
	    	this.dxTurtle = -1; 
	    }else if(super.contactLeft(character) == true && this.isTurnRight() == false){
	    	super.setTurnRight(true);
	    	this.dxTurtle = 1;     
	    }	
	}

    public Image fainted(){		
		String str;	
		ImageIcon iconCrushed;
		Image imageCrushed;
		
		str = "/images/turtleShell.png";
        iconCrushed = new ImageIcon(getClass().getResource(str));
        imageCrushed = iconCrushed.getImage();
		return imageCrushed;
	}

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try{Thread.sleep(20);} 
		catch (InterruptedException e){}				
		while(true){ 	
            if(this.alive == true){								
		    this.move();
		    try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
            }
		}		
    }
}
