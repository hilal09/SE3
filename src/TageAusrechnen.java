
import java.time.LocalDateTime;
public class TageAusrechnen {

    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        int currentYear = currentDateTime.getYear();
        int currentMonth = currentDateTime.getMonthValue();
        int currentDay = currentDateTime.getDayOfMonth();

        int month = 9;
        int day = 9;

        int daysUntilNextBday = 0;

        

        System.out.println(currentYear);
    }
}


