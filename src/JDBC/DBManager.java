package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bitlab_db1?useUnicode=true&serverTimezone=UTC","root", ""
            );
            System.out.println("CONNECTED");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Car> getAllCars(){
        ArrayList<Car> cars = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cars");

            ResultSet rs = st.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                double weight = rs.getDouble("weight");

                cars.add(new Car(id, name, price, weight));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return cars;
    }

    public void addCar(Car car){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO cars(name, price, weight) values(?,?,?)");

            st.setString(1,car.getName());
            st.setInt(2,car.getPrice());
            st.setDouble(3,car.getWeight());

            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
