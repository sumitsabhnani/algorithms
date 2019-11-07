package others.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph implements Graph {

    ArrayList<ArrayList<Integer>> adjacencyVertices;
    int numVertices;
    GraphType graphType;

    public int getNumVertices() {
        return numVertices;
    }

    public AdjacencyListGraph(int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        this.graphType = graphType;

        adjacencyVertices = new ArrayList<>();

        for (int i = 0; i < numVertices; i++)
            adjacencyVertices.add(new ArrayList<>());
    }

    @Override
    public void addEdge(int v1, int v2) {
        adjacencyVertices.get(v1).add(v2);

        if(graphType == GraphType.UNDIRECTED)
            adjacencyVertices.get(v2).add(v1);
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        return adjacencyVertices.get(v);
    }
}
