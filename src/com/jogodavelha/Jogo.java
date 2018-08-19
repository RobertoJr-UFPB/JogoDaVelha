package com.jogodavelha;

public class Jogo {

	private Boolean proximaJogada;
	private Boolean[][] tabuleiro = new Boolean[3][3];
	private boolean iniciou;

	public boolean acabou() {
		return ganhouLinha() || ganhouColuna() || ganhouDiagonal();

	}

	private boolean ganhouDiagonal() {

		if (tabuleiro[1][1] != null && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
			return true;
		}
		if (tabuleiro[1][1] != null && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
			return true;
		}
		return false;
	}

	private boolean ganhouColuna() {
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[0][i] != null && tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
				return true;
			}
		}
		return false;
	}

	private boolean ganhouLinha() {
		for (int k = 0; k < 3; k++) {
			if (tabuleiro[k][0] != null && tabuleiro[k][0] == tabuleiro[k][1] && tabuleiro[k][1] == tabuleiro[k][2]) {
				return true;
			}
		}

		return false;
	}

	public void setMarcaPrimeiroJogadorX(boolean marcaPrimeiroJogadorX) {
		if (iniciou) {
			lancarExcecao();
		}
		this.proximaJogada = marcaPrimeiroJogadorX;
	}

	public boolean isMarcaPrimeiroJogadorX() {
		return proximaJogada;
	}

	public void desenharMarca(int linha, int coluna) {
		verificarLimites(linha, coluna);
		if (tabuleiro[linha][coluna] != null) {
			lancarExcecao();
		}
		if (proximaJogada == null) {
			lancarExcecao();
		}
		if(acabou()) {
			lancarExcecao();
		}
		tabuleiro[linha][coluna] = proximaJogada;
		proximaJogada = !proximaJogada;
		iniciou = true;
	}

	private void verificarLimites(int linha, int coluna) {
		if (coluna < 0 || coluna > 2) {
			lancarExcecao();
		}
		if (linha < 0 || linha > 2) {
			lancarExcecao();
		}

	}

	private void lancarExcecao() {
		throw new ExcecaoJogoDaVelha();
	}

	public Boolean isMarcaXNaPosicao(int linha, int coluna) {
		verificarLimites(linha, coluna);
		return tabuleiro[linha][coluna];
	}

}
