package object;

import javax.swing.ImageIcon;

public class RedPipe extends Object{
	//**** VARIABLES ****//
		
		
		
		//**** CONSTRUCTEUR	****//	
		public RedPipe(int x, int y) {

			super(x, y, 43, 65);		
			super.iconObject = new ImageIcon(getClass().getResource("/images/RedPipe.png"));
			super.imgObject = this.iconObject.getImage();
		}
		
		
		//**** GETTERS ****//		
	
			
			
		//**** SETTERS ****//
			

		//**** METHODES ****//
}
