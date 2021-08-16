package Serialization.Task2;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {
    private String gameName;
    private String ipAddress;
    private int port;
    private ArrayList<Players> players = new ArrayList<>();

    public Game() {
    }

    public Game(String gameName, String ipAddress, int port, ArrayList<Players> players) {
        this.gameName = gameName;
        this.ipAddress = ipAddress;
        this.port = port;
        this.players = players;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ArrayList<Players> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Players> players) {
        this.players = players;
    }

    public void addPlayer(Players player){
        players.add(player);
    }

    @Override
    public String toString() {
        if(players.size() > 0){
            return "Game{" +
                    "gameName='" + gameName + '\'' +
                    ", ipAddress='" + ipAddress + '\'' +
                    ", port=" + port +
                    ", players: " + players +
                    "}\n";
        }else{
            return "Game{" +
                    "gameName='" + gameName + '\'' +
                    ", ipAddress='" + ipAddress + '\'' +
                    ", port=" + port +
                    ", No players" +
                    "}\n";
        }
    }
}
