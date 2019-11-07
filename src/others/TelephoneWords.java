package others;

import java.util.ArrayList;
import java.util.List;

public class TelephoneWords {

    char[][] telephoneKeys = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}, {'J', 'K', 'L'},
            {'M', 'N', 'O'}, {'P', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y'}};

    StringBuilder possibleWord = new StringBuilder();
    int[] teleArray;
    int count = 1;

    public static void main(String[] args) {
        TelephoneWords tw = new TelephoneWords();
        tw.teleArray = new int[]{8, 6, 6, 2, 6, 6, 5};
        //tw.getAllWords(0);
        tw.getAllWordsWithoutRecursion();
        //tw.possibleWords.forEach(System.out::println);
    }

    public void getAllWords(int index) {
        if (index == 7) {
            System.out.println(count+++"-"+possibleWord);
        } else {
            for (int p = 0; p < 3; p++) {
                possibleWord.append(getCharKey(teleArray[index], p));
                getAllWords(index + 1);
                possibleWord.setLength(possibleWord.length() - 1);
            }
        }
    }

    public void getAllWordsWithoutRecursion() {
        char possibleWord[] = new char[7];
        for(int i=0; i<teleArray.length ; i++) {
            possibleWord[i] = getCharKey(teleArray[i], 0);
        }
        int lplace = 1;
        int rplace = 1;
        int lindex = 5;
        int rindex = 6;
        while(true) {
            System.out.println(count+++"-"+new String(possibleWord));
            if(rplace == 3) {
                if(lindex == (rindex-1)) {
                    if(lplace == 3) {
                        if(lindex == 0)
                            break;
                        lindex--;
                        lplace = 1;
                    }
                    possibleWord[lindex] = getCharKey(teleArray[lindex], lplace++);
                    rindex = 6;
                    rplace = 0;
                } else {
                    rplace = 0;
                    rindex--;
                }
            }
            possibleWord[rindex] = getCharKey(teleArray[rindex], rplace++);
        }
    }

    public char getCharKey(int telephoneKey, int place) {
        if (telephoneKey < 2)
            return (char) telephoneKey;
        return telephoneKeys[telephoneKey - 2][place];
    }
}
