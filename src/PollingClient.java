public class PollingClient {
  
        public static void main(String[] args) {
                int start = 0;
                TageAusrechnen bday = new TageAusrechnen();
                PollingCaller caller = new PollingCaller();
                while(caller.returned()==false) { //Polling
                        System.out.print((start +=1) + ", "); // Zählerausgabe
                        try {
                                Thread.sleep(2000);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
                try {
                        Thread.sleep(4000);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
                System.out.println(bday.tageausrechnen());
        }
}
