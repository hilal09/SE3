import java.util.Random;
import java.util.concurrent.*;

public class CompletableFuturePollingTest extends Thread {

    public static void main(String[] args) {
        new CompletableFuturePollingTest(); 
    }
    public CompletableFuturePollingTest() {
        this.start();
    }
    @Override
    public void run() {
       
        BMIRechner bmi = new BMIRechner();

        CompletableFuture.supplyAsync(() -> {
            double bmiValue = bmi.bmiBerechnen();
                getRandomSleepTime();
                Thread.currentThread().setName("Thread 1");
                System.out.println("Thread: \"" + Thread.currentThread() + "\" - BMI-Wert: " + bmiValue);
                return bmiValue;
            })
            .thenApplyAsync(s -> {
                String r = bmi.diagnose(s);
                getRandomSleepTime();
                return r;
            })                
            .thenAccept(result -> {
                Thread.currentThread().setName("Thread 2");
                System.out.println("Thread: \"" + Thread.currentThread() + "\" - Diagnose: " + result);
            })
            .join(); 
        
    }      
        
    private void getRandomSleepTime() {
        int zahl = 0;
        Random rand = new Random();
        int timer = (rand.nextInt(3) + 1);

        //Zaehlerausgabe
        System.out.print(zahl); 
        while (timer>=0) {
            System.out.println(", ");
            System.out.print(++zahl); 
            try {
                Thread.sleep((rand.nextInt(3) + 1) * 1000);
            } catch (InterruptedException e) {
                System.out.println("Zaehlerausgabe beendet.");
                e.printStackTrace();
            }
            timer--;
        }
        System.out.println("");
        
    }
}
    