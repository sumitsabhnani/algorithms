package others.graph;

import java.util.List;

public class DepthFirstTraversal {

    public static void dfs(Graph graph, boolean[] visited, int vertex) {
        visited[vertex] = true;

        List<Integer> adjVertices = graph.getAdjacentVertices(vertex);

        for(Integer v : adjVertices) {
            if(!visited[v])
                dfs(graph, visited, v);
        }
    }
}
