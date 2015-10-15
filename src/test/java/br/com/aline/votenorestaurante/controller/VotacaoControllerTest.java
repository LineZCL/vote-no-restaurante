package br.com.aline.votenorestaurante.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import br.com.aline.votenorestaurante.DAO.RankingDAO;
import br.com.aline.votenorestaurante.DAO.RestauranteDAO;
import br.com.aline.votenorestaurante.DAO.UsuarioDAO;
import br.com.aline.votenorestaurante.model.Restaurante;
import br.com.aline.votenorestaurante.sessionComponent.ListaCartaoVoto;
import br.com.aline.votenorestaurante.sessionComponent.ListaRankingUsuario;
import br.com.caelum.vraptor.util.test.MockResult;

public class VotacaoControllerTest {
	private VotacaoController votacaoController;
	private RestauranteDAO restauranteDao;
	private RankingDAO rankingDao;
	private UsuarioDAO usuarioDao;
	private ListaRankingUsuario listaRankingUsuario;
	private ListaCartaoVoto listaCartaoVoto;
	private MockResult mockResult;

	@Before
	public void setup() {
		restauranteDao = mock(RestauranteDAO.class);
		rankingDao = mock(RankingDAO.class);
		usuarioDao = mock(UsuarioDAO.class);
		listaRankingUsuario = mock(ListaRankingUsuario.class);
		listaCartaoVoto = mock(ListaCartaoVoto.class);
		mockResult = new MockResult();

		votacaoController = new VotacaoController(restauranteDao, usuarioDao,
				rankingDao, listaRankingUsuario, listaCartaoVoto, mockResult);
	}

	@Test
	public void testeIndexTemCartaoVoto() {
		when(listaCartaoVoto.getCartoes()).thenReturn(
				new ArrayList<ListaCartaoVoto.CartaoVoto>());
		when(listaCartaoVoto.buscaRestaurantes()).thenReturn(
				new ArrayList<Restaurante>());

		List<Restaurante> respostas = null;
		assertNull(respostas);
		respostas = votacaoController.index();
		assertNotNull(respostas);
	}

	@Test
	public void testeIndexNaoTemCartaoVoto() {
		when(listaCartaoVoto.getCartoes()).thenReturn(null);
		PowerMockito.doNothing().when(listaCartaoVoto)
				.inicializaLista(any(RestauranteDAO.class));
		when(listaCartaoVoto.buscaRestaurantes()).thenReturn(
				new ArrayList<Restaurante>());

		List<Restaurante> respostas = null;
		assertNull(respostas);
		respostas = votacaoController.index();
		assertNotNull(respostas);
	}
	
	

}
