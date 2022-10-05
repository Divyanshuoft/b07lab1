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
public class Driver {
    public static void main(String [] args) {
    Polynomial p = new Polynomial();
    System.out.println(p.evaluate(3));
    int [] pp1 = {0,1,2};
    int [] pp2 = {0,1};
    double [] c1 = {1, 1, 1};
    Polynomial p1 = new Polynomial(c1, pp1);
    double [] c2 = {-1, 1};
    Polynomial p2 = new Polynomial(c2, pp2);
    Polynomial s = p1.add(p2);
    System.out.println("s(0.1) = " + s.evaluate(0.1));
    Polynomial q = p1.multiply(p2);
    System.out.println("q(0.1) = " + q.evaluate(0.1));
    if(s.hasRoot(-1)){
    System.out.println("-1 is a root of s");}
    else
    System.out.println("-1 is not a root of s");
    if(q.hasRoot(1)){
    System.out.println("1 is a root of q");}
    else
    System.out.println("1 is not a root of q");
    if(s.hasRoot(0)){
    System.out.println("0 is a root of s");}
    else
    System.out.println("0 is not a root of s");
try
        {
		s.saveToFile("C:\\Users\\Divyansh\\Documents\\hi1.txt");
		q.saveToFile("C:\\Users\\Divyansh\\Documents\\hi2.txt");}

        catch (FileNotFoundException ex)  
        {
            // insert code to run when exception occurs
        }
    }
    }