
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
                getRandomSleepTime(1000, 3000);
                System.out.println("Thread: " + Thread.currentThread().getName() + " - BMI-Wert: " + bmiValue);
                return bmiValue;
            })
            .thenApplyAsync(s -> {
                String r = bmi.diagnose(s);
                getRandomSleepTime(1000, 3000);
                return r;
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
    