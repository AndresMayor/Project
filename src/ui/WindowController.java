package ui;

import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.City;
import model.Country;
import model.Manage;


public class WindowController {

    @FXML
    private Pane credits;

    @FXML
    private Pane instructions;

    @FXML
    private Pane EasyTravel;

    @FXML
    private Pane pointsOfInterest;

    @FXML
    private Pane unconnectedZones;

    @FXML
    private Pane PaneCalculateTime;
    
	@FXML
	private TextField tfPath1;
	@FXML
	private TextArea txtInfo1;
  
    
    
    
    
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
    
    
    
    
    
    
    
    ArrayList<Country> countries;
	ObservableList<String> names;
	Manage manage;
    
    
    public void initializable() {
    	
    	countries = new ArrayList();
    	
    	manage = new Manage();
    	cbDepartureCity.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				cbArrivalCity.getItems().clear();
				cbArrivalCity.getItems().addAll(names);
				cbArrivalCity.getItems().remove(newValue);
			}
		});
		
    }
    
	@FXML
	void SearchFileData(ActionEvent event) {
		names = FXCollections.observableArrayList();
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			tfPath1.setText(chooser.getSelectedFile().getAbsolutePath());
		}
	}
    
	
	@FXML
	void loadFileData(ActionEvent event) {
		try {
			String path = tfPath1.getText();
			countries = manage.load(path);
			String info = "";
			for (int i = 0; i < countries.size(); i++) {
				info += countries.get(i).toString() + "\n";
				names.add(countries.get(i).getName());
			}
			txtInfo1.setText(info);
			cbDepartureCity.getItems().addAll(names);
		//	cbDepartureCityTime.getItems().addAll(names);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "A ocurrido un error, intentalo de nuevo", "Ups!",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	@FXML
	void showMapCalculateTime(ActionEvent event) {
	
	}
	@FXML
	void showMapPointsOfInterest(ActionEvent event) {
		
	}
	@FXML
	void showMapTravel(ActionEvent event) {
		
	}
    
	@FXML
	void showMapUnconnectedZones(ActionEvent event) {
		
	}

    @FXML
    void ActivateCredits(ActionEvent event) {
    	credits.setVisible(true);
    	instructions.setVisible(false);
    	EasyTravel.setVisible(false);
    	pointsOfInterest.setVisible(false);
    	unconnectedZones.setVisible(false);
    	PaneCalculateTime.setVisible(false);
    }

    @FXML
    void ActivateInstructions(ActionEvent event) {
    	credits.setVisible(true);
    	instructions.setVisible(true);
    	EasyTravel.setVisible(false);
    	pointsOfInterest.setVisible(false);
    	unconnectedZones.setVisible(false);
    	PaneCalculateTime.setVisible(false);
    }
    
    @FXML
    void ActivateCalculateTime(ActionEvent event) {
    	credits.setVisible(false);
    	instructions.setVisible(false);
    	EasyTravel.setVisible(false);
    	pointsOfInterest.setVisible(false);
    	unconnectedZones.setVisible(false);
    	PaneCalculateTime.setVisible(true);
    }

    @FXML
    void ActivateEasyTravel(ActionEvent event) {
    	credits.setVisible(false);
    	instructions.setVisible(false);
    	EasyTravel.setVisible(true);
    	pointsOfInterest.setVisible(false);
    	unconnectedZones.setVisible(false);
    	PaneCalculateTime.setVisible(false);
    }

    @FXML
    void ActivatePointsOfInterest(ActionEvent event) {
    	credits.setVisible(false);
    	instructions.setVisible(false);
    	EasyTravel.setVisible(false);
    	pointsOfInterest.setVisible(true);
    	unconnectedZones.setVisible(false);
    	PaneCalculateTime.setVisible(false);
    }

    @FXML
    void ActivateUnconnectedZones(ActionEvent event) {
    	credits.setVisible(false);
    	instructions.setVisible(false);
    	EasyTravel.setVisible(false);
    	pointsOfInterest.setVisible(false);
    	unconnectedZones.setVisible(true);
    	PaneCalculateTime.setVisible(false);
    }

    @FXML
    void Exit(ActionEvent event) {
    	System.exit(0);
    }

}
