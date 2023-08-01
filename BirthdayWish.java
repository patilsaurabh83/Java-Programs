package Udemy;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

class Execution1 extends Thread {

        //Constructor variable
        String name;
        int year;

        //Time operations
        LocalTime lt = LocalTime.now();
        LocalTime lt1 = LocalTime.parse("12:00");


        //Constructor of class
        public Execution1(String name,int year) {
            this.name = name;
            this.year = year;
        }


        //Thread method --> for complete execution
        //Wait patiently until program executes  --> Important

        @Override
        synchronized public void run() {
            try {
                if (lt.isAfter(lt1)) {
                    System.out.println(name +" now you are are in waiting area,wait patiently!!!!");
                    int j = 0;
                    while (j < 10) {
                        thread.sleep(1000);
                        System.out.println("\t.");
                        j++;
                    }

                    int i = 0;
                    System.out.println("\t\tGreetings from starlink\n" +
                                        "\t\tCongratulations "+name+" on becoming "+year+" Years old :)");
                    Thread.sleep(10000);
                    while (i < year) {
                        thread.sleep(1000);
                        System.out.println(
                                "\t\tDear "+name+",\n" +
                                "\t\tYou are a my spacial person and I'll keep you near Always\n" +
                                "\t\tBut I'm sorry I can't be with you on your special day but I will always be there for you in mind and spirit.\n" +
                                "\t\tI wish you a wonderful birthday! Also have a wonderful day fulfilled with joy and happiness and again very very very happy birthday dear :)\n" +
                                "\n" +
                                "\t\t#Fav_person\n" +
                                "\t\t#Doremon\n" +
                                "\t\t#Coder\n" +
                                "\t\t#HBD\n"
                        );
                        thread.sleep(100);
                        i++;
                    }

                }
                else {
                    System.out.println("This program is Scheduled for special date and time");
                    System.out.println("You are not the Actual user of this program");
                }
            } catch (Exception e) {
                System.out.println("Problem occurred : "+e);
            }
            finally {
                System.out.println("Thanks for using the Program !!!");
            }
        }

    }
public class BirthdayWish {
        public static void main(String[] args) {

//            Important points --> try to execute the program on your Birthdate and On/after 12Am
             //before after the actual birthdate this program will not work

//            User inputs:
//            Add brith date ex. 2001-12-14(yyyy-MM-dd) year-month-date format

            try {

                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your brith date(yyyy-MM-dd):");
                String birthDate = sc.nextLine();

                // All the checking Parameters are stored here
                String temp = "Abir";
                String bYear = "2002";
                String month1 = "3";

                //User input - name
                System.out.println("Enter your first name:");
                String name = sc.nextLine();


                //BirthDate operation
                LocalDate l = LocalDate.now();
                LocalDate l1 = LocalDate.parse(birthDate);
                String bYear1 = String.valueOf(l1.getYear());
                String month = String.valueOf(l1.getMonthValue());
                LocalDate l2 = l1.plusYears((l.getYear() - l1.getYear()));

                int year = Math.abs(l1.getYear() - l.getYear());

                //For correct inputs the if block will run the class constructor and Thread
                if (l.equals(l2) && name.equalsIgnoreCase(temp) && bYear.equals(bYear1) && month.equals(month1)) {
                    Execution1 e = new Execution1(name,year);
                    e.start();
                } else {
                    System.out.println("OOPS!!!inputs provided by you maybe wrong");
                    System.out.println("Check the entered inputs, and try again :)");
                }
            }
            catch (Exception e){
                System.out.println("Error,Check your inputs  --> "+ e);
            }
        }
 }
