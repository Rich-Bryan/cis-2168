public class SimpleBattleShip {
    private int[] shipCoordinates;
    private int numOfHits;

    public String updateStatus(int guess){
        for(int i = 0 ;i < shipCoordinates.length; i++) {
            //if the guess is right
            if (guess == shipCoordinates[i]) {
                //change the coordinates
                shipCoordinates[i] = -1;
                //increment the numOfHits
                numOfHits++;
                //if it hit all the 3 is "kill"
                if (numOfHits == 3) {
                    return "kill";
                } else {
                    return "hit";
                }
            }
        }
        return "miss";
    }

    public void setPositions(int[] coords){
        shipCoordinates = coords;

    }
}
