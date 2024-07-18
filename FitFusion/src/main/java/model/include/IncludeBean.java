package model.include;

public class IncludeBean {

	int idAbbonamento;
	String nomeCorso;
	
	
	public IncludeBean(int idAbbonamento, String nomeCorso) {
		super();
		this.idAbbonamento = idAbbonamento;
		this.nomeCorso = nomeCorso;
	}
	
	public int getIdAbbonamento() {
		return idAbbonamento;
	}
	public void setIdAbbonamento(int idAbbonamento) {
		this.idAbbonamento = idAbbonamento;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	
	@Override
	public String toString() {
		return "IncludeBean [idAbbonamento=" + idAbbonamento + ", nomeCorso=" + nomeCorso + "]";
	}
	
	
	
}
