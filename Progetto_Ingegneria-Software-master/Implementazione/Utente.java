package it.bookshelf.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Utente {
	
	private final StringProperty nome;
	private final StringProperty cognome;
	private final StringProperty dataNascita;
	private final StringProperty sesso;
	private final StringProperty telefono;
	private final StringProperty codiceFiscale;
	private final IntegerProperty numeroLibriLetti;
	private final IntegerProperty numeroLibriRestituitiRitardo;
	private final IntegerProperty numeroLibriRestituitiCattiveCondizioni;
	
	public Utente(String nome, String cognome, String dataNascita, String sesso, String telefono, String codiceFiscale) {
		this.nome = new SimpleStringProperty(nome);
		this.cognome = new SimpleStringProperty(cognome);
		this.dataNascita = new SimpleStringProperty(dataNascita);
		this.sesso = new SimpleStringProperty(sesso);
		this.telefono = new SimpleStringProperty(telefono);
		this.codiceFiscale = new SimpleStringProperty(codiceFiscale);
		this.numeroLibriLetti = new SimpleIntegerProperty(0);
		this.numeroLibriRestituitiRitardo = new SimpleIntegerProperty(0);
		this.numeroLibriRestituitiCattiveCondizioni = new SimpleIntegerProperty(0);
	}

	public String getNome() {
		return nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}
	
	public StringProperty nomeProperty() {
		return nome;
	}
	
	public String getCognome() {
		return cognome.get();
	}

	public void setCognome(String cognome) {
		this.cognome.set(cognome);
	}
	
	public StringProperty cognomeProperty() {
		return cognome;
	}
	
	public String getDataNascita() {
		return dataNascita.get();
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita.set(dataNascita);
	}
	
	public StringProperty dataNascitaProperty() {
		return dataNascita;
	}
	
	public String getSesso() {
		return sesso.get();
	}

	public void setSesso(String sesso) {
		this.sesso.set(sesso);
	}
	
	public StringProperty sessoProperty() {
		return sesso;
	}
	
	public String getTelefono() {
		return telefono.get();
	}

	public void setTelefono(String telefono) {
		this.telefono.set(telefono);
	}
	
	public StringProperty telefonoProperty() {
		return telefono;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale.get();
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale.set(codiceFiscale);
	}
	
	public StringProperty codiceFiscaleProperty() {
		return codiceFiscale;
	}
	
	public int getNumeroLibriLetti() {
		return numeroLibriLetti.get();
	}

	public void setNumeroLibriLetti(int numeroLibriLetti) {
		this.numeroLibriLetti.set(numeroLibriLetti);
	}
	
	public IntegerProperty numeroLibriLettiProperty() {
		return numeroLibriLetti;
	}
	
	public int getNumeroLibriRestituitiRitardo() {
		return numeroLibriRestituitiRitardo.get();
	}

	public void setNumeroLibriRestituitiRitardo(int numeroLibriRestituitiRitardo) {
		this.numeroLibriRestituitiRitardo.set(numeroLibriRestituitiRitardo);
	}
	
	public IntegerProperty numeroLibriRestituitiRitardoProperty() {
		return numeroLibriRestituitiRitardo;
	}
	
	public int getNumeroLibriRestituitiCattiveCondizioni() {
		return numeroLibriRestituitiCattiveCondizioni.get();
	}

	public void setNumeroLibriRestituitiCattiveCondizioni(int numeroLibriRestituitiCattiveCondizioni) {
		this.numeroLibriRestituitiCattiveCondizioni.set(numeroLibriRestituitiCattiveCondizioni);
	}
	
	public IntegerProperty numeroLibriRestituitiCattiveCondizioniProperty() {
		return numeroLibriRestituitiCattiveCondizioni;
	}
	
}