package it.bookshelf.view;

import it.bookshelf.model.Utente;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AggiungiUtenteController {
	
	@FXML
	private TextField nomeField;
	@FXML
	private TextField cognomeField;
	@FXML
	private TextField dataNascitaField;
	@FXML
	private TextField sessoField;
	@FXML
	private TextField telefonoField;
	@FXML
	private TextField codiceFiscaleField;
	
	private Stage dialogStage;
	private Utente utente;
	private boolean okClicked = false;
	
	@FXML
	private void initialize() {
		
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setUtente(Utente utente) {
		this.utente = utente;
		
		nomeField.setText(utente.getNome());
		cognomeField.setText(utente.getCognome());
		dataNascitaField.setText(utente.getDataNascita());
		sessoField.setText(utente.getSesso());
		telefonoField.setText(utente.getTelefono());
		codiceFiscaleField.setText(utente.getCodiceFiscale());
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			utente.setNome(nomeField.getText());
			utente.setCognome(cognomeField.getText());
			utente.setDataNascita(dataNascitaField.getText());
			utente.setSesso(sessoField.getText());
			utente.setTelefono(telefonoField.getText());
			utente.setCodiceFiscale(codiceFiscaleField.getText());
			
			okClicked = true;
			dialogStage.close();
		}
	}
	
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	public boolean isInputValid() {
		String errorMessage = "";
		
		if (nomeField.getText() == null || nomeField.getText().length() == 0) {
			errorMessage += "Non è stato inserito un nome!";
		}
		
		if (errorMessage.length() == 0) {
			return true;
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid fields");
			alert.setHeaderText("Correggi i campi scritti.");
			alert.setContentText(errorMessage);
			
			alert.showAndWait();
			
			return false;
		}
	}
}