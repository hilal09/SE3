import java.util.concurrent.*;
import java.util.Random;

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
                getRandomSleepTime(1000, 3000);
                Thread.currentThread().setName("Thread 1");
                System.out.println("Thread: \"" + Thread.currentThread() + "\" - BMI-Wert: " + bmiValue);
                return bmiValue;
            })
            .thenApplyAsync(s -> {
                String r = bmi.diagnose(s);
                getRandomSleepTime(1000, 3000);
                return r;
            })                
            .thenAccept(result -> {
                Thread.currentThread().setName("Thread 2");
                System.out.println("Thread: \"" + Thread.currentThread() + "\" - Diagnose: " + result);
            })
            .join(); 
        
    }      
        
    private void getRandomSleepTime(int min, int max) {

        try {
            Thread.sleep((min + (int)(Math.random() * ((max- min) + 1))));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // System.out.println(", ");
        //     System.out.print(++zahl); 
        //     try {
        //         Thread.sleep((rand.nextInt(3) + 1) * 1000);
        //     } catch (InterruptedException e) {
        //         System.out.println("Zaehlerausgabe beendet.");
        //     }
        
    }

    // private void waiting() {
    //     Random rand = new Random();
    //     int waitingTime = //zufallige zahl dauer
    // }

}
    