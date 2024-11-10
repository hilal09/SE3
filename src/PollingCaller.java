
// import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class PollingCaller extends Thread {

    private boolean returned = false;
    private int daysUntilNextBday = 0;

    public PollingCaller() { 
        this.start();  
    }

    //geburtstag berechnen
    public void run() {

        LocalDate currentDate = LocalDate.now();
        //kommender geburtstag hard coded
        LocalDate bday = LocalDate.of(2024, 12, 29);

        while (!currentDate.equals(bday)) { 
            daysUntilNextBday++;
            currentDate = currentDate.plusDays(1);   
        }

        //warten
        Random rand = new Random();
        // random.nextInt(max - min + 1) + min : zufaellige zahl zwischen null und angegebene zahl-1
        int randomNum = rand.nextInt(7) + 4; //zufaellige zahl zwischen 4-10
        try {
            sleep(randomNum * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // System.out.println(" entfernter Aufruf läuft u. wartet auf Taste ");
        // try {
        //     System.in.read();
        // } catch (IOException e) { 
        //     e.printStackTrace(); 
        // }
        returned = true;
    }
    
    public boolean returned() { 
        return returned; 
    }

    public int getDaysUntilNextBday() {
        return daysUntilNextBday;
    }

}