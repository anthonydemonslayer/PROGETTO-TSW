package model.prenota;

import java.io.Serializable;

public class PrenotaBean implements Serializable{
	private static final long serialVersionUID = 1L;
	int idUtente;
	int idLezione;
	
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public int getIdLezione() {
		return idLezione;
	}
	public void setIdLezione(int idLezione) {
		this.idLezione = idLezione;
	}
	
	@Override
	public String toString() {
		return "PrenotaBean [idUtente=" + idUtente + ", idLezione=" + idLezione + "]";
	}
}
