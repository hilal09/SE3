
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
            getRandomSleepTime(1000,3000);
            double bmiValue = bmi.bmiBerechnen();
            System.out.println("Thread: " + Thread.currentThread().getName() + " - BMI-Wert: " + bmiValue);
            return bmiValue;})
            .thenApplyAsync(s -> {
                bmi.diagnose(s);
                return ??;
            })                
            .thenAccept(result -> System.out.println(Thread.currentThread() + " Diagnose: " + result))
            .join(); 
        
    }      
        
    private void getRandomSleepTime(int min, int max) {
        try {
            Thread.sleep((min + (int)(Math.random() * ((max- min) + 1))));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
    