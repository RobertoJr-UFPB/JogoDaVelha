package com.jogodavelha;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JogoTest {
	private Jogo jogo;
	
	@Before
	public void novoJogo() {
		jogo = new Jogo();
	}
	@Test
	public void criarJogo() {
		assertFalse("O jogo iniciou finalizado", jogo.acabou());
	}
	@Test
	public void definirPrimeiroJogador() {
		jogo.setMarcaPrimeiroJogadorX(true);
		assertTrue("O primeiro jogador escolheu bola",jogo.isMarcaPrimeiroJogadorX());//true
	}
	@Test
	public void definirPrimeiroJogadorDeNovo() {
		jogo.setMarcaPrimeiroJogadorX(true);//X
		jogo.setMarcaPrimeiroJogadorX(false);//O
		assertFalse("O primeiro jogador escolheu bola",jogo.isMarcaPrimeiroJogadorX());//true
	}
	@Test
	public void desenharPrimeiraMarca() {
		jogo.setMarcaPrimeiroJogadorX(true);//X
		jogo.desenharMarca(1,0);//X
		assertTrue(jogo.isMarcaXNaPosicao(1,0));
	}
	@Test(expected=ExcecaoJogoDaVelha.class)
	public void desenharPrimeiraMarcaEmCelulaOcupada() {
		jogo.setMarcaPrimeiroJogadorX(true);//X
		jogo.desenharMarca(1,0);//X
		jogo.desenharMarca(1,0);//X
	}
	@Test(expected=ExcecaoJogoDaVelha.class)
	public void desenharEmColunaErrada() {
		jogo.setMarcaPrimeiroJogadorX(false);//O
		jogo.desenharMarca(1,4);//linha , coluna
		
	}
	@Test
	public void lerDeCelulaDesocupada() {
		jogo.setMarcaPrimeiroJogadorX(false);//O
		assertNull(jogo.isMarcaXNaPosicao(0, 0));//linha , coluna
		
	}
	@Test(expected=ExcecaoJogoDaVelha.class)
	public void desenharEmLinhaErrada() {
		jogo.setMarcaPrimeiroJogadorX(false);//O
		jogo.desenharMarca(-1,4);//linha , coluna
		
	}
	@Test(expected=ExcecaoJogoDaVelha.class)
	public void lerMarcaDeUmaColunaErrada() {
		jogo.setMarcaPrimeiroJogadorX(false);//O
		jogo.isMarcaXNaPosicao(0, 3);
		
	}
	@Test(expected=ExcecaoJogoDaVelha.class)
	public void lerMarcaDeUmaLinhaErrada() {
		jogo.setMarcaPrimeiroJogadorX(false);//O
		jogo.isMarcaXNaPosicao(-1, 0);
		
	}
	@Test(expected=ExcecaoJogoDaVelha.class)
	public void definirPrimeiroJogadorAposInicioDoJogo() {
		jogo.setMarcaPrimeiroJogadorX(true);//X
		jogo.desenharMarca(0, 1); // Inicio do jogo
		jogo.setMarcaPrimeiroJogadorX(true);//Tentou trocar a marca
	}
	@Test(expected=ExcecaoJogoDaVelha.class)
	public void desenharMarcaAntesDeDefinirOPrimeiroJogador() {
		jogo.desenharMarca(0, 1); // Inicio do jogo
	}
}
