package model.lezione;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LezioneBean {
	
	int idLezione;
	float costo;
	LocalDateTime dataOra;
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
	public LocalDateTime getDataOra() {
		return dataOra;
	}
	public void setDataOra(LocalDateTime data) {
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
