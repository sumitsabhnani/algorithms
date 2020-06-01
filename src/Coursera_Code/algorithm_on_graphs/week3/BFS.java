package Coursera_Code.algorithm_on_graphs.week3;

import java.util.*;

public class BFS {
    private static int distance(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        int[] dist = new int[adj.size()];
        bfs(adj, dist, u);
        return dist[v];
    }

    private static void bfs(ArrayList<ArrayList<Integer>> adj, int[] dist, int S) {
        LinkedList<Integer> queue = new LinkedList<>();
        Arrays.fill(dist, -1);
        dist[S] = 0;
        queue.add(S);
        while(!queue.isEmpty()) {
            int current = queue.remove();
            for(Integer c : adj.get(current)) {
                if(dist[c] == -1) {
                    queue.add(c);
                    dist[c] = dist[current] + 1;
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
            adj.get(y - 1).add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

