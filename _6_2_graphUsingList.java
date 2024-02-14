import java.util.*;
import java.util.LinkedList;

public class _6_2_graphUsingList
{
    public static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    public static void printGraph(List<List<Integer>> adj) {
        for(int i = 0; i < adj.size(); i++) {
            System.out.print(i + " : ");
            for(int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void BFS(List<List<Integer>> adj, int v) {
        boolean[] visited = new boolean[adj.size()];
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(v);
        visited[v] = true;
        while(!q.isEmpty()) {
            int firstVert =(int) q.poll();
            System.out.print(firstVert + " ");
            for(int i = 0; i < adj.get(firstVert).size(); i++) {
                int addVert = adj.get(firstVert).get(i);
                if(visited[addVert] != true) {
                    visited[addVert] = true;
                    q.add(addVert);
                }
            }
        }
    }
    
    public static void DFSrec(List<List<Integer>> al, boolean[] visited, int s) {
        visited[s] = true;
        System.out.print(s + " ");
        for(int i : al.get(s)) {
            if(!visited[i]) {
                // visited[i] = true;
                DFSrec(al, visited, i);
            }
        }
    } 
    
    public static void DFS(List<List<Integer>>al, int start) {
        boolean[] visited = new boolean[al.size()];
        DFSrec(al, visited, start);
    }
    
	public static void main(String[] args) {
		List<List<Integer>> adj = new ArrayList<>();
		int vertices = 4;
		
		for(int i = 0; i < vertices; i++) {
		    adj.add(new ArrayList<>());
		}
		addEdge(adj, 0,1);
		addEdge(adj, 1,2);
		addEdge(adj, 2,3);
		
		printGraph(adj);
        
        BFS(adj, 0);
        System.out.println();
        
        DFS(adj, 0);
	}
}