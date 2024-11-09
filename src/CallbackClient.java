import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.random.*;
public class CallbackClient {
    
    boolean stop = false;
    int zahl = 0;
    TageAusrechnen bday = new TageAusrechnen();

    // public CallbackClient() {
        
    //     CallbackCaller caller = new CallbackCaller(this); // delegiert asynchronen Aufruf

    //     while (!stop){
    //         System.out.print((zahl++) + ", "); //Zählerausgabe //sunny (zaunpfahl)
    //         try {
    //             Thread.sleep(1000);
    //         } catch (InterruptedException e) { 
    //             e.printStackTrace();
    //         }
    //     }
    // }

    // public void callback() {
    //     stop = true;
    //     try {
    //         Thread.sleep(1500);
    //     } catch (InterruptedException e) { 
    //         e.printStackTrace();
    //     }
    //     System.out.println(bday.tageausrechnen());
    // }
    
    //sunny:

    public CallbackClient() {
        
        CallbackCaller caller = new CallbackCaller(this); // delegiert asynchronen Aufruf
        Random rand = new Random();

        //Zählerausgabe
        System.out.print(zahl); 
        while (!stop){
            try {
                Thread.sleep((rand.nextInt(3) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(", ");
            System.out.print(++zahl); 
        }
        System.out.println();
    }

    public void callback(int result) {
        stop = true;
        System.out.println();
        System.out.println("Es verbleiben " + result + " Tage bis zu deinem Geburtstag.");
        System.exit(0);
    }

    public static void main(String[] args) { 
        new CallbackClient(); 
    }
}