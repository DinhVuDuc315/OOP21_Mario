package object;
import javax.swing.ImageIcon;

public class Block extends Object{

	//**** CONSTRUCTEUR	****//	
	public Block(int x, int y) {
		super(x, y, 30, 30);		
		super.iconObject = new ImageIcon(getClass().getResource("/images/block.png"));
		super.imgObject = this.iconObject.getImage();
	}
	
	
	//**** GETTERS ****//		

		
		
	//**** SETTERS ****//
		

	//**** METHODES ****//
}
