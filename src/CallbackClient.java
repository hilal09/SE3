import java.util.Random;
// import java.util.concurrent.TimeUnit;
// import java.util.random.*;

public class CallbackClient extends Thread {
    
    boolean stop = false;
    
    // TageAusrechnen bday = new TageAusrechnen();

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
        
        // CallbackCaller caller = new CallbackCaller(this); // delegiert asynchronen Aufruf
        new CallbackCaller(this); // delegiert asynchronen Aufruf
        Random rand = new Random();
        
        int zahl = 0;
        //Zählerausgabe
        System.out.print(zahl); 
        while (!stop){
            try {
                Thread.sleep((rand.nextInt(3) + 1) * 1000);
            } catch (InterruptedException e) {
                //wie kommt man in diesen block? wenn stop, dann interrupt 
                //(falls gerade der main thread sleep ist) damit zaehlerausgabe stoppt. 
                //(in diesem fall ohne wiederholte if abfrage fuer stop)
                System.out.println("Zaehlerausgabe beendet.");
                // e.printStackTrace();
            }
            if (!stop) {
                System.out.println(", ");
                System.out.print(++zahl); 
            } else break;

            // System.out.println(", ");
            // System.out.print(++zahl); 
        }
        // System.out.println();
        // System.out.println("Zaehlerausgabe beendet.");
    }

    public void callback(int result) {
        stop = true;
        System.out.println();
        System.out.println("Es verbleiben " + result + " Tage bis zu deinem Geburtstag.");
        // Thread.currentThread().interrupt();
        // System.exit(0);
    }

    public static void main(String[] args) { 
        new CallbackClient(); 
    }
}