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
                Thread.currentThread().setName("BMI-Thread");
                System.out.println("Thread: \"" + Thread.currentThread() + "\" - BMI-Wert: " + bmiValue);
                return bmiValue;
            })
            .thenApplyAsync(s -> {
                String r = bmi.diagnose(s);
                getRandomSleepTime();
                return r;
            })                
            .thenAccept(result -> {
                Thread.currentThread().setName("Diagnose-Thread");
                System.out.println("Thread: \"" + Thread.currentThread() + "\" - Diagnose: " + result);
            })
            .join(); 
        
    }      
        
    private void getRandomSleepTime() {
        int zahl = 0;
        Random rand = new Random();
        //random zeit für allgemein warten
        int randomTimer = (rand.nextInt(3) + 1);

        //Zaehlerausgabe
        System.out.print(zahl); 
        //zwischen jeder zeit wird random gewartet
        while (randomTimer>=0) {
            System.out.println(", ");
            System.out.print(++zahl); 
            try {
                Thread.sleep((rand.nextInt(3) + 1) * 1000);
            } catch (InterruptedException e) {
                System.out.println("Zaehlerausgabe beendet.");
                e.printStackTrace();
            }
            randomTimer--;
        }
        System.out.println("");
        
    }
}
    