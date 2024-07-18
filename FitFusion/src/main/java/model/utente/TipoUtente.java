package model.utente;

public enum TipoUtente {
	Utente("utente"), Istruttore("istruttore"), Amministratore("amministratore"), Ospite("ospite");
	private String nome;
	
	TipoUtente(String nome) {
		this.nome = nome;
	}
	
	public boolean equals(TipoUtente u1, TipoUtente u2) {
		return u1.nome.equals(u2.nome);
	}
	
	public static TipoUtente getTypeFromName(String name) {
		if (name == null) return TipoUtente.Ospite;
		else if (name.equals("utente")) return TipoUtente.Utente;
		else if (name.equals("istruttore")) return TipoUtente.Istruttore;
		else if (name.equals("amministratore")) return TipoUtente.Amministratore;
		else return TipoUtente.Ospite;
	}
}

