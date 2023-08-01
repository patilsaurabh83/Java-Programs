package Udemy.demo;

import java.util.Scanner;

public class largest_Num {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = Integer.MIN_VALUE;
        System.out.println("Enter how much numbers you want to add : ");
        int n = sc.nextInt();
        if (n<0){
            System.exit(0);
        }
        int [] arr = new int[n];
        for (int i=0; i<n; i++){
            System.out.printf("Enter the %d value: ",i+1);
            arr[i] = sc.nextInt();
        }

        for (int x:arr) {
            if (x>max){
                max = x;
            }
        }
        System.out.println("The largest value added by you is "+max);
    }
}
