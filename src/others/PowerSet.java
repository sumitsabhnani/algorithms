package others;

import java.util.Arrays;

public class PowerSet {

    public static void main(String args[]) {
        int[] input = {1,2,3};

    }

    static void powerSet(int[] input, int index) {
        if(index == input.length)
            return;
        System.out.println(Arrays.toString(input));

    }
}
