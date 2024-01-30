class Graph {
    private int ajMatrix[][];
    private int numVert;
    
    Graph (int numVert) {
        this.numVert = numVert;
        ajMatrix = new int[numVert][numVert];
        for(int i = 0; i < numVert; i++) {
            for(int j = 0; j < numVert; j++) {
                ajMatrix[i][j] = 0;
            }
        }
    }
    
    void addEdge(int v, int u) {
        ajMatrix[v][u] = 1;
        ajMatrix[u][v] = 1;
    }
    
    void removeEdge(int u, int v) {
        ajMatrix[v][u] = 0;
        ajMatrix[u][v] = 0;
    }
    
    void traversal() {
        for(int i = 0; i < numVert; i++) {
            for(int j = 0; j < numVert; j++) {
                System.out.print(ajMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class _6_1_graphUsingMatrix
{
	public static void main(String[] args) {
	    Graph g = new Graph(4);
	    
	    g.addEdge(1, 2);
	    g.addEdge(3, 1);
	    g.addEdge(2, 3);
	    
	    g.traversal();
	}
}