public class BMIRechner {

    private double mGewicht = 65.1;
    private double mGroesse = 1.6;

    /**
     * BMI wird berechnet mit hard gecodeten Werten, Ergebnis wird returned
     */
    public double bmiBerechnen() {
        double bmi = (this.mGewicht/ Math.pow(this.mGroesse, 2));
        return bmi;
    }

    /**
     * anhand des uebergebenen BMI-Wertes wird die Diagnose erstellt
     */
    public String diagnose(Double bmi) {
        if (bmi <= 18.5) {
            return "Untergewicht";
        } else if (bmi >= 25) {
            return "Übergewicht";
        } else {
            return "Normalgewicht";
        }    
    }

}
