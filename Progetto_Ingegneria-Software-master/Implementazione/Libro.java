package it.bookshelf.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Libro {
	
	private final StringProperty titolo;
	private final StringProperty autori;
	private final StringProperty genere;
	private final StringProperty editore;
	private final IntegerProperty edizione;
	private final StringProperty isbn;
	private final IntegerProperty copieTotali;
	private final IntegerProperty copieAttualmenteDisponibili;
	
	public Libro(String titolo, String autori, String genere, String editore, int edizione, String isbn, int copieTotali) {
		this.titolo = new SimpleStringProperty(titolo);
		this.autori = new SimpleStringProperty(autori);
		this.genere = new SimpleStringProperty(genere);
		this.editore = new SimpleStringProperty(editore);
		this.edizione = new SimpleIntegerProperty(edizione);
		this.isbn = new SimpleStringProperty(isbn);
		this.copieTotali = new SimpleIntegerProperty(copieTotali);
		this.copieAttualmenteDisponibili = new SimpleIntegerProperty(copieTotali);
	}

	public String getTitolo() {
		return titolo.get();
	}

	public void setTitolo(String titolo) {
		this.titolo.set(titolo);;
	}
	
	public StringProperty titoloProperty() {
		return titolo;
	}

	public String getAutori() {
		return autori.get();
	}

	public void setAutori(String autori) {
		this.autori.set(autori);;
	}
	
	public StringProperty autoriProperty() {
		return autori;
	}

	public String getGenere() {
		return genere.get();
	}

	public void setGenere(String genere) {
		this.genere.set(genere);;
	}
	
	public StringProperty genereProperty() {
		return genere;
	}

	public String getEditore() {
		return editore.get();
	}

	public void setEditore(String editore) {
		this.editore.set(editore);;
	}
	
	public StringProperty editoreProperty() {
		return editore;
	}

	public int getEdizione() {
		return edizione.get();
	}

	public void setEdizione(int edizione) {
		this.edizione.set(edizione);
	}
	
	public IntegerProperty edizioneProperty() {
		return edizione;
	}

	public String getIsbn() {
		return isbn.get();
	}

	public void setIsbn(String isbn) {
		this.isbn.set(isbn);
	}
	
	public StringProperty isbnProperty() {
		return isbn;
	}

	public int getCopieTotali() {
		return copieTotali.get();
	}

	public void setCopieTotali(int copieTotali) {
		this.copieTotali.set(copieTotali);
	}
	
	public IntegerProperty copieTotaliProperty() {
		return copieTotali;
	}

	public int getCopieAttualmenteDisponibili() {
		return copieAttualmenteDisponibili.get();
	}

	public void setCopieAttualmenteDisponibili(int copieAttualmenteDisponibili) {
		this.copieAttualmenteDisponibili.set(copieAttualmenteDisponibili);
	}
	
	public IntegerProperty copieAttualmenteDisponibiliProperty() {
		return copieAttualmenteDisponibili;
	}
	
}