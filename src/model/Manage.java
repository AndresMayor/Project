package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import structures.AdjacencyList;

public class Manage {
	
	private static AdjacencyList<Country> graphCountry;
	private static ArrayList<Country> countries;
	
	public Manage(ArrayList<Country> countries) {
		this.countries = countries;
	}
	
	/**
	 * @return the countries
	 */
	public static ArrayList<Country> getCountries() {
		return countries;
	}

	/**
	 * @param countries the countries to set
	 */
	public static void setCountries(ArrayList<Country> countries) {
		Manage.countries = countries;
	}

	public void addVertex() {
		graphCountry = new AdjacencyList<>(false);
		for (int i = 0; i < countries.size(); i++) {
			graphCountry.addVertex(countries.get(i));
		}
		String all = "Colombia-Peru,Colombia-Brasil,Argentina-Chile,Argentina-Costa Rica,Chile-Brasil,"+
				"Brasil-Costa Rica,Peru-Argentina";
		String[] relations = all.split(",");
		for (int i = 0; i < relations.length; i++) {
			String[] divide = relations[i].split("-");
			int one = getIdCountries(divide[0]);
			int two = getIdCountries(divide[1]);
			graphCountry.addEdge(countries.get(one), countries.get(two));
		}
	}
	
	/**
	 * @return the graphCountry
	 */
	public static AdjacencyList<Country> getGraphCountry() {
		return graphCountry;
	}

	/**
	 * @param graphCountry the graphCountry to set
	 */
	public static void setGraphCountry(AdjacencyList<Country> graphCountry) {
		Manage.graphCountry = graphCountry;
	}

	public int getIdCountries(String name) {
		int id = -1;
		for (int i = 0; i < countries.size(); i++) {
			if (countries.get(i).getName().equals(name))
				id = countries.get(i).getId();
		}
		return id;
	}
	
	
	
}
