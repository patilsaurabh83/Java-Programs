package Udemy.demo;

import java.util.Random;
import java.util.Scanner;

class Game{
    public void result(int count){
        if (count>10){
            System.out.println("Increase your thinking ability ! ! !");
            System.out.println("Your attempts - "+count);
        }
        else {
            System.out.printf("Excellent guess,in %d attempts",count);
        }
    }
}

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        Game g = new Game();

        boolean flag = false;
        int count = 1;
        int i = 3;

        System.out.println("Enter Guessed number: ");
        int guess = sc.nextInt();
        if (guess>10){
            System.out.println("Wrong Input");
            i--;
            System.out.println("Only "+ i + " attempts left");
            if(i==0) {
                System.exit(0);
            }
        }

        int random = r.nextInt(10) + 1;
        while (!flag) {

            if (random == guess){
                System.out.println("You win !!");
                System.out.println("Random number was " +random);
                count++;
                flag = true;
            }
            else if (guess > random) {
                System.out.println("Too high");
                System.out.println("Random number was " +random);
                count++;
                random = r.nextInt(10) + 1;
                System.out.println("Guess again : ");
                guess = sc.nextInt();
                if (guess>10){
                    System.out.println("Wrong Input");
                    i--;
                    System.out.println("Only "+ i + " attempts left");
                    if(i==0)  {
                        System.exit(0);
                    }
                }

            }
            else if (guess < random) {
                System.out.println("Too low");
                System.out.println("Random number was " +random);
                count++;
                random = r.nextInt(10) + 1;
                System.out.println("Guess again : ");
                guess = sc.nextInt();
                if (guess>10){
                    System.out.println("Wrong Input");
                    i--;
                    System.out.println("Only "+ i + " attempts left");
                    if(i==0)  {
                        System.exit(0);
                    }
                }
            }
            else if (guess>10){
                System.out.println("Wrong Input");
                i--;
                System.out.println("Only "+ i + " attempts left");
                if(i==0) {
                    System.exit(0);
                }
            }
        }
        g.result(count);

    }
}
