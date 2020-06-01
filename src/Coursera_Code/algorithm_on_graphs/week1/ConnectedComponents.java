package Coursera_Code.algorithm_on_graphs.week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<ArrayList<Integer>> adj) {
        int result = 0;
        boolean[] visited = new boolean[adj.size()];
        int[] component = new int[adj.size()];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                result++;
                queue.push(i);
                do {
                    int element = queue.poll();
                    if (!visited[element]) {
                        queue.addAll(adj.get(element));
                        visited[element] = true;
                        component[element] = result;
                    }
                } while (!queue.isEmpty());
            }
        }
        return result;
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
        System.out.println(numberOfComponents(adj));
    }
}

