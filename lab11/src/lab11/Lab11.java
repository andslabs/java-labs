package lab11;

import java.util.Scanner;
import java.util.Random;

public class Lab11 {
    
    static{
        System.load("C:\\libs\\libMathLib.dll");
    }
    
    public native double Cbqrt(double n);
    public native double Sin(double x);
    public native double ln(double x);
    public native int matrSumm8(int[][] matr);
    public native int matrSumm10(int[][] matr);
    
    public double f(double x){
        return (x - this.Sin(x));
    }
    
    private static class EmptyStr extends Exception {};
    
    public static void main(String[] args) {
        try{
            System.out.println("Task #1:");
            Scanner scanner = new Scanner(System.in);
            System.out.print(" Enter x1: ");
            String c = scanner.nextLine();
            if(c.isEmpty()) throw new EmptyStr();
            double x1 = Double.parseDouble(c);
            System.out.print(" Enter x2: ");
            c = scanner.nextLine();
            if (c.isEmpty()) throw new EmptyStr();
            double x2 = Double.parseDouble(c);
            Lab11 lib = new Lab11();
            double y1 = lib.Cbqrt(lib.f(0.348)) + lib.Sin(lib.f(x1));
            double y2 = lib.ln(2*lib.f(x2));
            System.out.println("Results:");
            System.out.println(" y1 equals to: " + y1);
            System.out.println(" y2 equals to: " + y2);
            System.out.println("\nTask #2:");
            System.out.println("Auto filled matrix X[8][8]:");
            int[][] matrX = new int[8][8];
            Random rand = new Random();
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    matrX[i][j] = rand.nextInt(500)+100;
                    System.out.print(matrX[i][j] + " ");
                }
                System.out.println();
            }
            int[][] Y = new int[10][10];
            rand = new Random();
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    Y[i][j] = rand.nextInt(100)+50;
                    System.out.print(Y[i][j] + " ");
                }
                System.out.println();
            }
            int sum8 = lib.matrSumm8(matrX);
            int sum10 = lib.matrSumm10(Y);
            System.out.println("Results:");
            System.out.println(" Sum of elements on main diagonal and higher of X matrix: " + sum8);
            System.out.println(" Sum of elements on main diagonal and higher of Y matrix: " + sum10);
        }
        catch(EmptyStr e){
            System.out.println("Your haven't entered anything!");
        }
    }
    
}