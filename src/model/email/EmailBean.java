package model.email;

public class EmailBean {

	private String indirizzo;
	private int idUtente;
	
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	@Override
	public String toString() {
		return "EmailBean [indirizzo=" + indirizzo + ", idUtente=" + idUtente + "]";
	}
	
	
	
}
