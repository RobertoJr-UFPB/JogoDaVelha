package com.jogodavelha;

public class Jogo {

	private boolean marcaPrimeiroJogadorX;

	public boolean acabou() {
		return false;
	}

	public void setMarcaPrimeiroJogadorX(boolean marcaPrimeiroJogadorX) {
		this.marcaPrimeiroJogadorX = marcaPrimeiroJogadorX;		
	}

	public boolean isMarcaPrimeiroJogadorX() {
		return marcaPrimeiroJogadorX;
	}

}
