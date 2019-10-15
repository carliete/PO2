package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import CbListas.TipoWeb;
import CbListas.TipoWebDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class TipoWebController implements Initializable {
	
	@FXML
	private ComboBox<TipoWeb> CbTipo;
	
	private ObservableList<TipoWeb> ObsTipos;
	
	@FXML
	private void Continuar() throws IOException {
		MaisInfoController.tipos = CbTipo.getSelectionModel().getSelectedItem();
		System.out.println(CbTipo.getSelectionModel().getSelectedItem());
		App.setRoot("MaisInfo");
	}

	public void CarregaTipo() {
		TipoWebDao dao = new TipoWebDao();
		ObsTipos = (ObservableList<TipoWeb>) dao.getAll();
		CbTipo.setItems(ObsTipos);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		DadosTipo();
		CarregaTipo();
		
	}
	
	private void DadosTipo() {
		TipoWeb tipo = new TipoWeb("1","Blog");
		new TipoWebDao().add(tipo);
	}
	

}
