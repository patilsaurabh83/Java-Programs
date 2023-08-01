package Udemy.demo;

import java.util.Scanner;

public class pellSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number (0-15) : ");
        int n = sc.nextInt();
        int a = 0;
        int b = 1;
        int c ;
        for (int i=0; i<n; i++){
            if (i==0){
                System.out.print(b+" ");
            }
            c = a+2*b;
            a=b;
            b=c;
            System.out.print(c+" ");
        }
    }
}
