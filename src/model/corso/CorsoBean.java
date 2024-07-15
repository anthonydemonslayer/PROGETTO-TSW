package model.corso;

public class CorsoBean {
	String nomeCorso;
	String descrizione;
	
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	@Override
	public String toString() {
		return "CorsoBean [nomeCorso=" + nomeCorso + ", descrizione=" + descrizione + "]";
	}
	
	

}
