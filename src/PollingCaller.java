import java.time.LocalDate;
import java.util.Random;

public class PollingCaller extends Thread {

    private boolean returned = false;
    private int daysUntilNextBday = 0;

    public PollingCaller() { 
        this.start();  
    }

    // Tage bis zum naechsten Geburtstag zaehlen
    @Override
    public void run() {

        LocalDate currentDate = LocalDate.now();
        // kommender Geburtstag (hard coded)
        LocalDate bday = LocalDate.of(2024, 12, 29);

        while (!currentDate.equals(bday)) { 
            daysUntilNextBday++;
            currentDate = currentDate.plusDays(1);   
        }

        // warten
        Random rand = new Random();
        // random.nextInt(max - min + 1) + min : zufaellige Zahl zwischen Null und angegebene Zahl-1        
        int randomNum = rand.nextInt(7) + 4; //zufaellige zahl zwischen 4-10
        try {
            sleep(randomNum * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        returned = true;
    }
    
    /** 
     * wird von PollingClient aufgerufen um zu pruefen, ob die Aufgabe beendet ist
     */
    public boolean returned() { 
        return returned; 
    }

    public int getDaysUntilNextBday() {
        return daysUntilNextBday;
    }
}