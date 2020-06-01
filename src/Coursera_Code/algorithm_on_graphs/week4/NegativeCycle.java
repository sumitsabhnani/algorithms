package Coursera_Code.algorithm_on_graphs.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class NegativeCycle {
    private static int negativeCycle(ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> cost) {
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < adj.size() - 1; i++) {
            for (int j = 0; j < adj.size(); j++) {
                queue.add(j);
            }
            while (!queue.isEmpty()) {
                int current = queue.pollFirst();
                for (int k = 0; k < adj.get(current).size(); k++) {
                    int node = adj.get(current).get(k);
                    int newDistance = dist[current] == Integer.MAX_VALUE ? cost.get(current).get(k) : dist[current] + cost.get(current).get(k);
                    if (newDistance < dist[node]) {
                        dist[node] = newDistance;
                    }
                }
            }
        }
        for (int j = 0; j < adj.size(); j++) {
            queue.add(j);
        }
        while (!queue.isEmpty()) {
            int current = queue.pollFirst();
            for (int k = 0; k < adj.get(current).size(); k++) {
                int node = adj.get(current).get(k);
                int newDistance = dist[current] == Integer.MAX_VALUE ? cost.get(current).get(k) : dist[current] + cost.get(current).get(k);
                if (newDistance < dist[node]) {
                    return 1;
                }
            }
        }
        return 0;
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
        System.out.println(negativeCycle(adj, cost));
    }
}

