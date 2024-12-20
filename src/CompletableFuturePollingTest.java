
import java.util.concurrent.*;


public class CompletableFuturePollingTest extends Thread {

    private int counter = 0;

    public static void main(String[] args) {
        new CompletableFuturePollingTest(); 
    }
    public CompletableFuturePollingTest() {
        this.start();
    }
    public void run() {
       
        BMIRechner bmi = new BMIRechner();

        CompletableFuture.supplyAsync(() -> {
            double bmiValue = bmi.bmiBerechnen();
            System.out.println("Thread: " + Thread.currentThread().getName() + " - BMI-Wert: " + bmiValue);
            return bmiValue;})
            .thenApplyAsync(s -> bmi.diagnose(s))                
            .thenAccept(result -> System.out.println(Thread.currentThread() + " Diagnose: " + result))
            .join(); 
        
    }      
        
    private int getRandomSleepTime(int min, int max) {
        return (min + (int)(Math.random() * ((max- min) + 1)));
    }
}
    