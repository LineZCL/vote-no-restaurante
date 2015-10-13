package br.com.aline.votenorestaurante.sessionComponent;

import org.junit.Before;
import org.junit.Test;

import br.com.aline.votenorestaurante.model.Restaurante;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

public class ListaRankingUsuarioTeste {
	private ListaRankingUsuario listaRankingUsuario;

	@Before
	public void setup() {
		listaRankingUsuario = new ListaRankingUsuario();
	}

	@Test
	public void testeListaRankingUsuario() {
		assertTrue(listaRankingUsuario.buscaListaRanking().isEmpty());
		Restaurante restaurante = new Restaurante();
		listaRankingUsuario.adicionaVoto(restaurante);
		assertFalse(listaRankingUsuario.buscaListaRanking().isEmpty());
		listaRankingUsuario.adicionaVoto(restaurante);
		assertSame(listaRankingUsuario.buscaListaRanking().get(0).getVotos(),
				2);
	}

}
