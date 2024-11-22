import java.util.Random;

public class CallbackClient extends Thread {
    
    boolean stop = false;
    
    /** 
     * Konstruktor Aufruf: ruft Konstruktor von CallbackCaller auf und 
     * startet eigene Aufgabe (Zaehlerausgabe) 
     */
    public CallbackClient() {
        
        new CallbackCaller(this); // delegiert asynchronen Aufruf
        System.out.println("CallbackCaller Konstruktor aufgerufen.");
        Random rand = new Random();
        
        // Zaehlerausgabe:
        int zahl = 0;
        System.out.print(zahl); 
        while (!stop) {
            System.out.println(", ");
            System.out.print(++zahl); 
            try {
                Thread.sleep((rand.nextInt(3) + 1) * 1000);
            } catch (InterruptedException e) {
                // wie kommt man in diesen Block? (moechte: wenn stop, dann interrupt,
                // (falls gerade der main thread sleep ist) damit zaehlerausgabe stoppt. 
                System.out.println("Zaehlerausgabe beendet.");
                e.printStackTrace();
            }

        }
        System.out.println("Zaehlerausgabe beendet.");
    }

    /** callback() wird von CallbackCaller aufgerufen, liefert dem Client das Ergebnis */
    public void callback(int result) {
        stop = true;
        System.out.println();
        System.out.println("Es verbleiben " + result + " Tage bis zu deinem Geburtstag.");
    }

    public static void main(String[] args) { 
        new CallbackClient(); 
    }

}