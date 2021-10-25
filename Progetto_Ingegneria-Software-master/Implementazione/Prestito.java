package it.bookshelf.model;

import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Prestito {
	
	private Utente utente;
	private Libro libro;
	private final IntegerProperty giorniTotaliPrestito;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	private final BooleanProperty prestitoScaduto;
	private final BooleanProperty multaGenerata;
	
	public Prestito() {
		this(null, null, 0);
	}
	
	public Prestito(Utente utente, Libro libro, int giorniTotaliPrestito) {
		this.utente = utente;
		this.libro = libro;
		this.giorniTotaliPrestito = new SimpleIntegerProperty(giorniTotaliPrestito);
		this.dataInizio = LocalDate.now();
		this.dataFine = dataInizio.plusDays(giorniTotaliPrestito);
		this.prestitoScaduto = new SimpleBooleanProperty(false);
		this.multaGenerata = new SimpleBooleanProperty(false);
	}
	
	public Utente getUtente() {
		return this.utente;
	}
	
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	public Libro getLibro() {
		return this.libro;
	}
	
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public int getGiorniTotaliPrestito() {
		return giorniTotaliPrestito.get();
	}

	public void setGiorniTotaliPrestito(int giorniTotaliPrestito) {
		this.giorniTotaliPrestito.set(giorniTotaliPrestito);
		this.dataFine = dataInizio.plusDays(giorniTotaliPrestito);
	}
	
	public IntegerProperty giorniTotaliPrestitoProperty() {
		return giorniTotaliPrestito;
	}
	
	public LocalDate getDataInizio() {
		return this.dataInizio;
	}
	
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	
	public LocalDate getDataFine() {
		return this.dataFine;
	}
	
	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	
	public boolean getPrestitoScaduto() {
		return prestitoScaduto.get();
	}
	
	public void setPrestitoScaduto(boolean prestitoScaduto) {
		this.prestitoScaduto.set(prestitoScaduto);
	}
	
	public BooleanProperty prestitoScadutoProperty() {
		return prestitoScaduto;
	}
	
	public boolean getMultaGenerata() {
		return multaGenerata.get();
	}
	
	public void setMultaGenerata(boolean multaGenerata) {
		this.multaGenerata.set(multaGenerata);
	}
	
	public BooleanProperty multaGenerataProperty() {
		return multaGenerata;
	}
	
}