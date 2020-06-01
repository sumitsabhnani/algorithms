package codechef.mar20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHPINTU {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            String[] nM = br.readLine().split(" ");
            int baskets = Integer.parseInt(nM[0]);
            int fruitTypes = Integer.parseInt(nM[1]);
            int[] basketFruits = new int[baskets];
            String[] fruits = br.readLine().split(" ");
            for (int i = 0; i < fruits.length; i++) {
                basketFruits[i] = Integer.parseInt(fruits[i]);
            }
            int[] cost = new int[baskets];
            String[] money = br.readLine().split(" ");
            for (int i = 0; i < baskets; i++) {
                cost[i] = Integer.parseInt(money[i]);
            }

            int[] fruitSort = new int[fruitTypes];
            for (int i = 0; i < baskets; i++) {
                int fruitSortIndex = basketFruits[i] - 1;
                fruitSort[fruitSortIndex] = fruitSort[fruitSortIndex] + cost[i];
            }
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < fruitSort.length; i++) {
                if (fruitSort[i] != 0) {
                    if (fruitSort[i] < minCost)
                        minCost = fruitSort[i];
                }
            }
            System.out.println(minCost);
        }
    }
}