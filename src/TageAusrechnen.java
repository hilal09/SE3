
import java.time.LocalDate;
public class TageAusrechnen {

    public String tageausrechnen(){
        LocalDate currentDate = LocalDate.now();
        LocalDate bday = LocalDate.of(2025, 9, 9);
        int daysUntilNextBday = 0;

        while (!currentDate.equals(bday)) { 
            daysUntilNextBday += 1;
            currentDate = currentDate.plusDays(1);   
        }

        return Integer.toString(daysUntilNextBday);
    }
}        



