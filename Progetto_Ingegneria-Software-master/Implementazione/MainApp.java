package it.bookshelf;

import java.io.IOException;

import it.bookshelf.model.Libro;
import it.bookshelf.model.Prestito;
import it.bookshelf.model.Utente;
import it.bookshelf.view.GestioniController;
import it.bookshelf.view.AggiungiLibroController;
import it.bookshelf.view.AggiungiPrestitoController;
import it.bookshelf.view.AggiungiUtenteController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private Stage primaryStage;
	private VBox viewPrincipale;
	
	private ObservableList<Libro> listaLibri = FXCollections.observableArrayList();
	private ObservableList<Utente> listaUtenti = FXCollections.observableArrayList();
	private ObservableList<Prestito> listaPrestiti = FXCollections.observableArrayList();
	
	// Togliere i commenti nelle linee 37-71 per avere all'avvio del programma dei libri, utenti e prestiti già inseriti nelle tabelle.
	
	public MainApp() {
		// Libri presenti all'avvio del programma
		Libro libro1 = new Libro("Il guardiano degli innocenti", "Andrzej Sapkowski", "Fantasy", "Nord", 1, "978-88-429-1659-8", 3);
		Libro libro2 = new Libro("Il profeta", "Khalil Gibran", "Narrativa", "Gherardo Casini", 1, "978-88-6410-007-4", 2);
		Libro libro3 = new Libro("Reti di calcolatori", "Andrew S. Tanenbaum, David J. Wetherall", "Didattico", "Pearson", 5, "978-88-919-0825-4", 2);
		Libro libro4 = new Libro("Algebra lineare e geometria analitica", "Alessandra Bernardi, Alessandro Gimigliano", "Didattico", "CittaStudi", 1, "978-88-251-7398-7", 6);
		Libro libro5 = new Libro("Inferno", "Dan Brown", "Narrativa", "Mondadori", 2, "978-88-04-64069-1", 4);
		Libro libro6 = new Libro("Il trono di spade - Il grande inverno", "George R.R. Martin", "Fantasy", "Oscar Mondadori", 3, "978-88-04-61635-1", 2);
		
		libro2.setCopieAttualmenteDisponibili(1);
		libro3.setCopieAttualmenteDisponibili(1);
		libro5.setCopieAttualmenteDisponibili(3);
		libro6.setCopieAttualmenteDisponibili(1);
		
		listaLibri.add(libro1);
		listaLibri.add(libro2);
		listaLibri.add(libro3);
		listaLibri.add(libro4);
		listaLibri.add(libro5);
		listaLibri.add(libro6);
		
		// Utenti presenti all'avvio del programma
		Utente utente1 = new Utente("Andrei Daniel", "Ivan", "05-02-1998", "Maschio", "3427536375", "VNINRD98B05Z129A");
		Utente utente2 = new Utente("Enrico", "Andrini", "27-04-1998", "Maschio", "3345054779", "MRCASD98Z24A156B");
		Utente utente3 = new Utente("Filippo", "Manfreda", "25-12-1998", "Maschio", "3387963214", "MGGTFT98B68B467F");
		
		listaUtenti.add(utente1);
		listaUtenti.add(utente2);
		listaUtenti.add(utente3);
		
		utente1.setNumeroLibriLetti(2);
		utente2.setNumeroLibriLetti(1);
		utente3.setNumeroLibriLetti(1);
		
		// Prestiti presenti all'avvio del programma
		listaPrestiti.add(new Prestito(utente1, libro3, 14));
		listaPrestiti.add(new Prestito(utente1, libro2, 10));
		listaPrestiti.add(new Prestito(utente2, libro5, 14));
		listaPrestiti.add(new Prestito(utente3, libro6, 20));
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("BookShelf");
		
		initGestioni();
	}
	
	public Stage getPrimaryStage() {
		return this.primaryStage;
	}
	
	public void initGestioni() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/GestioniStatistiche.fxml"));
			viewPrincipale = (VBox) loader.load();
			
			Scene scene = new Scene(viewPrincipale);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			GestioniController controller = loader.getController();
			controller.setMainApp(this);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public ObservableList<Libro> getListaLibri() {
		return this.listaLibri;
	}
	
	public ObservableList<Utente> getListaUtenti() {
		return this.listaUtenti;
	}
	
	public ObservableList<Prestito> getListaPrestiti() {
		return this.listaPrestiti;
	}
	
	// Aggiungi libro
	public boolean showAggiungiLibro(Libro libro) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/AggiungiLibro.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Aggiungi libro");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			AggiungiLibroController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setLibro(libro);
			
			dialogStage.showAndWait();
			
			return controller.isOkClicked();
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean showAggiungiUtente(Utente utente) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/AggiungiUtente.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Aggiungi utente");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			AggiungiUtenteController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setUtente(utente);
			
			dialogStage.showAndWait();
			
			return controller.isOkClicked();
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean showAggiungiPrestito(Prestito prestito) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/AggiungiPrestito.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Aggiungi prestito");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			AggiungiPrestitoController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setPrestito(prestito);
			controller.setMainApp(this);
			
			dialogStage.showAndWait();
			
			return controller.isOkClicked();
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}