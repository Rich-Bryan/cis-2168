import java.util.*;
import java.util.Map.Entry;
public class ThreeLetterWords {
    private ArrayList<String> words = new ArrayList<>(); // all three-letter words
    private Map<Character, Integer> cMap = new HashMap<>(); // letter-number map
    public Map<String, Integer> wordMap = new TreeMap<>(); // word-number map
    // Constructor: builds the word - number dictionary. Each word is
// associated with the sum of its letter values
    public ThreeLetterWords() {
        makeWords(); // Already implemented
        buildLetterMap(); // Implement this method below
        buildWordMap(); // Implement this method below
    }
    // Builds an ArrayList of all three-letter words
    private void makeWords() {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVXYZ".toCharArray();
        StringBuilder sb = new StringBuilder("");
        for (char a : chars) {
            for (char b : chars) {
                for (char c : chars) {
                    sb.append(a).append(b).append(c);
                    words.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
    }
    // Builds the letter-number map (A=1, B=2, ..., Z=25)
    private void buildLetterMap() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < alphabet.length(); i++) {
            cMap.put(alphabet.charAt(i), i+1);
        }
            // YOUR CODE HERE (it's only one line)

    }
    // Builds the word-number (number = sum of letter values) map
    public void buildWordMap() {
        // YOUR CODE HERE
        int sum = 0;
        for(String word : words){
            // calculate the sum of letter values of each word
            // since it's three-letter word so no need to write a for loop
            sum = cMap.get(word.charAt(0)) + cMap.get(word.charAt(1)) + cMap.get(word.charAt(2));
            wordMap.put(word, sum);		// map each word to its sum
            sum = 0;	// reset to 0
        }

    }
    // test the ThreeLetterWords data type (add your tests as needed)
    public static void main(String[] args) {
        ThreeLetterWords tlw = new ThreeLetterWords();
        Map<String, Integer> map = tlw.wordMap;
        //System.out.println(map);
        Map<String, Integer> result = new TreeMap<>();
        for (Entry<String, Integer> entry : map.entrySet())
            if (entry.getValue().equals(39)) result.put(entry.getKey(), entry.getValue());
        for (Entry<String, Integer> entry : result.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }
}
