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

	public void desenharMarca(int linha, int coluna) {
		// TODO Auto-generated method stub
		
	}

	public boolean isMarcaXNaPosicao(int linha, int coluna) {
		// TODO Auto-generated method stub
		return true;
	}

}
