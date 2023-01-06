package datastructures.week9.daywise.dec12.SystemDesignPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SystemTest {

    public static void main(String[] args) {
        CarDetails car1 = new CarDetails("Maruti Swift AT", "Diesel", 1258);
        CarDetails car2 = new CarDetails("Maruti Swift AT", "Petrol", 1158);
        CarDetails car3 = new CarDetails("EcoSport", "Diesel", 1250);
        CarDetails car4 = new CarDetails("Nexon", "Petrol", 1159);

        List<CarDetails> list = new ArrayList<>();
       // list.add(car1);
      //  list.add(car2);
     //   list.add(car3);
     //   list.add(car4);
        list.add(new CarDetails("xyz", "de", 130));
        list.add(new CarDetails("abc", "per", 1301));
        list.add(new CarDetails("zrt", "pet", 3130));
        list.add(new CarDetails("bca", "pde", 1930));

        for(CarDetails eachCar : list){
            System.out.println(eachCar.toString());
        }

        Collections.sort(list, (a,b) -> {
                return a.compareTo(b);
        });

        System.out.println("desc sorting");
        for(CarDetails eachCar : list){
            System.out.println(eachCar.toString());
        }

        Collections.sort(list, (a,b) -> {
            return b.compareTo(a);
        });

        System.out.println("asc sorting");
        for(CarDetails eachCar : list){
            System.out.println(eachCar.toString());
        }

    }



}
