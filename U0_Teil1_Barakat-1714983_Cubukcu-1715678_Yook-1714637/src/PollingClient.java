public class PollingClient {
  
        public static void main(String[] args) {
                int start = 0;
                PollingCaller caller = new PollingCaller();
                while(caller.returned()==false) { //Polling
                        System.out.print((start +=1) + ", "); // hier könnte etwas sinnvolles gemacht werden
                        try {
                                Thread.sleep(1000);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
                System.out.println(" Ergebnis vom asynchronen Aufruf ");
        }
}
