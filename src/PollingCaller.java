
import java.io.IOException;

public class PollingCaller extends Thread {
    private boolean returned = false;

    public PollingCaller () { 
        this.start();  
    }

    public void run() {
        System.out.println(" entfernter Aufruf läuft u. wartet auf Taste ");
    try {
        System.in.read();
    } catch (IOException e) { e.printStackTrace(); }
        returned = true;
    }
    
    public boolean returned() { 
        return returned; 
    }

}