package frame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import audio.Audio;
import character.Goomba;
import character.Mario;
import character.Turtle;
import display.Score;
import display.TimeCountdown;
import object.Block;
import object.Coin;
import object.Object;
import object.RedPipe;


@SuppressWarnings("serial")
public class Screen extends JPanel{
	private ImageIcon icoBackGround;
	private Image imgBackGound1;//background 1
	private Image imgBackGound2;// background 2
	
	private ImageIcon iconCastle1;  
	private Image imgCastle1;  
	private ImageIcon iconPanel;  
	private Image imgPanel;

	private ImageIcon iconFortress;  
	private Image imgFortress;
	private ImageIcon iconflag;  
	private Image imgflag;
	
	private int xBackGround1;
	private int xBackGround2;
	private int dx;   // moving the background
	private int xPos; // position along to x-axist
	private int ySol; // position along to y-axist
	private int heightOfWindow; // the heigh of windown of the game 
	
	//Mario
	public Mario mario;

	//Goomba
	public Goomba goomba1;
	public Goomba goomba2;
	public Goomba goomba3;
	public Goomba goomba4;
	public Goomba goomba5;
	public Goomba goomba6;
	public Goomba goomba7;
	public Goomba goomba8;
	

	//Turtle
	public Turtle turtle1;
	public Turtle turtle2;
	public Turtle turtle3;
	public Turtle turtle4;
	public Turtle turtle5;
	public Turtle turtle6;
	public Turtle turtle7;
	public Turtle turtle8;
	

	//Redpipe
	public RedPipe redPipe1;
	public RedPipe redPipe2;
	public RedPipe redPipe3;
	public RedPipe redPipe4;
	public RedPipe redPipe5;
	public RedPipe redPipe6;
	public RedPipe redPipe7;
	public RedPipe redPipe8;
	public RedPipe redPipe9;
	public RedPipe redPipe10;
	/*public RedPipe redPipe11;
	public RedPipe redPipe12;
	public RedPipe redPipe13;
	public RedPipe redPipe14;
	public RedPipe redPipe15;
	public RedPipe redPipe16;
	public RedPipe redPipe17;
	public RedPipe redPipe18;
	public RedPipe redPipe19;
	public RedPipe redPipe20;*/
	
	//Block
	public Block block1;
	public Block block2;
	public Block block3;
	public Block block4;
	public Block block5;
	public Block block6;
	public Block block7;
	public Block block8;
	public Block block9;
	public Block block10;
	public Block block11;
	public Block block12;
	public Block block13;
	public Block block14;
	public Block block15;
	
	//Coin
	public Coin coin1;
	public Coin coin2;
	public Coin coin3;
	public Coin coin4;
	public Coin coin5;
	public Coin coin6;
	public Coin coin7;
	public Coin coin8;
	public Coin coin9;
	public Coin coin10;
	public Coin coin11;
	public Coin coin12;
	public Coin coin13;
	public Coin coin14;
	public Coin coin15;

	
	
	private ArrayList <Object> tabObjects; // array which records all the objects of the game
	private ArrayList <Coin> tabCoin; //array which records all coin
	private ArrayList<Goomba> tabGoomba;
	private ArrayList<Turtle> tabTurtle;

	private Score score;
	private Font police;
	private TimeCountdown timeCountdown;



	//**** CONSTRUCTEUR ****//	
	public Screen(){
		
		super();
		
		this.xBackGround1 = -50;
		this.xBackGround2 = 750;
		this.dx = 0;
		this.xPos = -1;
		this.ySol = 293;
		this.heightOfWindow = 0;
		//icon background
		icoBackGround = new ImageIcon(getClass().getResource("/images/BackGround.png"));
		this.imgBackGound1 = this.icoBackGround.getImage();
		this.imgBackGound2 = this.icoBackGround.getImage();
		//icon Castle
		this.iconCastle1 = new ImageIcon(getClass().getResource("/images/Castle1.png")); 
		this.imgCastle1 = this.iconCastle1.getImage();  
		//icon Panel
		this.iconPanel = new ImageIcon(getClass().getResource("/images/Panel.png"));
		this.imgPanel = this.iconPanel.getImage();
		//icon Fortress
		this.iconFortress = new ImageIcon(getClass().getResource("/images/Fortress.png")); 
		this.imgFortress = this.iconFortress.getImage(); 
		//icon flag
		this.iconflag = new ImageIcon(getClass().getResource("/images/flag.png")); 
		this.imgflag = this.iconflag.getImage();
		//Mario
		mario = new Mario(300, 245);

		//create new redpipe
		redPipe1 = new RedPipe(600, 230);
		redPipe2 = new RedPipe(800, 230);
		redPipe3 = new RedPipe(1000, 230);
		redPipe4 = new RedPipe(1300, 230);
		redPipe5 = new RedPipe(1900, 230);
		redPipe6 = new RedPipe(2400, 230);
		redPipe7 = new RedPipe(2900, 230);
		redPipe8 = new RedPipe(3500, 230);
		redPipe9 = new RedPipe(3800, 230);
		redPipe10 = new RedPipe(4500, 230);
	/*	redPipe11 = new RedPipe(5200, 230);
		redPipe12 = new RedPipe(5500, 230);
		redPipe13 = new RedPipe(6100, 230);
		redPipe14 = new RedPipe(6400, 230);
		redPipe15 = new RedPipe(7000, 230);
		redPipe16 = new RedPipe(7500, 230);
		redPipe17 = new RedPipe(8000, 230);
		redPipe18 = new RedPipe(8400, 230);
		redPipe19 = new RedPipe(9000, 230);
		redPipe20 = new RedPipe(9600, 230);*/

		//create new block
		block1 = new Block(400, 180);
		block2 = new Block(1200, 180);
		block3 = new Block(1700, 180);
		block4 = new Block(2000, 210);
		block5 = new Block(2100, 210);
		block6 = new Block(2500, 160);
		block7 = new Block(2600, 170);
		block8 = new Block(2700, 180);
		block9 = new Block(2800, 190);
		block10 = new Block(3200, 180);
		block11 = new Block(3400, 180);
		block12 = new Block(3700, 180);
		block13 = new Block(3900, 180);
		block14 = new Block(4000, 180);
		block15 = new Block(4200, 180);

		coin1 = new Coin(402, 145);
		coin2 = new Coin(502, 145);
		coin3 = new Coin(532, 155);
		coin4 = new Coin(600, 90);
		coin5 = new Coin(750, 145);
		coin6 = new Coin(1000, 200);
		coin7 = new Coin(1250, 200);
		coin8 = new Coin(1350, 145);
		coin9 = new Coin(1650, 145);
		coin10 = new Coin(2650, 90);
		coin11 = new Coin(3050, 145);
		coin12 = new Coin(3450, 200);
		coin13 = new Coin(4250, 145);
		coin14 = new Coin(4650, 200);
		coin15 = new Coin(4850, 200);

		//Goomba
		goomba1 = new Goomba(720, 263);
		goomba2 = new Goomba(960, 263);
		goomba3 = new Goomba(1220, 263);
		goomba4 = new Goomba(2220, 263);
		goomba5 = new Goomba(2960, 263);
		goomba6 = new Goomba(3600, 263);
		goomba7 = new Goomba(3960, 263);
		goomba8 = new Goomba(4290, 263);


		//turtle
		turtle1 = new Turtle(920, 245);
		turtle2 = new Turtle(1520, 245);
		turtle3 = new Turtle(2590, 245);
		turtle4 = new Turtle(3240, 245);
		turtle5 = new Turtle(3560, 245);
		turtle6 = new Turtle(4360, 245);
		turtle7 = new Turtle(4560, 245);
		turtle8 = new Turtle(4730, 245);
		
		//Object
		tabObjects = new ArrayList<Object>();
		this.tabObjects.add(this.redPipe1);
		this.tabObjects.add(this.redPipe2);
		this.tabObjects.add(this.redPipe3);
		this.tabObjects.add(this.redPipe4);
		this.tabObjects.add(this.redPipe5);
		this.tabObjects.add(this.redPipe6);
		this.tabObjects.add(this.redPipe7);
		this.tabObjects.add(this.redPipe8);
		this.tabObjects.add(this.redPipe9);
		this.tabObjects.add(this.redPipe10);
		/*this.tabObjects.add(this.redPipe11);
		this.tabObjects.add(this.redPipe12);
		this.tabObjects.add(this.redPipe13);
		this.tabObjects.add(this.redPipe14);
		this.tabObjects.add(this.redPipe15);*/

		this.tabObjects.add(this.block1);
		this.tabObjects.add(this.block2);
		this.tabObjects.add(this.block3);
		this.tabObjects.add(this.block4);
		this.tabObjects.add(this.block5);
		this.tabObjects.add(this.block6);
		this.tabObjects.add(this.block7);
		this.tabObjects.add(this.block8);
		this.tabObjects.add(this.block9);
		this.tabObjects.add(this.block10);
		this.tabObjects.add(this.block11);
		this.tabObjects.add(this.block12);
		this.tabObjects.add(this.block13);
		this.tabObjects.add(this.block14);
		this.tabObjects.add(this.block15);
		
		//Coin
		tabCoin = new ArrayList<Coin>();
		this.tabCoin.add(this.coin1);
		this.tabCoin.add(this.coin2);
		this.tabCoin.add(this.coin3);
		this.tabCoin.add(this.coin4);
		this.tabCoin.add(this.coin5);
		this.tabCoin.add(this.coin6);
		this.tabCoin.add(this.coin7);
		this.tabCoin.add(this.coin8);
		this.tabCoin.add(this.coin9);
		this.tabCoin.add(this.coin10);
		this.tabCoin.add(this.coin11);
		this.tabCoin.add(this.coin12);
		this.tabCoin.add(this.coin13);
		this.tabCoin.add(this.coin14);
		this.tabCoin.add(this.coin15);

		//Goomba
		tabGoomba = new ArrayList<Goomba>();
		this.tabGoomba.add(this.goomba1);
		this.tabGoomba.add(this.goomba2);
		this.tabGoomba.add(this.goomba3);
		this.tabGoomba.add(this.goomba4);
		this.tabGoomba.add(this.goomba5);
		this.tabGoomba.add(this.goomba6);
		this.tabGoomba.add(this.goomba7);
		this.tabGoomba.add(this.goomba8);
		

		//Turtle 
		tabTurtle = new ArrayList<Turtle>();
		this.tabTurtle.add(this.turtle1);
		this.tabTurtle.add(this.turtle2);
		this.tabTurtle.add(this.turtle3);
		this.tabTurtle.add(this.turtle4);
		this.tabTurtle.add(this.turtle5);
		this.tabTurtle.add(this.turtle6);
		this.tabTurtle.add(this.turtle7);
		this.tabTurtle.add(this.turtle8);


		//
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new KeyBoard());
		
		score = new Score();
		police = new Font("Arial", Font.PLAIN, 18);
		timeCountdown = new TimeCountdown();


		Thread moving = new Thread(new Moving());
		moving.start();
	}
	
	
	//**** GETTERS ****//	
	public int getDx() {return dx;}
	
	public int getxPos() {return xPos;}

	public int getySol() {return ySol;}

	public int getHeightOfWindow(){return heightOfWindow;}


	//**** SETTERS ****//
	public void setDx(int dx) {this.dx = dx;}
	
	public void setxPos(int xPos) {this.xPos = xPos;}

	public void setySol(int ySol) {this.ySol = ySol;}

	public void setHeightOfWindow(int heightOfWindow) {this.heightOfWindow = heightOfWindow;}

	public void setxBackGround1(int xFond1) {this.xBackGround1 = xFond1;}

	public void setxBackGround2(int xFond2) {this.xBackGround2 = xFond2;}


	//**** METHODES ****//
	public void displacementFond(){ // display the background along to posotion of mario 
		
		if(this.xPos >= 0 && this.xPos <= 5200){
			this.xPos = this.xPos + this.dx;		
		    this.xBackGround1 = this.xBackGround1 - this.dx;
		    this.xBackGround2 = this.xBackGround2 - this.dx;
		}
		// make the background move infinity
		if(this.xBackGround1 == -800){this.xBackGround1 = 800;}
		else if(this.xBackGround2 == -800){this.xBackGround2 = 800;}
		else if(this.xBackGround1 == 800){this.xBackGround1 = -800;}
		else if(this.xBackGround2 == 800){this.xBackGround2 = -800;}
	}
	
	private boolean gameWon(){		
		if(this.timeCountdown.getconsumeTime() > 0 && this.mario.isAlive() == true && this.score.getNumCoins() == 10 
			&& this.xPos > 4400){
			return true;
		}else{return false;}
	}
	
	private boolean gameLose(){
		if(this.mario.isAlive() == false || this.timeCountdown.getconsumeTime() <= 0){
			return true;
		}else{return false;}
	}
		
	public boolean GameOver(){
		if(this.gameWon() == true || this.gameLose() == true){return true;}
		else{return false;}
	}
