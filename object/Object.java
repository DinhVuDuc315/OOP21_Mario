package object;
import javax.swing.ImageIcon;
import frame.Main;
import java.awt.Image;
public class Object {
	private int width, height; 
	private int x, y; 

	protected Image imgObject;
	protected ImageIcon iconObject;
	
	//**** CONSTRUCTEUR ****//	
	public Object(int x, int y, int width, int height){
			
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	 //**** GETTERS ****//	
 
	public Image getImgObject() {
		return imgObject;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	//**** METHODES ****//	
	public void displacement(){
		if(Main.Screen.getxPos() >= 0){
			this.x = this.x - Main.Screen.getDx();
		}
	}
