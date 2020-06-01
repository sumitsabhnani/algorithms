package Coursera_Code.algorithm_on_graphs.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<ArrayList<Integer>> adj) {
        boolean[] used = new boolean[adj.size()];
        ArrayList<Integer> order = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            dfsRecursion(adj, used, order, i);
        }
        return order;
    }

    private static void dfsRecursion(ArrayList<ArrayList<Integer>> adj, boolean[] used, ArrayList<Integer> order, int s) {
        if (!used[s]) {
            if (adj.get(s).size() != 0) {
                for (Integer c : adj.get(s)) {
                    dfsRecursion(adj, used, order, c);
                }
            }
            order.add(s);
            used[s] = true;
        }
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] used, ArrayList<Integer> order, int s) {
        boolean[] stack = new boolean[adj.size()];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(s);
        while (!queue.isEmpty()) {
            int node = queue.peek();
            if (used[node]) {
                queue.pop();
            } else {
                if (stack[node]) {
                    order.add(node);
                    queue.pop();
                    stack[node] = false;
                    used[node] = true;
                } else {
                    if (adj.get(node).size() == 0) {
                        order.add(node);
                        queue.pop();
                        used[node] = true;
                    } else {
                        stack[node] = true;
                        for (Integer c : adj.get(node))
                            queue.push(c);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj.get(x - 1).add(y - 1);
        }
        ArrayList<Integer> order = toposort(adj);
        for (int i = order.size() - 1; i >= 0; i--) {
            System.out.print((order.get(i) + 1) + " ");
        }
    }
}

