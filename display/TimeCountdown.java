package display;

public class TimeCountdown implements Runnable {

    
	// VARIABLES
	private final int PAUSE = 1000;	
	private int consumeTime;
	private String str;
	
	
	// CONSTRUCTEUR
	public TimeCountdown(){

		this.consumeTime = 100; 
		this.str = "Time remaining : 100";
		
		Thread timecountdown = new Thread(this);
		timecountdown.start();
	}

	
	// GETTERS	
	public int getconsumeTime() {return consumeTime;}
	
    public String getStr() {return str;}

	
    // SETTERS
    
    
	// METHODES	
	@Override
	public void run() {		
		
		while(true){ 										
		    try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
			this.consumeTime--;
			this.str = "Time remaining : " + this.consumeTime;
		}		
	} 

    
}
