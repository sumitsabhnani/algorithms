package Coursera_Code.algorithm_on_graphs.week3;

import java.util.*;

public class Bipartite {
    private static int bipartite(ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[adj.size()];
        LinkedList<Integer> queue = new LinkedList<>();
        Arrays.fill(color, -1);
        color[0] = 0;
        queue.add(0);
        while (!queue.isEmpty()) {
            int current = queue.remove();
            int newColor = colorToAssign(color[current]);
            for (Integer c : adj.get(current)) {
                if (color[c] == color[current]) {
                    return 0;
                } else if (color[c] == -1) {
                    queue.add(c);
                    color[c] = newColor;
                }
            }
        }
        return 1;
    }

    private static int colorToAssign(int currentColor) {
        return currentColor == 1 ? 0 : 1;
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
        System.out.println(bipartite(adj));
    }
}

