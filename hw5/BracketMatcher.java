
import java.util.Stack;

public class BracketMatcher{

    // this small nested class (lines 7 - 25) can help you solve the problem.
    // (if you feel it doesn't, feel free to delete it.)
//    private static class Bracket {
//        char bracketType;
//        int bracketPosition;
//
//        Bracket(char type, int position) {
//            bracketType = type;
//            bracketPosition = position;
//        }
//
//        boolean matches(char c) {
//            if (bracketType == '[' && c == ']')
//                return true;
//            if (bracketType == '{' && c == '}')
//                return true;
//            if (bracketType == '(' && c == ')')
//                return true;
//            return false;
//        }
//    }
    public static boolean match(Stack<Character> stack, char c){
        if (stack.peek() == '[' && c == ']') {
            return true;
        }
        if (stack.peek() == '{' && c == '}') {
            return true;
        }
        if (stack.peek() == '(' && c == ')') {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        In in = new In("test05.txt");
        String text = in.readLine();
        System.out.println("processing: " + text); // comment out or delete this line before submitting

        //Stack<Bracket> openingBrackets = new Stack<>();

        Stack<Character> openingBrackets = new Stack<>();
        int count = 1; // store the position of the char if we do not find a matching one
        if(text.length() < 1){
            System.out.println("nothing for input");
        }

        for (int position = 1; position <= text.length(); ++position) {
            char next = text.charAt(position - 1);

            if(next == '[' || next == '('||next == '{'){
                //push onto the stack if is an open bracket
                openingBrackets.push(next);
            }
            else if(next == ']' || next == ')'||next == '}'){
                // if there is a pair then pop the stack
                if(!openingBrackets.isEmpty() && match(openingBrackets,next)) {
                    openingBrackets.pop();
                }
               else if(openingBrackets.isEmpty()) { //if stack is empty and there's a right bracket
                    openingBrackets.push(null); //Push null so that it wont print success if there's only right brackets.
                    System.out.println(position);
                    break;
                }

            }

            if(position == text.length() && !openingBrackets.isEmpty()) { //There are elements remaining in the stack (meaning not enough right brackets)
                System.out.println(position);
                break;
            }
        }
        // Print "Success" if brackets are balanced
        /* YOUR CODE HERE */
        //System.out.println("test");

        if ( openingBrackets.isEmpty()){
            System.out.println("Success");
        }

    }
}
