import java.io.IOException;

public class CallbackCaller extends Thread { // führt asynchronen Aufruf aus
    CallbackClient client;
    public CallbackCaller (CallbackClient c) { 
        client = c; this.start(); }
    public void run() { // Hier könnte ein entfernter Aufruf stehen
        System.out.println(" entfernter Aufruf läuft u. wartet auf return ");
        try {
            System.in.read();
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
        client.callback();
    }
}