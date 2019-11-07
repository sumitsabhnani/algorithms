package others;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    static List<String> all = new ArrayList<>();
    public static void main(String[] args) {
        permute("abc", "");
        System.out.println(all.size());
        for(String s: all)
            System.out.println(s);
    }
    
    private static void permute(String str, String result) {
        if(str.length() == 0) {
            all.add(result);
        }
        for(int i = 0; i < str.length(); i++) {
            result = result + str.charAt(i);
            permute(skip(str, i), result);
            result = remove(result, str.charAt(i));
        }
    }

    private static String skip(String str, int index) {
        StringBuilder s = new StringBuilder(str);
        s.deleteCharAt(index);
        return s.toString();
    }

    private static String remove(String str, char ch) {
        StringBuilder s = new StringBuilder(str);
        return s.deleteCharAt(s.indexOf(""+ch)).toString();
    }
}
