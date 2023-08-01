package Udemy.demo;

import java.util.Arrays;

class Person{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

}

class Employee extends Person{

     String ID;
     double payRate;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    @Override
    public String toString() {
        return "Employee" +
                "\nID='" + ID + '\'' +
                "\npayRate=" + payRate;
    }
}
class Faculty extends  Employee{
    String officeHours;
    String [] teachingCourses= {"101_M1","102_M2","103_M3","104_M4"};

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String[] getTeachingCourses() {
        return teachingCourses;
    }

    public void setTeachingCourses(String[] teachingCourses) {
        this.teachingCourses = teachingCourses;
    }

    @Override
    public String toString() {
        return "Faculty Details:" +
                "\nofficeHours='" + officeHours + " hours"+'\'' +
                "\nteachingCourses=" + Arrays.toString(teachingCourses) +
                "\nID='" + ID + '\'' +
                "\npayRate=" + payRate +
                "\nname='" + name + '\'';
    }
}


public class University {

    static void printPerson(Person p){

        //This calls the to string method of provide object of class

        p=p;
        System.out.println(p);

    }

    public static void main(String[] args) {

        Person p = new Person();
        Employee e= new Employee();
        Faculty f= new Faculty();

        //Setting the values for person

        p.name = "John";

        //Setting the values for Employee
        e.ID = "101A";
        e.name = p.name;
        e.payRate = 500.50;

        //Setting the values for Faculty
        f.officeHours= "5";
        f.name = e.name;
        f.ID = e.ID;
        f.payRate = e.payRate;

        //method providing object of the child class
        printPerson(f);

    }
}
