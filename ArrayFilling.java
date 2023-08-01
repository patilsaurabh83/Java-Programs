package Udemy.demo;

import java.util.Random;

class ArrayFill{
    int [] num = new int[100];
    //Count is for thread calculation
    int count =1;
    //Counter and Counter1 for the loop operations
    int counter = 25;
    int counter1 = 0;

    Random r = new Random();

    synchronized void array() throws Exception{
        for(int i=0; i<counter; i++){
            num[i] = r.nextInt(counter)+counter1;
        }

        //To print the array values filled by the thread inside the array

        System.out.println("Values printed by the "+count+"th Thread ");
        System.out.print("[ ");
        for (int x=counter1; x<num.length+1; x++) {
            if (x>=counter) {
                System.out.print("]");
                System.out.println("\n \n");
                break;
            }
        System.out.print(x + " ");
        }
        count++;
        counter1 = counter;
        counter = counter+25;
    }

}
class Array extends Thread{

    ArrayFill a;
    int count=1;
    Array(ArrayFill a){
       this.a = a;
   }

    @Override
     synchronized public void run() {
//        if any Exception occurs it will handled here
        try {
            a.array();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
public class ArrayFilling {
    public static void main(String[] args) {
        //Object of important class
        ArrayFill af = new ArrayFill();

        // objects of classes
        Array a1 = new Array(af);
        Array a2 = new Array(af);
        Array a3 = new Array(af);
        Array a4 = new Array(af);

        // Here 4 threads are started
        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }
}
