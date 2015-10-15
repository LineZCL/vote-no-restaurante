package br.com.aline.votenorestaurante.sessionComponent;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.aline.votenorestaurante.DAO.RestauranteDAO;
import br.com.aline.votenorestaurante.model.Restaurante;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.eq;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ListaCartaoVotoTest {

	private ListaCartaoVoto listaCartaoVoto;

	@Before
	public void setup() {
		listaCartaoVoto = new ListaCartaoVoto();
	}

	@Test
	public void testeBuscaRestauranteSemRegistroNoDB() {
		RestauranteDAO restauranteDao = mock(RestauranteDAO.class);
		List<Restaurante> restaurantesInDB = new ArrayList<Restaurante>();

		when(restauranteDao.lista(eq(Restaurante.class))).thenReturn(
				restaurantesInDB);
		
		listaCartaoVoto.inicializaLista(restauranteDao);
		assertTrue(listaCartaoVoto.getCartoes().isEmpty());
		List<Restaurante> restaurantes = listaCartaoVoto.buscaRestaurantes();
		assertTrue(restaurantes.isEmpty());
		
		assertTrue(listaCartaoVoto.terminouRestaurantes());
	}
	
	@Test
	public void testeBuscaRestaurante(){
		RestauranteDAO restauranteDao = mock(RestauranteDAO.class);
		List<Restaurante> restaurantesInDB = new ArrayList<Restaurante>();
		restaurantesInDB.add(new Restaurante());
		restaurantesInDB.add(new Restaurante());
		when(restauranteDao.lista(eq(Restaurante.class))).thenReturn(
				restaurantesInDB);

		listaCartaoVoto.inicializaLista(restauranteDao);
		assertFalse(listaCartaoVoto.getCartoes().isEmpty());
		List<Restaurante> restaurantes = listaCartaoVoto.buscaRestaurantes();
		assertFalse(restaurantes.isEmpty());
		listaCartaoVoto.removerCartaoVoto();
		assertTrue(listaCartaoVoto.terminouRestaurantes());
	}
	
	

}
