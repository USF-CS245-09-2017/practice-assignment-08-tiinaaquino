import java.util.*;

public class GraphAdjMatrix implements Graph{

	private int[][] graph;
	private int v;

	// constructor
	public GraphAdjMatrix(int vertex){
		this.graph = new int[vertex][vertex];
		this.v = vertex;
	}


	@Override
	/**
	 * adds a directed edge between two vertices
	 * from src to target
	 */
	public void addEdge(int v1, int v2){
		graph[v1][v2] = 1;
	}

 
	@Override
	/**
	 * prints one ordering of vertices
	 */
    public void topologicalSort(){
        Stack<Integer> stack = new Stack<Integer>();
 
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++){
            visited[i] = false;
        }
 
        for (int i = 0; i < v; i++){
            if (visited[i] == false){
                dfs(i, stack, visited);
 			}
 		}

        while (stack.empty()==false){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

    }
	
	public void dfs(int v, Stack<Integer> stack, boolean visited[]){
        visited[v] = true;
        int neighbors[] = neighbors(v);
        Integer i;

        for (int j = 0; j < neighbors.length ; j++ ) {
        	i = neighbors[j];
        	if (!visited[i]){
                dfs(i, stack, visited);
            }
        }
        stack.push(new Integer(v));

    }
    
    @Override
    /**
     * returns an array of vertex IDs such that
     * each ID represents a vertex which is the
     * destination of the edge origination
     * from the argument
     */
	public int[] neighbors(int vertex){
		int j = 0;
		int y = 0;

		for (int i = 0; i < v; i++ ) {
			if (graph[vertex][i] == 1) {
				j++;
			}
		}
		int[] neighbors = new int[j];
		for (int i = 0; i < v; i++ ) {
			if (graph[vertex][i] == 1) {
				neighbors[y] = i;
				y++;
			}
		}
		return neighbors;
	}

}