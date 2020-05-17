package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import structures.*;

public class Country {
	
	private String name;
	private int id;
	private static AdjacencyList<City> graphCity;
	private static ArrayList<City> cities;
	
	public Country(String name, int id) {
		this.name = name;
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the cities
	 */
	public static ArrayList<City> getCities() {
		return cities;
	}

	/**
	 * @param cities the cities to set
	 */
	public static void setCities(ArrayList<City> cities) {
		Country.cities = cities;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the countryIn
	 */

	@Override
	public String toString() {
		return "Name: "+name+", Id: "+id;
	}
	
	public ArrayList<City> load(String path) {
		cities = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String sCurrentLine;
			int c = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] pieces = sCurrentLine.split(",");
				City p = new City(pieces[0],pieces[1] , c);
				cities.add(p);
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
		addVertex(cities, name);
		return cities;
	}

	public void addVertex(ArrayList<City> cities, String nameCountry) {
		graphCity = new AdjacencyList<>(false);
		for (int i = 0; i < cities.size(); i++) {
			graphCity.addVertex(cities.get(i));
		}
		String all = "";
		if(nameCountry.equals("Colombia")) {
			all = "Cali-Barranquilla,Cali-Medellin,Cali-Bogota,Barranquilla-Bogota,Barranquilla-Medellin,"+
			"Barranquilla-Cartagena,Medellin-Bogota,Medellin-Cartagena";
		}else if(nameCountry.equals("Argentina")) {
			all = "Buenos aires-Cordoba,Buenos aires-La plata,Buenos aires-San miguel de tucuman,Cordoba-La plata,"+
			"Rosario-Cordoba,Rosario-San miguel de tucuman,Rosario-La plata,";
		}else if(nameCountry.equals("Chile")) {
			all = "Santiago-Gran valparaiso,Santiago-Antofagasta,Santiago-Gran la serena,Gran valparaiso-Gran concepcion,"+
			"Gran valparaiso-Antofagasta,Gran concepcion-Gran la serena";
		}else if(nameCountry.equals("Peru")) {
			all = "Iquitos-Lima,Iquitos-Arequipa,Iquitos-Puno,Cuzco-Lima,Cuzco-Puno,Arequipa-Puno,Arequipa-Lima,Puno-Lima";
		}else if(nameCountry.equals("Brasil")) {
			all = "Sao paulo-Rio de janeiro,Sao paulo-Brasilia,Sao paulo-Belo horizonte,Brasilia-Belo horizonte,"+
			"Brasilia-Salvador de bahia,Brasilia-Rio de janeiro";
		}else if(nameCountry.equals("Costa Rica")) {
			all = "Heredia-Cartago,Heredia-Guanacaste,Heredia-Alajuela,Heredia-San jose,Cartago-Guanacaste"+
			"San jose-Alajuela,San jose-Cartago";
		}
		
		String[] relations = all.split(",");
		for (int i = 0; i < relations.length; i++) {
			String[] divide = relations[i].split("-");
			int one = getIdCities(divide[0]);
			int two = getIdCities(divide[1]);
			graphCity.addEdge(cities.get(one), cities.get(two));
		}
	}

	public int getIdCities(String name) {
		int id = -1;
		for (int i = 0; i < cities.size(); i++) {
			if (cities.get(i).getName().equals(name))
				id = cities.get(i).getId();
		}
		return id;
	}
	
}
