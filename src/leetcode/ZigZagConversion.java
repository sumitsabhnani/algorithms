package leetcode;

public class ZigZagConversion {

    public static void main(String args[]) {
        System.out.println(convert("A", 1));

    }

    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        int upRows = 0;
        int downRows = numRows - 1;
        int start = 0;
        int currentItem = start;
        while (sb.length() != s.length()) {
            sb.append(ch[currentItem]);
            while (currentItem < s.length()) {
                if (downRows > 0) {
                    int n = 2 * downRows - 1;
                    currentItem = currentItem + n + 1;
                    if (currentItem < s.length())
                        sb.append(ch[currentItem]);
                }
                if (upRows > 0) {
                    int n = 2 * upRows - 1;
                    currentItem = currentItem + n + 1;
                    if (currentItem < s.length())
                        sb.append(ch[currentItem]);
                }
            }
            downRows--;
            upRows++;
            currentItem = ++start;
        }
        return sb.toString();
    }
}
