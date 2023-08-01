package Udemy.demo;

import java.util.Scanner;

public class pyramid {
    static String loopString(String str,int n){
        String temp = "";
        for (int i=0; i<n; i++){
            temp = temp + str;
        }
        return temp.substring(0,n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number N : ");
        int n = sc.nextInt();
        char x = 'a';
        int count=1;

         for (int i=1; i<=n; i++){
             String str = "";
             if (i % 2 ==0){
                str = str +(x)+ count;
                str = str + loopString(str,i);
                System.out.println(str.substring(0,i));
             }
             else {
                 str = str + count +(x);
                 str = str + loopString(str,i);
                 System.out.println(str.substring(0,i));
             }
             x++;
             count++;
         }
    }
}
