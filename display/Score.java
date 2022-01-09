package display;

public class Score {
    
	 // VARIABLES
	private final int NUM_TOTAL_COINS = 10;
	private int numCoins;
		
	// CONSTRUCTER
	public Score(){
		this.numCoins = 0;
	}

			
	// GETTERS
	public int getNumCoins() {return numCoins;}

	public int getNUM_TOTAL_COINS() {return NUM_TOTAL_COINS;}

			
	// SETTERS
	public void setNumCoins(int numCoins) {this.numCoins = numCoins;}
}
    

