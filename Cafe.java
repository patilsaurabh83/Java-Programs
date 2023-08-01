package Udemy.demo;

class Drinks{
    private String drinksName;
    private int quantity;
    private final double DURIAN_PRICE = 10.0;

    public Drinks(String drinksName, int quantity){
        this.drinksName = drinksName;
        this.quantity = quantity;
    }

    public void setDrinkName(String drinksName) {
        this.drinksName = drinksName;
    }

    public double calculatePrice(){
        return quantity * DURIAN_PRICE;
    }

    @Override
    public String toString() {
        return "drinkName='" + drinksName + '\'' +
                ", quantity=" + quantity;
    }
}

class GoldenDurianPrice extends Drinks{
    private boolean discountCoupon;
    private final double PRICE = 5.20;

    public GoldenDurianPrice(int quantity , boolean discountCoupon){
        super("",quantity);
        setDrinkName("Golden Durian Juice");
        this.discountCoupon = discountCoupon;
    }

    public boolean isDiscountCoupon() {
        return discountCoupon;
    }

    @Override
    public double calculatePrice() {
        if (isDiscountCoupon()){
           return super.calculatePrice()*PRICE/0.5;
        }
        return super.calculatePrice() * PRICE;
    }


    @Override
    public String toString() {
        if (isDiscountCoupon())
            return super.toString() + '\'' +
                    ", discountCoupon=" + discountCoupon;

       return "User don't have Discount Coupon";
    }
}
public class Cafe {
    public static void main(String[] args) {
        int count = 0;
           GoldenDurianPrice[] goldenDurianPrice = new GoldenDurianPrice[20];
           goldenDurianPrice[0] = new GoldenDurianPrice(10,true);
           goldenDurianPrice[1] = new GoldenDurianPrice(4,true);
           goldenDurianPrice[2] = new GoldenDurianPrice(2,false);
           goldenDurianPrice[3] = new GoldenDurianPrice(20,false);
           goldenDurianPrice[4] = new GoldenDurianPrice(21,true);
           goldenDurianPrice[5] = new GoldenDurianPrice(10,false);
           goldenDurianPrice[6] = new GoldenDurianPrice(40,true);
           goldenDurianPrice[7] = new GoldenDurianPrice(3,true);
           goldenDurianPrice[8] = new GoldenDurianPrice(100,false);
           goldenDurianPrice[9] = new GoldenDurianPrice(50,false);
           goldenDurianPrice[10] = new GoldenDurianPrice(50,false);
        for (GoldenDurianPrice x: goldenDurianPrice) {
            if (x == null){
                break;
            }
            System.out.println(x);
            if (x.isDiscountCoupon()){
                count++;
            }
        }
        System.out.println("\nThe count of users that have Discount Coupons is "+count);

    }
}
