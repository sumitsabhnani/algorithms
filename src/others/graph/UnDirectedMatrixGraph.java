package others.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnDirectedMatrixGraph implements Graph{

    int[][] verticesMatrix;
    int numVertices;
    GraphType graphType;

    public UnDirectedMatrixGraph(int numVertices, GraphType graphType) {
        this.graphType = graphType;
        this.numVertices = numVertices;
        this.verticesMatrix = new int[numVertices][numVertices];
    }

    @Override
    public void addEdge(int v1, int v2) {
        verticesMatrix[v1][v2] = 1;
        verticesMatrix[v2][v1] = 1;
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        List<Integer> adj = new ArrayList<>();
        for(int i = 0; i < numVertices; i++) {
            if(verticesMatrix[v-1][i] == 1)
                adj.add(i);
        }
        Collections.sort(adj);
        return adj;
    }
}
