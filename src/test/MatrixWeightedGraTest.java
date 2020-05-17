package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Country;
import structures.MatrixWeightedGra;


class MatrixWeightedGraTest {

	private MatrixWeightedGra<Country> WG;
	
	public void setupScenary() {
		WG = new  MatrixWeightedGra<Country>(4, false);
	}
	
	@Test
	void WeightMatrixGraph() {
		setupScenary();
		if(WG == null) {
			fail();
		}
	}
	
	@Test
	void AddVertex() { //this also checks VertexSize method
		setupScenary();
		Country v1 = new Country("Colombia",1);
		WG.addVertex(v1);
	
		if(WG.getVertexSize() != 1) {
			fail();
		}
		
		Country v2 = new Country("Peru",1);
		WG.addVertex(v2);
		
		if(WG.getVertexSize() != 2) {
			fail();
		}
	}
	
	@Test
	void AddEdge() { //this also checks the areConnected method
		setupScenary();
		
		Country v1 = new Country("Peru",1);
		WG.addVertex(v1);
		Country v2 = new Country("Colombia",1);
		WG.addVertex(v2);
		
		WG.addEdge(v1, v2, 5);
		
		if(!WG.areConnected(v1, v2)) {
			fail();
		}
		
	}
	
	@Test
	void removeEdge() {
		setupScenary();
		
		Country v1 = new Country("Colombia",1);
		WG.addVertex(v1);
		Country v2 = new Country("Chile",1);
		WG.addVertex(v2);
		
		WG.addEdge(v1, v2, 5);
		
		WG.removeE(v1,  v2);
		
		if(WG.areConnected(v1, v2)) {
			fail();
		}
		
	}
	
	@Test
	void removeVertex() {
		setupScenary();
		Country v1 = new Country("Chile",1);
		WG.addVertex(v1);
		if(WG.getVertexSize() != 1) {
			fail();
		}
		Country v2 = new Country("Colombia",1);
		WG.addVertex(v2);
		
		WG.removeV(v1);
		WG.removeV(v2);
		
		if(WG.getVertexSize() != 0) {
			fail();
		}
	}
	
	@Test
	void isDirected() {
		setupScenary();
		if(WG.isDirected()) {
			fail();
		}
	}
}
