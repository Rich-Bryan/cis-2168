import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SimpleBattleShipGame {
    public static void main(String[] args) {
        int numOfGuesses = 0;
        SimpleBattleShip ship = new SimpleBattleShip();
        Random rand = new Random();
        int random = rand.nextInt(4);
        //set the ship coordinates
        int[] coordinates = {random, random+1,random+2};

        ship.setPositions(coordinates);
        //to check if it Alive
        boolean isAlive = true;
        //start the game
        while(isAlive){
            int result = getInput();
            numOfGuesses++;
            String game = ship.updateStatus(result);
            System.out.println(game);
            //to end the game
            if(game.equals("kill")){
                isAlive = false;
            }


        }
        System.out.println("you took " + numOfGuesses + " guesses");

    }
    public static int getInput() {
        System.out.print("enter a number: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }

}
