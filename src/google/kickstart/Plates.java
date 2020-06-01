package google.kickstart;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Plates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int P = scanner.nextInt();
            int[][] stack = new int[N][K];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < K; j++) {
                    stack[i][j] = scanner.nextInt();
                }
            }
            Stack<Integer>[] stacks = new Stack[N];
            Stack<Integer>[] sumStack = new Stack[N];
            for (int i = 0; i < N; i++) {
                stacks[i] = new Stack<>();
                sumStack[i] = new Stack<>();
                for (int j = K - 1; j >= 0; j--) {
                    stacks[i].push(stack[i][j]);
                    if (j == K - 1)
                        sumStack[i].push(stack[i][j]);
                    else {
                        int sum = sumStack[i].peek();
                        sumStack[i].push(sum + stack[i][j]);
                    }
                }
            }
            int currentPlates = 0;
            int maxBeauty = 0;
            while (currentPlates < P) {
                int maxStackIndex = maxStackIndex(sumStack);
                sumStack[maxStackIndex].pop();
                int beauty = stacks[maxStackIndex].pop();
                maxBeauty = maxBeauty + beauty;
                currentPlates++;
            }
            System.out.println("Case #" + test + ": " + maxBeauty);
        }
    }

    private static int maxStackIndex(Stack<Integer>[] sumStack) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < sumStack.length; i++) {
            if(!sumStack[i].isEmpty()) {
                if (max < sumStack[i].peek()) {
                    index = i;
                    max = sumStack[i].peek();
                }
            }
        }
        return index;
    }
}