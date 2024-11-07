
import java.util.concurrent.*;

public class CompletableFuturePollingTest extends Thread {
    public static void main(String[] args) {new CompletableFuturePollingTest(); }
    public CompletableFuturePollingTest() {this.start();}
    public void run() {
    BMIRechner bmi = new BMIRechner();
    double bmiWert = bmi.bmiBerechnen();
    // CompleteFuture setzt Aufgabe Diagnose um
    CompletableFuture<String> future = CompletableFuture.supplyAsync(bmi::diagnose);
    // Polling
    while (!future.isDone()) {
        int random = getRandomSleepTime(1000, 3000);
        System.out.println(Thread.currentThread() + "BMI Wert: " + bmiWert);
        try { 
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    try {
        System.out.println(Thread.currentThread() + ": Diagnose ist " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) { 
            e.printStackTrace();
        }

    }

    private int getRandomSleepTime(int min, int max) {
        return (min + (int)(Math.random() * ((max- min) + 1)));
    }
}
    