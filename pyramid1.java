package Udemy.demo;

import java.util.Scanner;

public class pyramid1 {
    static String loopOperation(String s, int n){
        String str = "";
        for (int i=0; i<n-1; i++){
           str = str + s;
        }
        if (str.isEmpty()){
            return s;
        }
        return str;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number(Input) : ");
        int n = sc.nextInt();

        char end = 'Z';
        char start = (char) (end - (n-1));
        String updated = "";
        int count = 1;

        while (start != end+1){
            String s = String.valueOf(start);
            System.out.println(loopOperation(s,count)+updated);
            updated = String.valueOf(start);
            start++;
            count++;
        }
    }
}
