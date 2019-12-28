package Coursera_Code.Data_Structures.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Bracket {
    char type;
    int position;

    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        return this.type == '(' && c == ')';
    }
}

public class CheckBrackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        System.out.println(checkBrackets(text));
    }

    public static String checkBrackets(String text) {
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                opening_brackets_stack.push(new Bracket(next, position + 1));
            }

            if (next == ')' || next == ']' || next == '}') {
                Bracket lastBracket = null;
                if (!opening_brackets_stack.isEmpty()) {
                    lastBracket = opening_brackets_stack.pop();
                }
                if (lastBracket == null || !lastBracket.match(next)) {
                    opening_brackets_stack.push(new Bracket(next, position + 1));
                    break;
                }
            }
        }
        if (opening_brackets_stack.isEmpty())
            return "Success";
        else {
            Bracket failed = opening_brackets_stack.pop();
            return "" + failed.position;
        }
    }
}
