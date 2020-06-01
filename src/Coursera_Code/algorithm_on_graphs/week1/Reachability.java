package Coursera_Code.algorithm_on_graphs.week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<ArrayList<Integer>> adj, int x, int y) {
        boolean visited[] = new boolean[adj.size()];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(x);
        do {
            int element = queue.poll();
            if (!visited[element]) {
                queue.addAll(adj.get(element));
                visited[element] = true;
                if (element == y)
                    return 1;
            }
        } while (!queue.isEmpty());
        return 0;
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
        System.out.println(reach(adj, x, y));
    }
}

