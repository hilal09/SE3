public class CallbackClient {
    boolean stop = false;
    int zahl = 0;
    TageAusrechnen bday = new TageAusrechnen();

    public CallbackClient() {
        CallbackCaller caller = new CallbackCaller(this); // delegiert asynchronen Aufruf

        while (!stop){
            System.out.print((zahl+=1) +", "); //Zählerausgabe
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { 
                e.printStackTrace();
            }
        }
    }
    public void callback() {
        stop = true;
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) { 
            e.printStackTrace();
        }
        System.out.println(bday.tageausrechnen());
    }
    public static void main(String[] args) { 
        new CallbackClient(); 
    }
}