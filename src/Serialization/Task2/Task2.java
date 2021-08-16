package Serialization.Task2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList <Game> games = getGame();
        while(true){
            System.out.println("PRESS 1 TO CREATE GAME\n" +
                    "PRESS 2 TO ADD PLAYER TO GAME\n" +
                    "PRESS 3 TO PLAY GAME\n" +
                    "PRESS 0 TO EXIT");
            int choice = in.nextInt();
            if (choice == 1) {
                ArrayList <Players> players = new ArrayList<>();
                System.out.println("Game name: ");
                String name = in.next();
                System.out.println("IP address: ");
                String ip = in.next();
                System.out.println("PORT: ");
                int port = in.nextInt();
                games.add(new Game(name, ip, port, players));
                saveGame(games);
            }else if(choice == 2){
                System.out.println("CHOOSE GAME: \n");
                games = getGame();
                int i = 1;
                for(Game s: games){
                    System.out.println(i + "  " + s.getGameName() + "\n");
                    i++;
                }
                int ind = in.nextInt();
                System.out.println("Nickname: ");
                String nickname = in.next();
                System.out.println("Rating: ");
                double rating = in.nextDouble();
                games.get(ind - 1).addPlayer(new Players(nickname, rating));
                saveGame(games);
            }else if(choice == 3){
                System.out.println("CHOOSE GAME: \n");
                games = getGame();
                int i = 1;
                for(Game s: games){
                    System.out.println(i + "  " + s.getGameName() + "\n");
                    i++;
                }
                int ind = in.nextInt();
                System.out.println(games.get(ind - 1).toString());
            }else{
                System.exit(0);
            }
        }
    }

    public static void saveGame(ArrayList <Game> games){
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("settings.dat"));
            outputStream.writeObject(games);
            outputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Game> getGame(){
        ArrayList<Game> games = new ArrayList<>();
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("settings.dat"));
            games = (ArrayList<Game>)inputStream.readObject();
            inputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return games;
    }
}
