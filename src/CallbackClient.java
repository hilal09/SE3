import java.util.Random;

public class CallbackClient extends Thread {
    
    boolean stop = false;
    
    public CallbackClient() {
        
        new CallbackCaller(this); // delegiert asynchronen Aufruf
        Random rand = new Random();
        
        int zahl = 0;
        //Zaehlerausgabe
        System.out.print(zahl); 
        while (!stop) {
            System.out.println(", ");
            System.out.print(++zahl); 
            try {
                Thread.sleep((rand.nextInt(3) + 1) * 1000);
            } catch (InterruptedException e) {
                //wie kommt man in diesen block? wenn stop, dann interrupt 
                //(falls gerade der main thread sleep ist) damit zaehlerausgabe stoppt. 
                //(in diesem fall ohne wiederholte if abfrage fuer stop)
                System.out.println("Zaehlerausgabe beendet.");
                // e.printStackTrace();
            }
            // if (!stop) {
            //     System.out.println(", ");
            //     System.out.print(++zahl); 
            // } else break;

        }
        System.out.println("Zaehlerausgabe beendet.");
    }

    public void callback(int result) {
        stop = true;
        System.out.println();
        System.out.println("Es verbleiben " + result + " Tage bis zu deinem Geburtstag.");
    }

    public static void main(String[] args) { 
        new CallbackClient(); 
    }

}