import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) {
        BMIRechner bmi = new BMIRechner();

        CompletableFuture.supplyAsync(() -> {
            double bmiValue = bmi.bmiBerechnen();
            System.out.println("Thread: " + Thread.currentThread().getName() + " - BMI-Wert: " + bmiValue);
            return bmiValue;})
            .thenApplyAsync(s -> bmi.diagnose(s))                
            .thenAccept(result -> System.out.println(Thread.currentThread() + " Diagnose: " + result))
            .join(); 
        
    }
    
}
