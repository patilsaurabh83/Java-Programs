package Udemy.demo;

class LessMoneyException extends Exception{
    String name;
    double money;

    //above parameters to be filed(In withdrawal method) if any exception occur
    LessMoneyException(String name,double money){
        this.name = name;
        this.money = money;
    }
    @Override
    public String toString() {
        return "Dear " +name+" Money can't be below or less than zero,Poor balance (required) "+money+" :(";
    }
}
class AccountFun extends Thread{
    static int count = 1;
    String accNo;
    String name;
    double money = 10000;
    double rate;

    //All the above parameters are to be filled using the constructor
    AccountFun(String accNo, String name,double rate){
        this.accNo = accNo+count;
        this.name = name;
        this.rate = rate;
        count++;
    }

    //Money is withdrawn according to rate of withdraw(Annual calculation)
    public double withdrawal() throws LessMoneyException {
        double withdraw = 0;
        withdraw = withdraw + ((money*rate)/100)*12;
        money = money - withdraw;
        System.out.println(money);

        //If money in bank goes to the negative bcz of withdrawal exception will be thrown
        if (money<0){
                throw new LessMoneyException(name,money);
        }
        return money;
    }
    @Override
    synchronized public void run() {
            try {
                double calCul;

//                calCul is the variable to store the returned amount of money from withdrawal() method
                calCul = withdrawal();

                System.out.printf(
                                 "The Account Number %s ,You withdraw Money from your Account(Annually) %f at a rate of %f\n",
                                 accNo,calCul,rate
                                );

            } catch(Exception e){
                System.out.println(e);
            }
    }
}

public class bankAccount {
    public static void main(String[] args) {
//        objects are passed anonymously in the  array
        AccountFun[] accountFun = {
                new AccountFun("A", "John",4),
                new AccountFun("A", "Smith", 5),
                new AccountFun("A", "Henry", 10),
                new AccountFun("A", "Linda", 30)
        };

        // Iterating one by one (Flow can be different according to system preference to the thread)
        for (AccountFun fun : accountFun) {
            fun.start();
        }
    }

}
