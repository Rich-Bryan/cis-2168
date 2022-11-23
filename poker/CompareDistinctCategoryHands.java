import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CompareDistinctCategoryHands {
    public static void main(String[] args) {
        int p1wins = 0;
        int p2wins = 0;
        int max1; // max hand rank for the hand
        int max2;

        int suit1;
        int suit2;

        int[] compareValues;
        int valueAtKey;


        try {
            for (String line : Files.readAllLines(Paths.get("distinctHandPairs.txt"))) {
                Hand hand1 = new Hand(line.substring(0, 14));
                Hand hand2 = new Hand(line.substring(14, 29).trim());

                if (hand1.getHandValue() > hand2.getHandValue()) {
                    System.out.println("Player 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
                            ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                            ")\n\t\t\t    Player 1 wins.\n");
                    p1wins++;
                } else if (hand1.getHandValue() < hand2.getHandValue()){
                    System.out.println("Player 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
                            ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                            ")\n\t\t\t    Player 2 wins.\n");
                    p2wins++;
                }
                else {

                    max1 = hand1.getCardRanks()[0];
                    max2 = hand2.getCardRanks()[0];


                    suit1 = hand1.checkSuit();
                    suit2 = hand2.checkSuit();

                    compareValues = new int [2];

                    //check for straight flush
                    if(hand1.getHandValue() == 8 && hand2.getHandValue() == 8){
                        if (max1 > max2) {
                            compareValues[0] = max1;
                        }
                        else if (max2 > max1){
                            compareValues[1] = max2;
                        }else{ // meaning they have the same ranks
                            if(suit1 > suit2){
                                compareValues[0] = max1 +1;
                            }else{
                                compareValues[1] = max2 +1;
                            }
                        }
                    //check for four-of-a-kind
                    }else if (hand1.getHandValue() == 7 && hand2.getHandValue() == 7){
                        for (Integer key : hand1.getCardRanks()) {
                            valueAtKey = hand1.getRankFrequency().get(key);
                            if (valueAtKey == 4) { compareValues[0] = key; }
                        }
                        for (Integer key : hand2.getCardRanks()) {
                            valueAtKey = hand2.getRankFrequency().get(key);
                            if (valueAtKey == 4) { compareValues[1] = key; }
                        }
                    }
                    // same full-house
                    else if (hand1.getHandValue() == 6 && hand2.getHandValue() == 6) {
                        for (Integer key : hand1.getCardRanks()) {
                            valueAtKey = hand1.getRankFrequency().get(key);
                            if (valueAtKey == 3 && hand1.isPair()) { compareValues[0] = key; }
                        }
                        for (Integer key : hand2.getCardRanks()) {
                            valueAtKey = hand2.getRankFrequency().get(key);
                            if (valueAtKey == 3 && hand2.isPair()) { compareValues[1] = key; }
                        }
                    }
                    // same flush
                    else if (hand1.getHandValue() == 5 && hand2.getHandValue() == 5) {
                        for(int i = 0; i < hand1.getHand().size(); i++){
                            if(hand1.getCardRanks()[i] > hand2.getCardRanks()[i]){
                                compareValues[0] = hand1.getCardRanks()[i];
                                break;
                            }else if (hand1.getCardRanks()[i] < hand2.getCardRanks()[i])
                                compareValues[1] = hand1.getCardRanks()[i];
                                break;
                            }
                        }
                    // same straight
                    else if (hand1.getHandValue() == 4 && hand2.getHandValue() == 4) {
                        max1 = hand1.getCardRanks()[0];
                        max2 = hand2.getCardRanks()[0];
                        if (max1 > max2) compareValues[0] = max1;
                        else if (max2 > max1) compareValues[1] = max2;
                    }
                    // same three of a kind
                    else if (hand1.getHandValue() == 3) {
                        for (Integer key : hand1.getCardRanks()) {
                            valueAtKey = hand1.getRankFrequency().get(key);
                            if (valueAtKey == 3) { compareValues[0] = key; }
                        }
                        for (Integer key : hand2.getCardRanks()) {
                            valueAtKey = hand2.getRankFrequency().get(key);
                            if (valueAtKey == 3) { compareValues[1] = key; }
                        }
                    }
                    // same two pairs:
                    else if (hand1.getHandValue() == 2 && hand2.getHandValue() == 2) {
                        for (Integer key : hand1.getCardRanks()) {
                            valueAtKey = hand1.getRankFrequency().get(key);
                            if (valueAtKey == 2 && key > compareValues[0]) { compareValues[0] = (key);}
                        }

                        for (Integer key : hand2.getCardRanks()) {
                            valueAtKey = hand2.getRankFrequency().get(key);
                            if (valueAtKey == 2 && key > compareValues[1]) { compareValues[1] = (key);}
                        }
                        //check if they have the same ranks then check for the single card
                        if ( compareValues[0] == compareValues[1]){
                            for(int i = 0; i < 5; i++){
                                int key1 = hand1.getCardRanks()[i];
                                int key2 = hand2.getCardRanks()[i];
                                if(hand1.getRankFrequency().get(key1) == 1){// check the key that has val as 1
                                    compareValues[0] = key1; // this key is gonna be higher
                                    //System.out.println(key1);
                                }
                                if(hand2.getRankFrequency().get(key2) == 1){ // check for the key that has val as 1
                                    compareValues[1] = key2; // this key is gonna be higher
                                    //System.out.println(key2);
                                }
                            }
                        }
                    }
                    // same pair
                    else if (hand1.getHandValue() == 1 && hand2.getHandValue() == 1) {
                        for (Integer key : hand1.getCardRanks()) {
                            valueAtKey = hand1.getRankFrequency().get(key);
                            if (valueAtKey == 2) { compareValues[0] = (key); }
                        }
                        for (Integer key : hand2.getCardRanks()) {
                            valueAtKey = hand2.getRankFrequency().get(key);
                            if (valueAtKey == 2) { compareValues[1] = (key); }
                        }

                    } // TODO fix the nothing hand rank so that it deosnt have the bug
                    else if(hand1.getHandValue() == 0 && hand2.getHandValue() == 0){
                        for(int i = 0; i < 5; i++){
                            if(hand1.getCardRanks()[i] > hand2.getCardRanks()[i]){
                                compareValues[0] = hand1.getCardRanks()[i];
                            }if(hand1.getCardRanks()[i] < hand2.getCardRanks()[i]){
                                compareValues[1] = hand2.getCardRanks()[i];
                            }
                        }

                    }

                    if (compareValues[0] > compareValues[1]) {
                        System.out.println("Player 1: " + hand1 + " (" + Hand.nameMap.get(hand1.getHandValue()) +
                                ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                                ")\n\t\t\t    Player 1 wins.\n");
                        p1wins++;
                    }
                    else {
                        System.out.println("Player 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
                                ")\nPlayer 2: " + hand2 + "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                                ")\n\t\t\t    Player 2 wins.\n");
                        p2wins++;
                    }

                }
            }
            System.out.println("Number of hands won by player 1: " + p1wins);
            System.out.println("Number of hands won by player 2: " + p2wins);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}