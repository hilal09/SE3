import java.time.LocalDate;
import java.util.Random;

public class CallbackCaller extends Thread { // fuehrt asynchronen Aufruf aus
    
    CallbackClient client;
    
    public CallbackCaller(CallbackClient c) { 
        client = c; 
        this.start(); 
    }
    
    /** tage zaehlen und client.callback() methode aufrufen */
    public void run() {
        LocalDate currentDate = LocalDate.now();
        //kommender geburtstag hard coded
        LocalDate bday = LocalDate.of(2025, 07, 06);
        int daysUntilNextBday = 0;

        while (!currentDate.equals(bday)) { 
            daysUntilNextBday += 1;
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
        client.callback(daysUntilNextBday);
    
    }

}