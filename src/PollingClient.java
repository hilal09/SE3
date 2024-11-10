import java.util.Random;

public class PollingClient {
    public static void main(String[] args) {

        PollingCaller caller = new PollingCaller();
        Random rand = new Random();
        
        //Zaehlerausgabe
        int zahl = 0;
        System.out.print(zahl); 
        while (!caller.returned()){
            System.out.println(", ");
            System.out.print(++zahl); // ++zahl, weil sonst zwei mal die null ausgegeben wird
            try {
                Thread.sleep((rand.nextInt(3) + 1) * 1000);
            } catch (InterruptedException e) {
                //wie kommt man in diesen block? wenn stop, dann interrupt 
                //(falls gerade der main thread sleep ist) damit zaehlerausgabe stoppt. 
                //(in diesem fall ohne wiederholte if abfrage fuer stop)
                System.out.println("Zaehlerausgabe beendet.");
                // e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("Es verbleiben " + caller.getDaysUntilNextBday() + " Tage bis zu deinem Geburtstag.");
    }
}
