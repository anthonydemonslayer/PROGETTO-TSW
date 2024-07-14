package model.abbonamento;

import java.time.LocalDate;

public class AbbonamentoBean {
	int idAbbonamento;
	float costo;
	LocalDate dataAcquisto;
	int durata;
	int maxAccessiSettimanali;
	int idUtente;
	
	public int getIdAbbonamento() {
		return idAbbonamento;
	}
	public void setIdAbbonamento(int idAbbonamento) {
		this.idAbbonamento = idAbbonamento;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public LocalDate getDataAcquisto() {
		return dataAcquisto;
	}
	public void setDataAcquisto(LocalDate dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public int getMaxAccessiSettimanali() {
		return maxAccessiSettimanali;
	}
	public void setMaxAccessiSettimanali(int maxAccessiSettimanali) {
		this.maxAccessiSettimanali = maxAccessiSettimanali;
	}
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	@Override
	public String toString() {
		return "AbbonamentoBean [idAbbonamento=" + idAbbonamento + ", costo=" + costo + ", dataAcquisto=" + dataAcquisto
				+ ", durata=" + durata + ", maxAccessiSettimanali=" + maxAccessiSettimanali + ", idUtente=" + idUtente
				+ "]";
	}
	
	
	
}