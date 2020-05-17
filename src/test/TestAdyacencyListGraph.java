package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.City;
import structures.AdjacencyList;



class TestAdyacencyListGraph<V> {

	private AdjacencyList<City> CITIES;
	
	
	
	public void setupScenary() {
		AdjacencyList<V> City = new AdjacencyList<V>(false);
	}
	
	
	@Test
	void WeightMatrixGraph() {
		setupScenary();
		if(CITIES == null) {
			fail();
		}
	}
	
	
	@Test
	void AddVertex() { //this also checks VertexSize method
		setupScenary();
		City v1 = new City("Medellin","Colombia",1);
		CITIES.addVertex(v1);
		
		if(CITIES.getVertexSize() != 1) {
			fail();
		}
		
		City v2 = new City("Cali","Colombia", 2);
		CITIES.addVertex(v2);
		
		if(CITIES.getVertexSize() != 2) {
			fail();
		}
	}
	
	@Test
	void AddEdge() { //this also checks the areConnected method
		setupScenary();
		
		City v1 = new City("Medellin","Colombia",1);
		CITIES.addVertex(v1);
		City v2 = new City("Cali","Colombia", 2);
		CITIES.addVertex(v2);
		
		CITIES.addEdge(v1, v2, 5);
		
		if(!CITIES.areConnected(v1, v2)) {
			fail();
		}
		
	}
	
	@Test
	void removeEdge() {
		setupScenary();
		
		City v1 = new City("Medellin","Colombia",1);
		CITIES.addVertex(v1);
		City v2 = new City("Cali","Colombia", 2);
		CITIES.addVertex(v2);
		
		CITIES.addEdge(v1, v2, 5);
		
		CITIES.removeE(v1,  v2);
		
		if(CITIES.areConnected(v1, v2)) {
			fail();
		}
		
	}
	
	@Test
	void removeVertex() {
		setupScenary();
		City v1 = new City("Medellin","Colombia",1);
		CITIES.addVertex(v1);
		if(CITIES.getVertexSize() != 1) {
			fail();
		}
		City v2 = new City("Cali","Colombia", 2);
		CITIES.addVertex(v2);
		
		CITIES.removeV(v1);
		CITIES.removeV(v2);
		
		if(CITIES.getVertexSize() != 0) {
			fail();
		}
	}
	
	@Test
	void isDirected() {
		setupScenary();
		if(CITIES.isDirected()) {
			fail();
		}
	}

}
