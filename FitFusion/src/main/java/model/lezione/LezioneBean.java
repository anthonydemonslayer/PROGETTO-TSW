package model.lezione;

import java.time.LocalDateTime;

public class LezioneBean {
	
	int idLezione;
	float costo;
	LocalDateTime dataOra;
	int durata;
	int numIscritti;
	int idUtente;
	int nomeCorso;
	
	public LezioneBean(int idLezione, float costo, LocalDateTime dataOra, int durata, int numIscritti, int idUtente,
			int nomeCorso) {
		super();
		this.idLezione = idLezione;
		this.costo = costo;
		this.dataOra = dataOra;
		this.durata = durata;
		this.numIscritti = numIscritti;
		this.idUtente = idUtente;
		this.nomeCorso = nomeCorso;
	}
	
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
	public void setDataOra(LocalDateTime dataOra) {
		this.dataOra = dataOra;
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
	public int getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(int nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	@Override
	public String toString() {
		return "LezioneBean [idLezione=" + idLezione + ", costo=" + costo + ", dataOra=" + dataOra + ", durata="
				+ durata + ", numIscritti=" + numIscritti + ", idUtente=" + idUtente + ", nomeCorso=" + nomeCorso + "]";
	}
	
	

}
