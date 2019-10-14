package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Dao.PaginasDao;
import Proj.Po2.Entidades.Paginas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListPag implements Initializable {


	@FXML
	private ListView<Paginas> Lista;

	@FXML
	private void delete() {
		new PaginasDao().delete(Lista.getSelectionModel().getSelectedItem());
	}
	
	@FXML
	private void Voltar(ActionEvent action) throws IOException {
		App.setRoot("fifth");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	public void updateList() {
		PaginasDao dao = new PaginasDao();
		Lista.setItems(null);
		Lista.setItems((ObservableList<Paginas>) dao.getAll());
	}
	}

