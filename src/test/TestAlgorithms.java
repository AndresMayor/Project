package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Country;
import structures.AdjacencyList;
import structures.Algorithms;
import structures.MatrixWeightedGra;

class TestAlgorithms {

	private MatrixWeightedGra<Country> WG;
	private AdjacencyList<Country> AG;
	
	
	public void setupScenary() {
		WG = new  MatrixWeightedGra<Country>(4, false);
		AG = new AdjacencyList<Country>(false);
	}
	
	@Test
	void DFS() {
		setupScenary();
		Country v1 = new Country("Colombia", 1);
		AG.addVertex(v1);
		WG.addVertex(v1);
		Country v2 = new Country("Peru",2);
		AG.addVertex(v2);
		WG.addVertex(v2);
		Country v3 = new Country("Brasil", 3);
		AG.addVertex(v3);
		WG.addVertex(v3);
		
		AG.addEdge(v1, v2, 3);
		AG.addEdge(v2, v3, 4);
		AG.addEdge(v3, v1, 1);
		
		List<Country> x = Algorithms.dfs(WG, v1);
		List<Country> y = Algorithms.dfs(AG, v1);
		if(x.size() != 3 && y.size() != 3) {
			fail();
		}
	}

	@Test
	void BFS() {
		setupScenary();
		Country v1 = new Country("Colombia", 1);
		AG.addVertex(v1);
		WG.addVertex(v1);
		Country v2 = new Country("Peru",2);
		AG.addVertex(v2);
		WG.addVertex(v2);
		Country v3 = new Country("Brasil", 3);
		AG.addVertex(v3);
		WG.addVertex(v3);
		
		AG.addEdge(v1, v2, 3);
		AG.addEdge(v2, v3, 4);
		AG.addEdge(v3, v1, 1);
		
		List<Country> x = Algorithms.bfs(WG, v1);
		List<Country> y = Algorithms.bfs(AG, v1);
		if(x.size() != 3 && y.size() != 3) {
			fail();
		}
	}
	

	@Test
	void Dijkstra() {
		setupScenary();
		Country v1 = new Country("Colombia", 1);
		AG.addVertex(v1);
		WG.addVertex(v1);
		Country v2 = new Country("Peru",2);
		AG.addVertex(v2);
		WG.addVertex(v2);
		Country v3 = new Country("Brasil", 3);
		AG.addVertex(v3);
		WG.addVertex(v3);
		
		AG.addEdge(v1, v2, 3);
		AG.addEdge(v2, v3, 4);
		AG.addEdge(v3, v1, 1);
		
		int[] x = Algorithms.dijkstra(0,AG.getWeight());
		int[] y = Algorithms.dijkstra(0,AG.getWeight());
		if(x[0] != 0 && y[0] != 0) {
			fail();
		}
	}
	
	
	
	@Test
	void FloydWarshall() {
		setupScenary();
		Country v1 = new Country("Colombia", 1);
		AG.addVertex(v1);
		WG.addVertex(v1);
		Country v2 = new Country("Peru",2);
		AG.addVertex(v2);
		WG.addVertex(v2);
		Country v3 = new Country("Brasil", 3);
		AG.addVertex(v3);
		WG.addVertex(v3);
		
		AG.addEdge(v1, v2, 3);
		AG.addEdge(v2, v3, 4);
		AG.addEdge(v3, v1, 1);
		
		int[][] x = Algorithms.floydWarshall(AG.getWeight());
		int[][] y = Algorithms.floydWarshall(AG.getWeight());
		for(int i=0; i<3; i++) {
			if(x[i][i] != 0 && y[i][i] != 0) {
				fail();
			}
		}
	}
}
