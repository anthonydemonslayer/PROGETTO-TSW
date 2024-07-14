package model.utente;

public class UtenteBean {

	private int idUtente;
	private String nomeUtente;
	private String cognome;
	private String password;
	private String telefono;
	private tipoUtente tipoUtente;
	

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public tipoUtente getTipoUtente() {
		return tipoUtente;
	}

	public void setTipoUtente(tipoUtente tipoUtente) {
		this.tipoUtente = tipoUtente;
	}

	@Override
	public String toString() {
		return "UtenteBean [idUtente=" + idUtente + ", nomeUtente=" + nomeUtente + ", cognome=" + cognome
				+ ", password=" + password + ", telefono=" + telefono + ", tipoUtente=" + tipoUtente + "]";
	}

	
}
