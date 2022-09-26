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
        // declare the output array
        if(h1 == 0){ // This length is the bigger one 
            looper = inp.Coefficients.length;
            double [] out = new double [this.Coefficients.length];
            for(int i = 0; i < looper; i++){
                // change the output instances
                out[i] = inp.Coefficients[i] + this.Coefficients[i];
            }
            for(int h = looper; h < this.Coefficients.length; h++){
                out[h] = this.Coefficients[h];
            }
            Polynomial k = new Polynomial(out);
            return k;
        }
        looper = this.Coefficients.length;
        double [] out = new double [inp.Coefficients.length];
        for(int j = 0; j < looper; j++){
            out[j] = inp.Coefficients[j] + this.Coefficients[j];
        }
        for(int h = looper; h < inp.Coefficients.length; h++){
            out[h] += inp.Coefficients[h];
        }
        Polynomial z = new Polynomial(out);
        return z;
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