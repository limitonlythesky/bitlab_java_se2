package Multithreading.Task3;

public class Car extends Thread {
    private int speed;
    private String name;
    private double distance;
    private int time;

    public Car(ThreadGroup threadGroup, String name, int speed, double distance) {
        super(threadGroup, name);
        this.speed = speed;
        this.distance = distance;
        this.time = 1;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }

    @Override
    public void run() {
        try {
            while(time * speed < distance){
                //System.out.println(getName() + " is in " + (time * speed) + " meters");
                time++;
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace( );
        }
    }
}