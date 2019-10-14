package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import java.util.ResourceBundle;

import Dao.MaisInfoDao;
import Proj.Po2.Entidades.MaisInfo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class MaisInfoController implements Initializable {

	ObservableList<CbListas.TipoWeb> TipoWebList;
	
	@FXML
	private Label Nome;
	@FXML
	private Label Dominio;

	// Tipo de webPágina
	
	@FXML
	private ComboBox<CbListas.TipoWeb> a;
	
	@FXML
	private void Continuar() throws IOException {
		App.setRoot("MaisInfo");
	}

	@FXML
	private void itens() {
		a.setItems(TipoWebList);
	}
	
	// Final do tipo de webPágina
	@FXML
	private void Salvar(ActionEvent action) throws IOException {
		MaisInfo info = new MaisInfo(Dominio.getText(), Nome.getText(), null, null, null, null);
		new MaisInfoDao().add(info);
		App.setRoot("fifth");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public ArrayList<String> TipoWebList () {
		ArrayList<String> tipos =  new ArrayList<String> ();
		tipos.add("Blog");
		tipos.add("Negocios");
		tipos.add("Comercio");
		tipos.add("Profissional");
		
		return tipos;
	}

}
