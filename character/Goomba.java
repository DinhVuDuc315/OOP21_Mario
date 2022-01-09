package character;

import javax.swing.ImageIcon;
import java.awt.Image;
import object.Object;
public class Goomba extends Character implements Runnable{
    //**** VARIABLE *****//
    private final int PAUSE = 15;
    private int dxGoomba;
    private Image imgGoomba;
    private ImageIcon iconGoomba;
    
    //**** CONSTRUCTER ****//
    public Goomba(int x, int y) {
        super(x, y, 27, 30);
        super.setTurnRight(true);
        super.setWalking(true);
        this.dxGoomba = 1;
        
        this.iconGoomba = new ImageIcon(getClass().getResource("/images/goombaTurnRight1.png"));
        this.imgGoomba = this.iconGoomba.getImage();

        Thread movingGoomba = new Thread(this);
        movingGoomba.start();
    }
    
    //**** GETTER ****//
     public Image getImgGoomba() {
        return imgGoomba;
    }

    //**** METHODS ****//   
    public void move(){ 

    		if(super.isTurnRight() == true){this.dxGoomba = 1;}
    		else{this.dxGoomba = -1;}
        	super.setX(super.getX() + this.dxGoomba);
    		
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

    public void contact(Object object) {			
		if(super.contactRight(object) == true && this.isTurnRight() == true){					
            super.setTurnRight(false);
	    	this.dxGoomba = -1; 
	    }else if(super.contactLeft(object) == true && this.isTurnRight() == false){
	    	super.setTurnRight(true);
	    	this.dxGoomba = 1;     
	    }	
	}

    public void contact(Character character) {			
		if(super.contactRight(character) == true && this.isTurnRight() == true){					
            super.setTurnRight(false);
	    	this.dxGoomba = -1; 
	    }else if(super.contactLeft(character) == true && this.isTurnRight() == false){
	    	super.setTurnRight(true);
	    	this.dxGoomba = 1;     
	    }	
	}

    public Image fainted(){		
		String str;	
		ImageIcon iconCrushed;
		Image imageCrushed;
		
		
        if(this.isTurnRight() == true){str = "/images/goombaCrushedRight.png";}
        else{str = "/images/goombaCrushedLeft.png";}	
        this.dxGoomba = 0;	
        iconCrushed = new ImageIcon(getClass().getResource(str));
        imageCrushed = iconCrushed.getImage();
		return imageCrushed;
	}

    public boolean isVivant() {
        return false;
    }
}