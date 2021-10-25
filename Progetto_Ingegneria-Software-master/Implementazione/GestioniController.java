package it.bookshelf.view;

import java.time.format.DateTimeFormatter;

import it.bookshelf.MainApp;
import it.bookshelf.model.Libro;
import it.bookshelf.model.Prestito;
import it.bookshelf.model.Utente;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class GestioniController {
	
	private MainApp mainApp;
	
	// Dati libri
	@FXML
	private TableView<Libro> libriTable;
	@FXML
	private TableColumn<Libro, String> colonnaTitolo;
	@FXML
	private TableColumn<Libro, String> colonnaAutori;
	@FXML
	private TableColumn<Libro, String> colonnaGenere;
	@FXML
	private TableColumn<Libro, String> colonnaEditore;
	@FXML
	private TableColumn<Libro, String> colonnaISBN;
	@FXML
	private TableColumn<Libro, Integer> colonnaEdizione;
	@FXML
	private TableColumn<Libro, Integer> colonnaCopieTotali;
	@FXML
	private TableColumn<Libro, Integer> colonnaCopieAttualmenteDisponibili;
	
	// Dati utenti
	@FXML
	private TableView<Utente> utentiTable;
	@FXML
	private TableColumn<Utente, String> colonnaNome;
	@FXML
	private TableColumn<Utente, String> colonnaCognome;
	@FXML
	private TableColumn<Utente, String> colonnaDataNascita;
	@FXML
	private TableColumn<Utente, String> colonnaSesso;
	@FXML
	private TableColumn<Utente, String> colonnaTelefono;
	@FXML
	private TableColumn<Utente, String> colonnaCodiceFiscale;
	@FXML
	private TableColumn<Utente, Integer> colonnaNumeroLibriLetti;
	@FXML
	private TableColumn<Utente, Integer> colonnaNumeroLibriRestituitiRitardo;
	@FXML
	private TableColumn<Utente, Integer> colonnaNumeroLibriRestituitiCattiveCondizioni;
	
	// Dati prestiti
	@FXML
	private TableView<Prestito> prestitiTable;
	@FXML
	private TableColumn<Prestito, String> colonnaNomeUtente;
	@FXML
	private TableColumn<Prestito, String> colonnaCognomeUtente;
	@FXML
	private TableColumn<Prestito, String> colonnaCodiceFiscaleUtente;
	@FXML
	private TableColumn<Prestito, String> colonnaTitoloLibro;
	@FXML
	private TableColumn<Prestito, String> colonnaISBNLibro;
	@FXML
	private TableColumn<Prestito, Integer> colonnaGiorniTotaliPrestito;
	@FXML
	private TableColumn<Prestito, String> colonnaDataInizio;
	@FXML
	private TableColumn<Prestito, String> colonnaDataFine;
	@FXML
	private TableColumn<Prestito, Boolean> colonnaPrestitoScaduto;
	@FXML
	private TableColumn<Prestito, Boolean> colonnaMultaGenerata;
	
	
	public GestioniController() {
		
	}
	
	@FXML
	private void initialize() {
		// Parte libri
		colonnaTitolo.setCellValueFactory(cellData -> cellData.getValue().titoloProperty());
		colonnaAutori.setCellValueFactory(cellData -> cellData.getValue().autoriProperty());
		colonnaGenere.setCellValueFactory(cellData -> cellData.getValue().genereProperty());
		colonnaEditore.setCellValueFactory(cellData -> cellData.getValue().editoreProperty());
		colonnaISBN.setCellValueFactory(cellData -> cellData.getValue().isbnProperty());
		colonnaEdizione.setCellValueFactory(cellData -> cellData.getValue().edizioneProperty().asObject());
		colonnaCopieTotali.setCellValueFactory(cellData -> cellData.getValue().copieTotaliProperty().asObject());
		colonnaCopieAttualmenteDisponibili.setCellValueFactory(cellData -> cellData.getValue().copieAttualmenteDisponibiliProperty().asObject());
		
		// Parte utenti
		colonnaNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colonnaCognome.setCellValueFactory(cellData -> cellData.getValue().cognomeProperty());
		colonnaDataNascita.setCellValueFactory(cellData -> cellData.getValue().dataNascitaProperty());
		colonnaSesso.setCellValueFactory(cellData -> cellData.getValue().sessoProperty());
		colonnaTelefono.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
		colonnaCodiceFiscale.setCellValueFactory(cellData -> cellData.getValue().codiceFiscaleProperty());
		colonnaNumeroLibriLetti.setCellValueFactory(cellData -> cellData.getValue().numeroLibriLettiProperty().asObject());
		colonnaNumeroLibriRestituitiRitardo.setCellValueFactory(cellData -> cellData.getValue().numeroLibriRestituitiRitardoProperty().asObject());
		colonnaNumeroLibriRestituitiCattiveCondizioni.setCellValueFactory(cellData -> cellData.getValue().numeroLibriRestituitiCattiveCondizioniProperty().asObject());
	
		// Parte prestiti
		colonnaNomeUtente.setCellValueFactory(cellData -> cellData.getValue().getUtente().nomeProperty());
		colonnaCognomeUtente.setCellValueFactory(cellData -> cellData.getValue().getUtente().cognomeProperty());
		colonnaCodiceFiscaleUtente.setCellValueFactory(cellData -> cellData.getValue().getUtente().codiceFiscaleProperty());
		colonnaTitoloLibro.setCellValueFactory(cellData -> cellData.getValue().getLibro().titoloProperty());
		colonnaISBNLibro.setCellValueFactory(cellData -> cellData.getValue().getLibro().isbnProperty());
		colonnaGiorniTotaliPrestito.setCellValueFactory(cellData -> cellData.getValue().giorniTotaliPrestitoProperty().asObject());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		colonnaDataInizio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDataInizio().format(formatter)));
		colonnaDataFine.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDataFine().format(formatter)));
		
		colonnaPrestitoScaduto.setCellValueFactory(cellData -> cellData.getValue().prestitoScadutoProperty());
		colonnaMultaGenerata.setCellValueFactory(cellData -> cellData.getValue().multaGenerataProperty());
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		libriTable.setItems(mainApp.getListaLibri());
		utentiTable.setItems(mainApp.getListaUtenti());
		prestitiTable.setItems(mainApp.getListaPrestiti());
	}
	
	// Metodo per inserire un nuovo libro
	@FXML
	private void handleNuovoLibro() {
		Libro tempLibro = new Libro(null, null, null, null, 0, null, 0);
		boolean okClicked = mainApp.showAggiungiLibro(tempLibro);
		if (okClicked) {
			mainApp.getListaLibri().add(tempLibro);
		}
	}
	
	// Metodo per eliminare un libro selezionato
	@FXML
	private void handleEliminaLibro() {
		int selectedIndex = libriTable.getSelectionModel().getSelectedIndex();
		boolean check = false;
		
		for (int i = 0; i < mainApp.getListaPrestiti().size(); i++) {
			if (libriTable.getSelectionModel().getSelectedItem().getIsbn().equals(mainApp.getListaPrestiti().get(i).getLibro().getIsbn())) {
				check = true;
			}
		}
		
		if (check) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Errore");
			alert.setHeaderText("Attenzione");
			alert.setContentText("Il libro e' in prestito a qualcuno.");
			alert.showAndWait();
		}
		else {
			ButtonType ok = new ButtonType("Ok");
			ButtonType annulla = new ButtonType("Annulla");
			
			Alert alert = new Alert(AlertType.NONE, "Attenzione!", ok, annulla);
			alert.setTitle("Richiesta di conferma");
			alert.setContentText("Sei sicuro di voler eliminare il libro selezionato?\n\n");
			alert.showAndWait().ifPresent(response -> {
				if (response == ok) {
					libriTable.getItems().remove(selectedIndex);
				}
				else if (response == annulla) {
					alert.close();
				}
			});
		}
	}
	
	// Metodo per inserire un nuovo utente
	@FXML
	private void handleNuovoUtente() {
		Utente tempUtente = new Utente(null, null, null, null, null, null);
		boolean okClicked = mainApp.showAggiungiUtente(tempUtente);
		if (okClicked) {
			mainApp.getListaUtenti().add(tempUtente);
		}
	}
	
	// Metodo per eliminare un utente selezionato
	@FXML
	private void handleEliminaUtente() {
		int selectedIndex = utentiTable.getSelectionModel().getSelectedIndex();
		boolean check = false;
		
		for (int i = 0; i < mainApp.getListaPrestiti().size(); i++) {
			if (utentiTable.getSelectionModel().getSelectedItem().getCodiceFiscale().equals(mainApp.getListaPrestiti().get(i).getUtente().getCodiceFiscale())) {
				check = true;
			}
		}
		
		if (check) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Errore");
			alert.setHeaderText("Attenzione");
			alert.setContentText("L'utente ha almeno un prestito attivo.");
			alert.showAndWait();
		}
		else {
			ButtonType ok = new ButtonType("Ok");
			ButtonType annulla = new ButtonType("Annulla");
			
			Alert alert = new Alert(AlertType.NONE, "Attenzione!", ok, annulla);
			alert.setTitle("Richiesta di conferma");
			alert.setContentText("Sei sicuro di voler eliminare l'utente selezionato?\n\n");
			alert.showAndWait().ifPresent(response -> {
				if (response == ok) {
					utentiTable.getItems().remove(selectedIndex);
				}
				else if (response == annulla) {
					alert.close();
				}
			});
		}
	}
	
	// Metodo per inserire un nuovo prestito
	@FXML
	private void handleNuovoPrestito() {
		Prestito tempPrestito = new Prestito(null, null, 0);
		
		boolean okClicked = mainApp.showAggiungiPrestito(tempPrestito);
		if (okClicked) {
			mainApp.getListaPrestiti().add(tempPrestito);
		}
	}
	
	// Metodo per eliminare un prestito selezionato
	@FXML
	private void handleEliminaPrestito() {
		int selectedIndex = prestitiTable.getSelectionModel().getSelectedIndex();
		
		ButtonType ok = new ButtonType("Ok");
		ButtonType annulla = new ButtonType("Annulla");
		
		Alert alert = new Alert(AlertType.NONE, "Attenzione!", ok, annulla);
		alert.setTitle("Richiesta di conferma");
		alert.setContentText("Sei sicuro di voler eliminare il prestito selezionato?\n\n");
		alert.showAndWait().ifPresent(response -> {
			if (response == ok) {
				prestitiTable.getItems().get(selectedIndex).getLibro().setCopieAttualmenteDisponibili(prestitiTable.getItems().get(selectedIndex).getLibro().getCopieAttualmenteDisponibili() + 1);
				prestitiTable.getItems().remove(selectedIndex);
			}
			else if (response == annulla) {
				alert.close();
			}
		});
	}
		
	@FXML
	private void handleRefreshTab() {
		libriTable.refresh();
	}
	
}