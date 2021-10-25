package it.bookshelf.view;

import it.bookshelf.MainApp;
import it.bookshelf.model.Prestito;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AggiungiPrestitoController {
	
	private MainApp mainApp;
	
	@FXML
	private TextField codiceFiscaleUtenteField;
	@FXML
	private TextField isbnLibroField;
	@FXML
	private TextField giorniTotaliPrestitoField;
	
	private Stage dialogStage;
	private Prestito prestito;
	private boolean okClicked = false;
	
	@FXML
	private void initialize() {
		
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void setPrestito(Prestito prestito) {
		this.prestito = prestito;
		
		giorniTotaliPrestitoField.setText(Integer.toString(prestito.getGiorniTotaliPrestito()));
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			boolean utenteEsiste = false;
			boolean libroEsiste = false;
			
			for (int i = 0; !utenteEsiste && i < mainApp.getListaUtenti().size(); i++) {
				if (mainApp.getListaUtenti().get(i).getCodiceFiscale().equals(codiceFiscaleUtenteField.getText())) {
					prestito.setUtente(mainApp.getListaUtenti().get(i));
					mainApp.getListaUtenti().get(i).setNumeroLibriLetti(mainApp.getListaUtenti().get(i).getNumeroLibriLetti() + 1);
					utenteEsiste = true;
				}
			}
			
			for (int i = 0; !libroEsiste && i < mainApp.getListaLibri().size(); i++) {
				if (mainApp.getListaLibri().get(i).getIsbn().equals(isbnLibroField.getText())) {
					prestito.setLibro(mainApp.getListaLibri().get(i));
					mainApp.getListaLibri().get(i).setCopieAttualmenteDisponibili(mainApp.getListaLibri().get(i).getCopieAttualmenteDisponibili() - 1);
					libroEsiste = true;
				}
			}
			
			prestito.setGiorniTotaliPrestito(Integer.parseInt(giorniTotaliPrestitoField.getText()));
			
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
		boolean utenteEsiste = false;
		boolean libroEsiste = false;
		
		for (int i = 0; !utenteEsiste && i < mainApp.getListaUtenti().size(); i++) {
			if (mainApp.getListaUtenti().get(i).getCodiceFiscale().equals(codiceFiscaleUtenteField.getText())) {
				utenteEsiste = true;
			}
			
			if (!utenteEsiste && i == mainApp.getListaUtenti().size() - 1) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.initOwner(dialogStage);
				alert.setTitle("Campo invalido");
				alert.setHeaderText("Errore");
				alert.setContentText("E' stato inserito un utente inesistente.");
				alert.showAndWait();
				
				return false;
			}
		}
		
		for (int i = 0; !libroEsiste && i < mainApp.getListaLibri().size(); i++) {
			if (mainApp.getListaLibri().get(i).getIsbn().equals(isbnLibroField.getText())) {
				libroEsiste = true;
				
				if (mainApp.getListaLibri().get(i).getCopieAttualmenteDisponibili() == 0) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.initOwner(dialogStage);
					alert.setTitle("Errore");
					alert.setHeaderText("Attenzione");
					alert.setContentText("Il libro inserito non ha copie disponibili attualmente.");
					alert.showAndWait();
					
					return false;
				}
			}
			
			if (!libroEsiste && i == mainApp.getListaLibri().size() - 1) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.initOwner(dialogStage);
				alert.setTitle("Campo invalido");
				alert.setHeaderText("Errore");
				alert.setContentText("E' stato inserito un libro inesistente.");
				alert.showAndWait();
				
				return false;
			}
		}
		
		if (Integer.parseInt(giorniTotaliPrestitoField.getText()) <= 0) {
			errorMessage += "Il numero di giorni non è valido!";
		}
		
		if (errorMessage.length() == 0) {
			return true;
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Errore");
			alert.setHeaderText("Errore");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			
			return false;
		}
	}
	
}