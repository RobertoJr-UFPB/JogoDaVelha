package com.jogodavelha;

import static org.junit.Assert.*;

import org.junit.Test;

public class JogoTest {

	@Test
	public void criarJogo() {
		Jogo jogo = new Jogo();
		assertFalse("O jogo iniciou finalizado", jogo.acabou());
	}

}
