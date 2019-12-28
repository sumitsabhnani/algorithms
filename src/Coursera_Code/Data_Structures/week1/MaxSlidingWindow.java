package Coursera_Code.Data_Structures.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaxSlidingWindow {

    public static void main(String args[]) throws IOException {
        FastScanner scanner = new FastScanner();
        int size = scanner.nextInt();
        int[] stack = new int[size];
        for (int i = 0; i < size; i++)
            stack[i] = scanner.nextInt();
        int window = scanner.nextInt();
        List<Integer> result = maxSlidingWindow(size, stack, window);
        for (int i = 0; i < result.size(); i++)
            System.out.print(result.get(i) + " ");
    }

    public static List<Integer> maxSlidingWindow(int size, int[] stack, int window) {
        Queue queue = new Queue();
        for (int i = 0; i < window; i++) {
            queue.enQueue(stack[i]);
        }
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = window; i < size; i++) {
            result.add(queue.deQueue());
            queue.enQueue(stack[i]);
        }
        result.add(queue.maxPeek());
        return result;
    }

    static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();

        void enQueue(int x) {
            int max = x;
            while (!s1.isEmpty()) {
                int e = s1.pop();
                if (e > max)
                    max = e;
                s2.push(e);
                maxStack.pop();
            }
            s1.push(x);
            maxStack.push(max);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
                maxStack.push(max);
            }
        }

        int deQueue() {
            int x = maxStack.peek();
            s1.pop();
            maxStack.pop();
            return x;
        }

        int maxPeek() {
            return maxStack.peek();
        }

        @Override
        public String toString() {
            return "S1:" + s1.toString() + ":::S2:" + s2.toString() + ":::MaxStack:" + maxStack.toString();
        }
    }

    static class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
