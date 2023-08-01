package Udemy;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int computer=0;
        boolean flag = false;
        int count =1;

        System.out.println("choice Are like below: ");

        System.out.println(" 1.Rock\n" +
                           " 2.Paper\n" +
                           " 3.Scissors");

        while (!flag) {
            computer = r.nextInt(3)+1;
            System.out.println("Enter your choice : ");

            int user = sc.nextInt();

                 if (user>3) {
                System.out.println("Invalid input,Try again");
                count++;
                System.out.println("Input should be in between 1 to 3 ! \n");
                continue;
                }
                else if (computer == user) {
                    System.out.println("Draw");
                    count++;

                } else if (computer == 3 && user == 1 || computer == 2 && user == 3 || computer == 1 && user == 2) {
                    System.out.println("You win");
                    flag = true;
                } else {
                    System.out.println("You lose..!");
                    count++;
                }
            switch (computer){
                case 1:
                    System.out.println("Computer choose: Rock\n");
                    break;
                case 2:
                    System.out.println("Computer choose: Paper\n");
                    break;
                case 3:
                    System.out.println("Computer choose: Scissors\n");
                    break;

            }
        }
        System.out.println("Your Tried for "+count+" times");

    }
}
