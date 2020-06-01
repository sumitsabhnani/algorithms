package Coursera_Code.algorithm_on_graphs.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Acyclicity {
    public static int acyclic(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] stack = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (isCyclic(i, adj, visited, stack))
                return 1;
        }
        return 0;
    }

    private static boolean isCyclic(int index, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] stack) {
        if(stack[index])
            return true;
        if(visited[index])
            return false;
        visited[index] = true;
        stack[index] = true;
        for (Integer i : adj.get(index)) {
            if(isCyclic(i, adj, visited, stack))
                return true;
        }
        stack[index] = false;
        return false;
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
        System.out.println(acyclic(adj));
    }
}

