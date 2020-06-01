package Coursera_Code.algorithm_on_graphs.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StronglyConnected {
    private static int numberOfStronglyConnectedComponents(ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> reverseAdj) {
        boolean[] used = new boolean[reverseAdj.size()];
        boolean[] visited = new boolean[reverseAdj.size()];
        ArrayList<Integer> order = new ArrayList<>();
        for (int i = 0; i < reverseAdj.size(); i++) {
            dfs(reverseAdj, used, visited, i, order);
        }
        int connectedComponents = 0;
        visited = new boolean[reverseAdj.size()];
        for (int i = order.size() - 1; i >= 0; i--) {
            boolean[] stack = new boolean[reverseAdj.size()];
            if (!visited[order.get(i)]) {
                connectedComponents++;
                explore(adj, visited, stack, order.get(i));
            }
        }
        return connectedComponents;
    }

    private static void explore(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] stack, int index) {
        if (!stack[index] && !visited[index]) {
            stack[index] = true;
            visited[index] = true;
            for (Integer c : adj.get(index)) {
                explore(adj, visited, stack, c);
            }
            stack[index] = false;
        }
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] used, boolean[] visited, int index, ArrayList<Integer> order) {
        if (!used[index] && !visited[index]) {
            visited[index] = true;
            for (Integer c : adj.get(index)) {
                dfs(adj, used, visited, c, order);
            }
            order.add(index);
            used[index] = true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> reverseAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            reverseAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj.get(x - 1).add(y - 1);
            reverseAdj.get(y - 1).add(x - 1);
        }
        System.out.println(numberOfStronglyConnectedComponents(adj, reverseAdj));
    }
}

