package Multithreading.Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main7 {
    public static void main(String[] args) {
        ArrayList<Car> c=new ArrayList<>();
        ThreadGroup threadGroup = new ThreadGroup("first");
        c.add(new Car(threadGroup, "Ferrari", 300, 1000));
        c.add(new Car(threadGroup,"Mercedes", 280, 1000));
        c.add(new Car(threadGroup, "BMW", 320, 1000));
        c.add(new Car(threadGroup, "Lamborghini", 360, 1000));
        c.add(new Car(threadGroup, "Wolkswagen", 250, 1000));
        c.add(new Car(threadGroup,"Audi", 270, 1000));
        c.add(new Car(threadGroup,"McLaren", 350, 1000));
        c.add(new Car(threadGroup,"Ford", 240, 1000));
        c.add(new Car(threadGroup,"Skoda", 230, 1000));
        c.add(new Car(threadGroup,"Nissan", 260, 1000));

        for(Car car: c){
            car.start();
        }

        while(threadGroup.activeCount() > 0){

        }

        c.sort(Comparator.comparingInt(Car::getTime));
        Collections.reverse(c);

        for (int i = 0; i < c.size(); i++){
            System.out.println("Place " + (i + 1) + " " + c.get(i).getName() + " - " + c.get(i).getTime() + " seconods");
        }
    }
}
