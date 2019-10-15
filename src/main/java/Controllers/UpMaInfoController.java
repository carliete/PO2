package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import CbListas.Area;
import CbListas.Idioma;
import CbListas.Privacidade;
import CbListas.TipoWeb;
import Controllers.MaisInfoController;
import Dao.MaisInfoDao;
import Proj.Po2.Entidades.MaisInfo;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class UpMaInfoController implements Initializable{

	@FXML
	private ComboBox<Area> CbArea;

	@FXML
	private ComboBox<Privacidade> CBPrivacidade;

	@FXML
	private ComboBox<Idioma> CBIdioma;

	@FXML
	private ComboBox<TipoWeb> CBTipoWbSite;

	@FXML
	private TextField TFNome;

	@FXML
	private void Salvar() {
		MaisInfoDao dao = new MaisInfoDao();
		ObservableList<MaisInfo> infos = (ObservableList<MaisInfo>) dao.getAll();
		
		
	}

	@FXML
	private void Voltar() throws IOException {
		App.setRoot("ListPagin");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CbArea.setItems(MaisInfoController.ObsArea);
		CBIdioma.setItems(MaisInfoController.ObsIdi);
		CBPrivacidade.setItems(MaisInfoController.ObsPriv);
		CBTipoWbSite.setItems(TipoWebController.ObsTipos);
	}
	
}
