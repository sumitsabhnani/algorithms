package Coursera_Code.algorithm_on_graphs.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Dijkstra {
    private static int distance(ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> cost, int u, int v) {
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[u] = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(u);
        while (!queue.isEmpty()) {
            int current = queue.remove();
            for (int i = 0; i < adj.get(current).size(); i++) {
                int node = adj.get(current).get(i);
                int newDistance = dist[current] + cost.get(current).get(i);
                if (newDistance < dist[node]) {
                    dist[node] = newDistance;
                    queue.add(node);
                }
            }
        }
        if (dist[v] == Integer.MAX_VALUE)
            return -1;
        return dist[v];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> cost = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            cost.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj.get(x - 1).add(y - 1);
            cost.get(x - 1).add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

