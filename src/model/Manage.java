package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import structures.AdjacencyList;

public class Manage {
	
	private static AdjacencyList<Country> graphCountry;
	private static ArrayList<Country> countries;
	
	public ArrayList<Country> load(String path) {
		countries = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String sCurrentLine;
			int c = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] pieces = sCurrentLine.split(",");
				Country p = new Country(pieces[0],c);
				countries.add(p);
				c++;
			}
		} catch (IOException e) {
			// e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		addVertex(countries);
		return countries;
	}
	
	public void addVertex(ArrayList<Country> cities) {
		graphCountry = new AdjacencyList<>(false);
		for (int i = 0; i < cities.size(); i++) {
			graphCountry.addVertex(countries.get(i));
		}
		String all = "Colombia-Peru,Colombia-Brasil,Argentina-Chile,Argentina-Costa Rica,Chile-Brasil,"+
				"Brasil-Costa Rica,Peru-Costa Rica,Peru-Argentina";
		
		
		String[] relations = all.split(",");
		for (int i = 0; i < relations.length; i++) {
			String[] divide = relations[i].split("-");
			int one = getIdCountries(divide[0]);
			int two = getIdCountries(divide[1]);
			graphCountry.addEdge(countries.get(one), countries.get(two));
		}
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
