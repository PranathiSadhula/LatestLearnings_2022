package datastructures.week9.daywise.dec12.SystemDesignPractice;

import java.util.Comparator;

public class CarDetails implements Comparable<CarDetails> {
   private String car;
   private String type;
   private double price;

   public CarDetails(String car, String type, double price){
       this.car = car;
       this.type = type;
       this.price = price;

   }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }


    @Override
    public int compareTo(CarDetails car1) {
        return car1.price != this.price ? (int)(car1.price-this.price) : (int)(this.price-car1.price);
    }

    public String toString(){
       return this.car+" "+this.type+" "+this.price;
    }
}
