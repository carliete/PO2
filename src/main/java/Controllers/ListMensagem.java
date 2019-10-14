package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Dao.FContatoDao;
import Proj.Po2.Entidades.FContato;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ListMensagem implements Initializable{
	
	@FXML
	private Label text;
	@FXML
	private ListView<FContato> listcont;
	
	public void updateList() {
		FContatoDao dao = new FContatoDao();
		listcont.setItems(null);
		listcont.setItems((ObservableList<FContato>) dao.getAll());
	};
	
	@FXML
	private void Voltar(ActionEvent action) throws IOException {
		App.setRoot("Contato");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateList();
		
	}
	
	@FXML
	private void delete() {
		try {
			new FContatoDao().delete(listcont.getSelectionModel().getSelectedItem());
			text.setText("Mensagem Apagada com Sucesso!");
		} catch (Exception e) {
			text.setText("Não foi possivel apagar a mensagem!");
		}
	}
	
}
