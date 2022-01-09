package frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import audio.Audio;

public class KeyBoard implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		if(Main.screen.mario.isAlive() == true){
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){ 
		   
        		if(Main.screen.getxPos() == -1){ 
        			Main.screen.setxPos(0);     
        			Main.screen.setxBackGround1(-50); 
        			Main.screen.setxBackGround2(750); 
        		}
        		Main.screen.mario.setWalking(true);
        		Main.screen.mario.setTurnRight(true);
				Main.screen.setDx(1);  
			
			}else if(e.getKeyCode() == KeyEvent.VK_LEFT){

			if(Main.screen.getxPos() == 5201){
				Main.screen.setxPos(5200);
				Main.screen.setxBackGround1(-50);
				Main.screen.setxBackGround2(750);
			}

			Main.screen.mario.setWalking(true);
        	Main.screen.mario.setTurnRight(false);
			Main.screen.setDx(-1); 
			}
		
        if(e.getKeyCode() == KeyEvent.VK_SPACE){      	
        	Main.screen.mario.setJump(true);   
			Audio.playSound("/sound/jump.wav");   		
        }
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.screen.mario.setWalking(false);
		Main.screen.setDx(0);
		}                   
	                                                           
	@Override
	public void keyTyped(KeyEvent e) {}

}
