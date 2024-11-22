import java.util.Random;

public class PollingClient {
    public static void main(String[] args) {

        // Delegieren der Aufgabe an PollingCaller, Instanz davon angelegt
        PollingCaller caller = new PollingCaller();
        System.out.println("PollingCaller Konstruktor aufgerufen.");
        Random rand = new Random();
        
        // Zaehlerausgabe
        int zahl = 0;
        System.out.print(zahl); 
        // Aufruf der PollingCaller Methode caller.returned():
        while (!caller.returned()){
            System.out.println(", ");
            System.out.print(++zahl); // ++zahl, weil sonst zwei mal die Null ausgegeben wird
            try {
                Thread.sleep((rand.nextInt(3) + 1) * 1000);
            } catch (InterruptedException e) {
                // wie kommt man in diesen Block? (moechte: wenn stop, dann interrupt,
                // (falls gerade der main thread sleep ist) damit zaehlerausgabe stoppt. 
                System.out.println("Zaehlerausgabe beendet.");
                e.printStackTrace();
            }
        }
        System.out.println();
        // Aufruf der PollingCaller Methode caller.getDaysUntilNextBday():
        System.out.println("Es verbleiben " + caller.getDaysUntilNextBday() + " Tage bis zu deinem Geburtstag.");
    }
}
