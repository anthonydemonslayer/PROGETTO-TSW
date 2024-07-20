package model.lezione;

import java.sql.Date;
import java.time.LocalDate;

public class LezioneBean {
	
	int idLezione;
	float costo;
	LocalDate dataOra;
	int durata;
	int numIscritti;
	int idUtente;
	String nomeCorso;
	
	public int getIdLezione() {
		return idLezione;
	}
	public void setIdLezione(int idLezione) {
		this.idLezione = idLezione;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public LocalDate getDataOra() {
		return dataOra;
	}
	public void setDataOra(LocalDate data) {
		this.dataOra = data;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public int getNumIscritti() {
		return numIscritti;
	}
	public void setNumIscritti(int numIscritti) {
		this.numIscritti = numIscritti;
	}
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	
	public void aumentaNumeroIscritti() {
		numIscritti++;
	}
	
	public void diminuisciNumIscritti() {
		numIscritti--;
	}

	@Override
	public String toString() {
		return "LezioneBean [idLezione=" + idLezione + ", costo=" + costo + ", dataOra=" + dataOra + ", durata="
				+ durata + ", numIscritti=" + numIscritti + ", idUtente=" + idUtente + ", nomeCorso=" + nomeCorso + "]";
	}
	
	

}
