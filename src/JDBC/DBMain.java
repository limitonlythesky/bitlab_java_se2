package JDBC;

import java.util.ArrayList;

public class DBMain {
    public static void main(String args[]){
        DBManager dbManager = new DBManager();
        dbManager.connect();

       // dbManager.addCar(new Car("Toyota Highlander", 70000, 3500));

        ArrayList <Car> cars = dbManager.getAllCars();

        for(Car c: cars){
            System.out.println(c.toString());
        }
    }
}
