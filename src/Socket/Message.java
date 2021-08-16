package Socket;

import java.util.Date;

public class Message {
    private String userName;
    private String message;
    private String sentDate;


    public Message() {

    }

    public Message(String userName, String message, String sentDate) {
        this.userName = userName;
        this.message = message;
        this.sentDate = sentDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    @Override
    public String toString() {
        return "Message{" +
                "userName='" + userName + '\'' +
                ", message='" + message + '\'' +
                ", sentDate=" + sentDate +
                '}';
    }
}
