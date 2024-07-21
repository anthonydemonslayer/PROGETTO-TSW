package model.utente;

public enum TipoUtente {
	Utente("utente"), Istruttore("istruttore"), Amministratore("amministratore"), Ospite("ospite");
	private String nome;
	
	TipoUtente(String nome) {
		this.nome = nome;
	}
	
	public boolean equals(TipoUtente u1, TipoUtente u2) {
		return u1.nome.equalsIgnoreCase(u2.nome);
	}
	
	public static TipoUtente getTypeFromName(String name) {
		if (name == null) return TipoUtente.Ospite;
		else if (name.equalsIgnoreCase("utente")) return TipoUtente.Utente;
		else if (name.equalsIgnoreCase("istruttore")) return TipoUtente.Istruttore;
		else if (name.equalsIgnoreCase("amministratore")) return TipoUtente.Amministratore;
		else return TipoUtente.Ospite;
	}
}

