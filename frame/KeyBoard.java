package frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import audio.Audio;

public class KeyBoard implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		if(Main.sreen.mario.isAlive() == true){
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){ 
		   
        		if(Main.sreen.getxPos() == -1){ 
        			Main.sreen.setxPos(0);     
        			Main.sreen.setxBackGround1(-50); 
        			Main.sreen.setxBackGround2(750); 
        		}
        		Main.sreen.mario.setWalking(true);
        		Main.sreen.mario.setTurnRight(true);
				Main.sreen.setDx(1);  
			
			}else if(e.getKeyCode() == KeyEvent.VK_LEFT){

			if(Main.sreen.getxPos() == 5201){
				Main.sreen.setxPos(5200);
				Main.sreen.setxBackGround1(-50);
				Main.sreen.setxBackGround2(750);
			}

			Main.sreen.mario.setWalking(true);
        	Main.sreen.mario.setTurnRight(false);
			Main.sreen.setDx(-1); 
			}
		
        if(e.getKeyCode() == KeyEvent.VK_SPACE){      	
        	Main.sreen.mario.setJump(true);   
			Audio.playSound("/sound/jump.wav");   		
        }
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.sreen.mario.setWalking(false);
		Main.sreen.setDx(0);
		}                   
	                                                           
	@Override
	public void keyTyped(KeyEvent e) {}

}
