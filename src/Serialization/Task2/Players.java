package Serialization.Task2;

import java.io.Serializable;

public class Players implements Serializable {
    private String nickName;
    private double rating;

    public Players(String nickName, double rating) {
        this.nickName = nickName;
        this.rating = rating;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Players{" +
                "nickName='" + nickName + '\'' +
                ", rating=" + rating +
                '}';
    }
}
