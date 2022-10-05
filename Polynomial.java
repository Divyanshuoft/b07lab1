import java.io.File;
import java.lang.Math;
import java.lang.reflect.Type;
import java.util.Scanner; 
import java.util.Arrays;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Polynomial {
    int [] Exponents;
    double [] Coefficients;
    public Polynomial(){
        this.Exponents = new int [1];
        this.Coefficients = new double [1];
        this.Exponents[0] = 0;
        this.Coefficients[0] = 0.0;
    }
    public Polynomial(File file){
        try {
        String text = "";
        Scanner myReader = new Scanner(file);
        while(myReader.hasNext()){ 
            text = text + myReader.next();
        }
        int catalag = 0;
        int [] E = new int [1024];
        double [] C = new double [1024];
        char[] amber = text.toCharArray();
        int h = 0;
        String[] arrOfStr = text.split("\\+|\\-");
        for(int i = 0; i < arrOfStr.length; i++){
            catalag++;
            int quan = 0;
            int index = text.indexOf(arrOfStr[i]);
            String[] p = arrOfStr[i].split("x");
            int k = 1;
            if(p.length >= 1){
            if(p[0] == "-" && amber[0] == '-'){
                for(int m = 0; m < p.length - 1; m++){
                    p[m] = p[k];
                    k++;
                }
            }
                if(!p[0].isEmpty()){

                C[i] = Double.parseDouble(p[0]);
                if(amber[index - 1] == '-') C[i] = -C[i];}}
            int q = 1;
            if(p.length > 1){
                q = 0;
            }
            if(q == 0){
            if((arrOfStr[i].indexOf("x") < arrOfStr[i].indexOf(p[1]))){
                E[h] = Integer.parseInt(p[1]);
                quan++;
            }}
            for(int g = 0; g < p.length; g++){
                p[g] = null;
            }
            if(quan == 1) h++;
        }
            myReader.close();
        if(amber[0] == '-'){
            for(int f = 0; f < C.length - 1; f++){
                C[f] = C[f+1];
            }
        }
        int [] E2 = new int [catalag];
        double [] C2 = new double [catalag];
        for(int cj = 0; cj < catalag; cj++){
            E2[cj] = E[cj];
            C2[cj] = C[cj];
        }
        this.Coefficients = C2;
        this.Exponents = E2;
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    public Polynomial(double [] new_coefficeints, int [] expo){
        if(new_coefficeints == null || expo == null){
            this.Coefficients[0] = 0.0;
            this.Exponents[0] = 0;
        }
        else{
            this.Coefficients = new_coefficeints;
            this.Exponents = expo;
        }   
    }
    public int find(int [] p, int index){
        int count = 0;
        for(int i = 0; i < Exponents.length; i++){
            if(Exponents[i] == index){
                count = count + 1;
                return i;
                }
        }
        return -1;
    }
    public Polynomial add(Polynomial inp){
        double [] out = new double [this.Coefficients.length + inp.Coefficients.length];
        int [] powers = new int [this.Coefficients.length + inp.Coefficients.length];
        int k = 0;
        for(int i = 0; i < this.Coefficients.length; i++){
            int count = 0;
            for(int j = 0; j < inp.Coefficients.length; j++){
                if(this.Exponents[i] == inp.Exponents[j]){
                    int index = find(powers, i);
                    if(index != -1){
                    out[index] = this.Coefficients[i] + inp.Coefficients[j];
                    powers[index] = this.Exponents[i];
                    count++;
                    k++;}
                    else{
                    out[k] = this.Coefficients[i] + inp.Coefficients[j];
                    powers[k] = this.Exponents[i];
                    k++;
                    count++;}
                }
            }
            if(count == 0){
                out[k] = this.Coefficients[i];
                powers[k] = this.Exponents[i];
                k++;
            }
        }
        for(int p = 0; p < inp.Coefficients.length; p++){
            int counter = 0;
            for(int r = 0; r < this.Coefficients.length; r++){
                if((this.Exponents[r] == inp.Exponents[p])){
                    int index = find(powers, r);
                    if(index != -1){
                    out[index] = this.Coefficients[r] + inp.Coefficients[p];
                    powers[index] = this.Exponents[r];
                    counter++;
                    k++;
                    }
                    else{
                        out[p] = this.Coefficients[r] + inp.Coefficients[p];
                        powers[p] = this.Exponents[r];
                        k++;
                        counter++; 
                    }
                }
            }
            if(counter == 0){
                out[k] = inp.Coefficients[p];
                powers[k] = inp.Exponents[p];
                k++;
            }
        }
        Polynomial z = new Polynomial(out, powers);
        return z;}
    public void preset(double [] c, int [] p){
        for(int i = 0; i < p.length; i++){
            p[i] = 0;
            p[i] = 0;
        }
    }
    public Polynomial multiply(Polynomial inp){
        int k = 0;
        double [] Coeff = new double [123];
        int [] Exp = new int [123];
        preset(Coeff, Exp);
        for(int i = 0; i < this.Coefficients.length; i++){
            for(int j = 0; j < inp.Coefficients.length; j++){
                int power = inp.Exponents[j] + this.Exponents[i];
                double c = inp.Coefficients[j]*this.Coefficients[i];
                int index = find(Exp, power);
                if(index != -1){
                    Coeff[index] += c;
                    Exp[index] += power;
                    k++;
                }
                else{
                    Coeff[k] += c;
                    Exp[k] += power;
                    k++;
                }
            }
        }
        Polynomial z = new Polynomial(Coeff, Exp);
        return z;
    }
    public double evaluate(double input){
        double result = 0;
        int size_length = Math.max(this.Coefficients.length, this.Exponents.length);
        for(int i = 0; i < size_length; i++){
            result += this.Coefficients[i]*(Math.pow(input, this.Exponents[i]));
        }
        return result;
    }
    public boolean hasRoot(double input){
        if(evaluate(input) == 0){
            return true; 
        }
        return false;
    }
    public void saveToFile(String text) throws FileNotFoundException {
        try
        {
            String var = "";
            for(int i = 0; i < this.Exponents.length; i++){
                if(this.Exponents[i]!= 0 && this.Coefficients[i] != 0.0){
                if(i < this.Exponents.length - 1){
                if(this.Coefficients[i+1] < 0.0){
                    var  = var + String.valueOf(this.Coefficients[i]) + "x" + String.valueOf(this.Exponents[i]);
                }
                else{
                    var  = var + String.valueOf(this.Coefficients[i]) + "x" + String.valueOf(this.Exponents[i]) + "+";
                }
            }
            else if (this.Coefficients[i] > 0.0){
                var  = var + String.valueOf(this.Coefficients[i]) + "x" + String.valueOf(this.Exponents[i]);
            }
                }
                else if (this.Coefficients[i] != 0.0){
                    if(i < this.Exponents.length - 1){
                    if(this.Coefficients[i+1] < 0.0){
                        var  = var + String.valueOf(this.Coefficients[i]);
                    }
                else{
                    var  = var + String.valueOf(this.Coefficients[i])+ "+";
                }
                }
                else{
                    var  = var + String.valueOf(this.Coefficients[i]);
                }
                }
            }
            int len = var.length();
            char c=var.charAt(len-1);
            if(c == '+'){
                var = var.substring(0, var.length()-1);
            }
            PrintStream ju = new PrintStream(text);
            ju.println(var);
            ju.close();      
        }
        catch (FileNotFoundException ex)  
        {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
    }
}