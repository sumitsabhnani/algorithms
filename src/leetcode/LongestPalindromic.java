package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromic {

    Map<String, String> store;

    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length;
        store = new HashMap<>();

        String result = identifyLongestSubstring(start, end, s, arr);
        if (result.length() == 0)
            return "" + s.charAt(0);
        return result;
    }

    private String identifyLongestSubstring(int start, int end, String s, char[] arr) {
        if(store.get(start + "" + end) != null)
            return store.get(start + "" + end);
        int maxPalindromeSize = end - start;
        boolean possiblePalindrome = false;
        String result = "";
        int i = start;
        int j = end - 1;
        int size = 0;
        while (i < j) {
            if (arr[i] == arr[j]) {
                if (!possiblePalindrome) {
                    possiblePalindrome = true;
                    size = j - i + 1;
                }
                i++;
                j--;
            } else {
                possiblePalindrome = false;
                size = 0;
                break;
            }
        }
        if (possiblePalindrome) {
            if (result.length() < size) {
                result = s.substring(start, start + size);
            }
        }
        if (size == maxPalindromeSize || result.length() == maxPalindromeSize) {
            store.put(start + "" + end, result);
            return result;
        }
        String moveFront = identifyLongestSubstring(start + 1, end, s, arr);
        String moveBack = identifyLongestSubstring(start, end - 1, s, arr);

        if (moveFront.length() > moveBack.length()) {
            store.put(start + "" + end, moveFront);
            return moveFront;
        }
        store.put(start + "" + end, moveBack);
        return moveBack;
    }
}
