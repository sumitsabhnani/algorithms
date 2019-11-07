package techgig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BulbChain {

    static String chain1, chain2;
    static int lengthChain1, lengthChain2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chain1 = br.readLine();
        chain2 = br.readLine();
        lengthChain1 = chain1.length();
        lengthChain2 = chain2.length();
        System.out.println(findMin(0, 0, 0));
    }

    private static int findMin(int indexChain1, int indexChain2, int changeCount) {
        if (indexChain1 < chain1.length() && indexChain2 < chain2.length()) {
            if (chain1.charAt(indexChain1) == chain2.charAt(indexChain2))
                return findMin(indexChain1 + 1, indexChain2 + 1, changeCount);
            else {
                int min1, min2, min3;
                lengthChain1--;
                min1 = findMin(indexChain1 + 1, indexChain2, changeCount + 1);
                lengthChain1++;
                lengthChain1++;
                min2 = findMin(indexChain1, indexChain2 + 1, changeCount + 1);
                lengthChain1--;
                min3 = findMin(indexChain1 + 1, indexChain2 + 1, changeCount + 1);
                return Math.min(Math.min(min1, min2), min3);
            }
        }
        return changeCount + Math.abs(lengthChain1 - lengthChain2);
    }
}
