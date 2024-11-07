public class BMIRechner {

    private float mGewicht= 65.1f;
    private float mGroesse=1.6f;
    private double bmi;

    public double bmiBerechnen(){
        this.bmi = (this.mGewicht/ Math.pow(this.mGroesse, 2));
        return this.bmi;
    }

    public String diagnose(){
        if (this.bmi<=18.5){
            return "Untergewicht";
        } else if (bmi>=25){
            return "Übergewicht";
        } else{
            return "Normalgewicht";
        }    
    }

}
