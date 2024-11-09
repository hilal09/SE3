import java.io.IOException;
import java.time.LocalDate; //sunny
import java.util.Random;
import java.util.random.*; //sunny


public class CallbackCaller extends Thread { // führt asynchronen Aufruf aus
    
    CallbackClient client;
    
    public CallbackCaller (CallbackClient c) { 
        client = c; 
        this.start(); 
    }
    
    // public void run() { // Hier könnte ein entfernter Aufruf stehen
    //     System.out.println(" entfernter Aufruf läuft u. wartet auf return ");
    //     try {
    //         System.in.read();
    //     } catch (IOException e) { 
    //         e.printStackTrace(); 
    //     }
    //     client.callback();
    // }

    //sunny (code von tage ausrechnen + aenderungen):
    public void run() {
        LocalDate currentDate = LocalDate.now();
        //geburtstag hard coded
        LocalDate bday = LocalDate.of(2024, 12, 29);
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        client.callback(daysUntilNextBday);
    
    }

}