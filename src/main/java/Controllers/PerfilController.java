package Controllers;

import java.io.IOException;

import Proj.Po2.Entidades.Perfil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PerfilController {

	@FXML
	private Label nomeUsuario;

	@FXML
	private Label nomeUsuario2;

	@FXML
	private TextField nomeText;

	@FXML
	private TextField sobrenomeText;
	@FXML
	private TextField Cpf;
	@FXML
	private TextField NomeExibi;
	@FXML
	private DatePicker Nasci;
	@FXML
	private TextField Sexo;

	@FXML
	private void SxVoltar(ActionEvent action) throws IOException {
		App.setRoot("fifth");
	}

	@FXML
	private void Ssalvar(ActionEvent action) throws IOException {
		
		Perfil perfil = new Perfil(Cpf.getText(),nomeText.getText(), sobrenomeText.getText(),  NomeExibi.getText(), Nasci.getPromptText(), Sexo.getText());
		new Dao.PerfilDao().add(perfil);
		
		String nome = nomeText.getText();
		String sobrenome = sobrenomeText.getText();

		nomeUsuario.setText(nome + " " + sobrenome);
		nomeUsuario2.setText("@" + nome + sobrenome);
	}

}
