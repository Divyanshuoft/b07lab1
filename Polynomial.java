import java.lang.Math;
public class Polynomial {
    double [] Coefficients;
    public Polynomial(){
        this.Coefficients = new double [1];
        this.Coefficients[0] = 0.0;
    }
    public Polynomial(double[] new_coefficeints){
        if(new_coefficeints == null){
            this.Coefficients[0] = 0.0;
        }
        else{
            this.Coefficients = new_coefficeints;
        }   
    }
    public Polynomial add(Polynomial inp){
        int h1 = 0;
        int looper = 0;
        if(this.Coefficients.length <= inp.Coefficients.length) h1 = 1;
        if(h1 == 0){
            looper = inp.Coefficients.length;
            for(int i = 0; i < looper; i++){
                this.Coefficients[i] += inp.Coefficients[i];
            }
            return this;
        }
        for(int j = 0; j < this.Coefficients.length; j++){
            inp.Coefficients[j] += this.Coefficients[j];
        }
        return inp;
    }
    public double evaluate(double input){
        double result = 0;
        for(int i = 0; i < this.Coefficients.length; i++){
            result += this.Coefficients[i]*(Math.pow(input, i));
        }
        return result;
    }
    public boolean hasRoot(double input){
        if(evaluate(input) == 0){
            return true; 
        }
        return false;
    }
}