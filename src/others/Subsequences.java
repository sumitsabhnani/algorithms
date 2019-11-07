package others;

import java.util.Arrays;

public class Subsequences {
    public static void main(String[] args) {
        System.out.println(subsequences("0111").split(",").length);
    }

    public static String subsequences(String word) {
        if (word.isEmpty())
            return "";

        char firstWord = word.charAt(0);
        String restOfString = word.substring(1);

        String sub = subsequences(restOfString);

        String result = "";

        for (String s: sub.split(",",-1)) {
            result += "," + s;
            result += "," + firstWord + s ;
        }
        result = result.substring(1);
        return result;
    }
}
