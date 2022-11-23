public class TestSimpleBattleShip {
    public static void main(String[] args) {
        SimpleBattleShip ship = new SimpleBattleShip();
        int[] coordinates = {3,4,5};
        ship.setPositions(coordinates);
        int userGuess = 5;
        String result = ship.updateStatus(userGuess);
        String testResult = "failed";
        if (result.equals("hit")){
            testResult = "passed";
        }
        System.out.println(testResult);
    }
}
