package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import CbListas.Area;
import CbListas.AreaDao;
import CbListas.Idioma;
import CbListas.IdiomaDao;
import CbListas.PrivacDao;
import CbListas.Privacidade;
import CbListas.TipoWeb;
import Dao.MaisInfoDao;
import Proj.Po2.Entidades.MaisInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MaisInfoController implements Initializable {

	@FXML
	private TextField Nome;
	@FXML
	private TextField Dominio;
	@FXML
	private ComboBox<Area> area1;
	@FXML
	private ComboBox<Privacidade> privacidade;
	@FXML
	private ComboBox<Idioma> idioma;

	static TipoWeb tipos;

	private ObservableList<Area> ObsArea;
	private ObservableList<Privacidade> ObsPriv;
	private ObservableList<Idioma> ObsIdi;

	@FXML
	private void Salvar(ActionEvent action) throws IOException {
		MaisInfo mais = new MaisInfo(Dominio.getText(), Nome.getText(),
				area1.getSelectionModel().getSelectedItem().getCod(),
				privacidade.getSelectionModel().getSelectedItem().getCod(),
				idioma.getSelectionModel().getSelectedItem().getCod(), tipos.getCod());
		new MaisInfoDao().add(mais);
		App.setRoot("fifth");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CarregaArea();
		CarregaIdioma();
		CarregaPriva();

		AreaA();
		CarregaPriv();
		CarregaIdi();
	}

	private void AreaA() {
		AreaDao dao = new AreaDao();
		ObsArea = (ObservableList<Area>) dao.getAll();
		area1.setItems(ObsArea);

	}

	private void CarregaPriv() {
		PrivacDao dao = new PrivacDao();
		ObsPriv = (ObservableList<Privacidade>) dao.getAll();
		privacidade.setItems(ObsPriv);

	}

	private void CarregaIdi() {
		IdiomaDao dao = new IdiomaDao();
		ObsIdi = (ObservableList<Idioma>) dao.getAll();
		idioma.setItems(ObsIdi);
	}

	private void CarregaIdioma() {
		Idioma idiom = new Idioma("1", "Ingles");
		Idioma idiom1 = new Idioma("2", "Portugues");
		Idioma idiom2 = new Idioma("3", "Espanhol");
		new IdiomaDao().add(idiom);
		new IdiomaDao().add(idiom1);
		new IdiomaDao().add(idiom2);
	}

	private void CarregaArea() {
		Area area = new Area("1", "Comidas");
		Area area1 = new Area("2", "Desenho");
		Area area2 = new Area("3", "Anime");
		new AreaDao().add(area);
		new AreaDao().add(area1);
		new AreaDao().add(area2);
	}

	private void CarregaPriva() {
		Privacidade priva = new Privacidade("1", "Publico");
		Privacidade priva2 = new Privacidade("2", "Privado");
		Privacidade priva3 = new Privacidade("3", "Oculto");
		new PrivacDao().add(priva);
		new PrivacDao().add(priva2);
		new PrivacDao().add(priva3);
	}
}
