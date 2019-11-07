package others;

public class StrCombinations {

    public static void main(String[] args) {
        StrCombinations strCombinations = new StrCombinations();
        //strCombinations.combinations("abc");
        strCombinations.combinations("abcd", new StringBuilder(), 0);
    }

    public void combinations(String in, StringBuilder out, int index) {
        for(int i = index; i < in.length(); i++) {
            out.append(in.charAt(i));
            System.out.println(out);
            combinations(in, out, i+1);
            out.setLength(out.length()-1);
        }
    }
}
