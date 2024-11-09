public class BMIRechner {

    private float mGewicht= 65.1f;
    private float mGroesse=1.6f;

    public double bmiBerechnen(){
        double bmi = (this.mGewicht/ Math.pow(this.mGroesse, 2));
        return bmi;
    }

    public String diagnose(Double bmi){
        if (bmi<=18.5){
            return "Untergewicht";
        } else if (bmi>=25){
            return "Übergewicht";
        } else{
            return "Normalgewicht";
        }    
    }

}
