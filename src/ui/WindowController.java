package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.City;
import model.Country;
import model.Manage;
import structures.AdjacencyList;


public class WindowController {

    @FXML
    private Pane credits;

    @FXML
    private Pane instructions;
	@FXML
	private TextField tfPath1;
	@FXML
	private TextArea txtInfo1;
  
	@FXML
    private Label ruta;

    @FXML
    private Button btRuta;
    @FXML
    private TextField txInicial;
    
    
	@FXML
	private Pane paneConfiguration;
    @FXML
	private Label lbMessage;
    @FXML
	private TextField tfVelocity;
    @FXML
	private ComboBox<String> cbDepartureCityTime;
    @FXML
	private ComboBox<String> cbArrivalCityTime;
    @FXML
   	private ComboBox<String> cbDepartureCity;
    @FXML
   	private ComboBox<String> cbArrivalCity;
    @FXML
   	private TextField tfDistance;
    @FXML
   	private TextField tfTime;
    @FXML
    private Pane EasyTravel;
    @FXML
    private MenuItem cdArgentina;

    @FXML
    private MenuItem cdColombia;

    @FXML
    private MenuItem cdCosta;


    @FXML
    private Button btPais;

    @FXML
    private MenuItem cdPeru;

    @FXML
    private MenuItem cdBrasil;

    @FXML
    private MenuItem cdChile;
    
    @FXML
    private MenuButton mb;
    
    ArrayList<Country> countries;
    ArrayList<City> cities;
	ObservableList<String> names;
	Manage manage;
    
    
	public void initialize() {
		Country p1 = new Country("Colombia",0);
		Country p2 = new Country("Argentina",1);
		Country p3 = new Country("Chile",2);
		Country p4 = new Country("Peru",3);
		Country p5 = new Country("Brasil",4);
		Country p6 = new Country("Costa Rica",5);
		
		cities = new ArrayList<>();
		City c1 = new City("", "", 0);
		City c2 = new City("", "", 1);
		City c3 = new City("", "", 2);
		City c4 = new City("", "", 3);
		City c5 = new City("", "", 4);
		cities.add(c1);
		cities.add(c2);
		cities.add(c3);
		cities.add(c4);
		cities.add(c5);
		countries = new ArrayList<>();
		countries.add(p1);
		countries.add(p2);
		countries.add(p3);
		countries.add(p4);
		countries.add(p5);
		countries.add(p6);
		manage = new Manage(countries);
		names = FXCollections.observableArrayList();
		
		
		
	}
	
	@FXML
	public void loadData(ActionEvent event) {
		manage.addVertex();
		String info = "";
		for (int i = 0; i < countries.size(); i++) {
			info += countries.get(i).toString() + "\n";
			names.add(countries.get(i).getName());
		}
		txtInfo1.setText(info);
	}
	
	@FXML
	public void loadCitiesColombia(ActionEvent event) {
		City c1 = new City("Cali", "Colombia", 0);
		City c2 = new City("Bogota", "Colombia", 1);
		City c3 = new City("Medellin", "Colombia", 2);
		City c4 = new City("Cartagena", "Colombia", 3);
		City c5 = new City("Barranquilla", "Colombia", 4);
		cities.set(0, c1);
		cities.set(1, c2);
		cities.set(2, c3);
		cities.set(3, c4);
		cities.set(4, c5);
		countries.get(0).addVertex(cities, "Colombia");
		String info = "";
		for (int i = 0; i < cities.size(); i++) {
			info += cities.get(i).toString() + "\n";
			names.add(cities.get(i).getName());
		}
		txtInfo1.setText(info);
	}
	
	@FXML
	public void loadCitiesArgentina(ActionEvent event) {
		City c1 = new City("Buenos aires", "Argentina", 0);
		City c2 = new City("Cordoba", "Argentina", 1);
		City c3 = new City("Rosario", "Argentina", 2);
		City c4 = new City("La plata", "Argentina", 3);
		City c5 = new City("San miguel de tucuman", "Argentina", 4);
		cities.set(0, c1);
		cities.set(1, c2);
		cities.set(2, c3);
		cities.set(3, c4);
		cities.set(4, c5);
		countries.get(1).addVertex(cities, "Argentina");
		String info = "";
		for (int i = 0; i < cities.size(); i++) {
			info += cities.get(i).toString() + "\n";
			names.add(cities.get(i).getName());
		}
		txtInfo1.setText(info);
	}
	
	@FXML
	public void loadCitiesChile(ActionEvent event) {
		City c1 = new City("Santiago", "Chile", 0);
		City c2 = new City("Gran valparaiso", "Chile", 1);
		City c3 = new City("Gran concepcion", "Chile", 2);
		City c4 = new City("Gran la serena", "Chile", 3);
		City c5 = new City("Antofagasta", "Chile", 4);
		cities.set(0, c1);
		cities.set(1, c2);
		cities.set(2, c3);
		cities.set(3, c4);
		cities.set(4, c5);
		countries.get(2).addVertex(cities, "Chile");
		String info = "";
		for (int i = 0; i < cities.size(); i++) {
			info += cities.get(i).toString() + "\n";
			names.add(cities.get(i).getName());
		}
		txtInfo1.setText(info);
	}
	
	@FXML
	public void loadCitiesPeru(ActionEvent event) {
		City c1 = new City("Lima", "Peru", 0);
		City c2 = new City("Cuzco", "Peru", 1);
		City c3 = new City("Puno", "Peru", 2);
		City c4 = new City("Arequipa", "Peru", 3);
		City c5 = new City("Iquitos", "Peru", 4);
		cities.set(0, c1);
		cities.set(1, c2);
		cities.set(2, c3);
		cities.set(3, c4);
		cities.set(4, c5);
		countries.get(3).addVertex(cities, "Peru");
		String info = "";
		for (int i = 0; i < cities.size(); i++) {
			info += cities.get(i).toString() + "\n";
			names.add(cities.get(i).getName());
		}
		txtInfo1.setText(info);
	}
	
	@FXML
	public void loadCitiesBrasil(ActionEvent event) {
		City c1 = new City("Sao paulo", "Brasil", 0);
		City c2 = new City("Rio de janeiro", "Brasil", 1);
		City c3 = new City("Brasilia", "Brasil", 2);
		City c4 = new City("Bello horizonte", "Brasil", 3);
		City c5 = new City("Salvador de bahia", "Brasil", 4);
		cities.set(0, c1);
		cities.set(1, c2);
		cities.set(2, c3);
		cities.set(3, c4);
		cities.set(4, c5);
		countries.get(4).addVertex(cities, "Brasil");
		String info = "";
		for (int i = 0; i < cities.size(); i++) {
			info += cities.get(i).toString() + "\n";
			names.add(cities.get(i).getName());
		}
		txtInfo1.setText(info);
	}
	
	@FXML
	public void loadCitiesCosta(ActionEvent event) {
		City c1 = new City("Heredia", "Costa Rica", 0);
		City c2 = new City("San jose", "Costa Rica", 1);
		City c3 = new City("Guanacaste", "Costa Rica", 2);
		City c4 = new City("Cartago", "Costa Rica", 3);
		City c5 = new City("Alajuela", "Costa Rica", 4);
		cities.set(0, c1);
		cities.set(1, c2);
		cities.set(2, c3);
		cities.set(3, c4);
		cities.set(4, c5);
		countries.get(5).addVertex(cities, "Costa Rica");
		String info = "";
		for (int i = 0; i < cities.size(); i++) {
			info += cities.get(i).toString() + "\n";
			names.add(cities.get(i).getName());
		}
		txtInfo1.setText(info);
	}
	
    @FXML
    void showMapTravel(ActionEvent event) {
    	ruta.setText("");
    	String country = txInicial.getText();
    	Country c = null;
    	if(country.equals("Colombia")) {
    		c=countries.get(0);
    	}else if(country.equals("Argentina")) {
    		c=countries.get(1);
    	}else if(country.equals("Chile")) {
    		c=countries.get(2);
    	}else if(country.equals("Peru")) {
    		c=countries.get(3);
    	}else if(country.equals("Brasil")) {
    		c=countries.get(4);
    	}else if(country.equals("Costa Rica")) {
    		c=countries.get(5);
    	}
    	AdjacencyList<Country> grafo = manage.getGraphCountry();
    	List<Country> resultado = grafo.bfs(c);
    	String ruta2 = "";
    	for (int i = 0; i < resultado.size(); i++) {
			ruta2 += resultado.get(i).getName() + ", ";
		}
    	ruta.setText(ruta2);
    	
//    	txInicial.setText("");
    }
    
    @FXML
	void salir(ActionEvent event) {
		System.exit(0);
	}
    
    @FXML
	void ActivateInstructions(ActionEvent event) {
		
	}
    
    @FXML
	void ActivateCredits(ActionEvent event) {
//		credits.setVisible(true);
//		instructions.setVisible(false);
//		EasyTravel.setVisible(false);
//		pointsOfInterest.setVisible(false);
//		unconnectedZones.setVisible(false);
//		PaneCalculateTime.setVisible(false);
//		paneConfiguration.setVisible(false);
	}
}