package it.bookshelf.view;

import it.bookshelf.model.Libro;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AggiungiLibroController {
	
	@FXML
	private TextField titoloField;
	@FXML
	private TextField autoriField;
	@FXML
	private TextField genereField;
	@FXML
	private TextField editoreField;
	@FXML
	private TextField isbnField;
	@FXML
	private TextField edizioneField;
	@FXML
	private TextField copieTotaliField;
	
	private Stage dialogStage;
	private Libro libro;
	private boolean okClicked = false;
	
	@FXML
	private void initialize() {
		
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setLibro(Libro libro) {
		this.libro = libro;
		
		titoloField.setText(libro.getTitolo());
		autoriField.setText(libro.getAutori());
		genereField.setText(libro.getGenere());
		editoreField.setText(libro.getEditore());
		isbnField.setText(libro.getIsbn());
		edizioneField.setText(Integer.toString(libro.getEdizione()));
		copieTotaliField.setText(Integer.toString(libro.getCopieTotali()));
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			libro.setTitolo(titoloField.getText());
			libro.setAutori(autoriField.getText());
			libro.setGenere(genereField.getText());
			libro.setEditore(editoreField.getText());
			libro.setIsbn(isbnField.getText());
			libro.setEdizione(Integer.parseInt(edizioneField.getText()));
			libro.setCopieTotali(Integer.parseInt(copieTotaliField.getText()));
			libro.setCopieAttualmenteDisponibili(Integer.parseInt(copieTotaliField.getText()));
			
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
		
		if (titoloField.getText() == null || titoloField.getText().length() == 0) {
			errorMessage += "Il titolo deve avere almeno 1 carattere";
		}
		
		if (errorMessage.length() == 0) {
			return true;
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Campo invalido");
			alert.setHeaderText("Errore");
			alert.setContentText(errorMessage);
			
			alert.showAndWait();
			
			return false;
		}
	}
	
}