package br.com.aline.votenorestaurante.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class RestauranteTest {
	
	private Restaurante restaurante; 
	
	@Before
	public void setup(){
		restaurante = new Restaurante(); 
	}
	
	@Test
	public void testeGetSetId(){
		assertNull(restaurante.getId());
		Long id = 1l; 
		restaurante.setId(id);
		assertSame(id, restaurante.getId());
	}
	
	@Test
	public void testeGetSetNome(){
		assertNull(restaurante.getNome());
		String nome = "Outback";
		restaurante.setNome(nome);
		assertSame(nome, restaurante.getNome());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testeGetSetRankings(){
		assertNull(restaurante.getRankings());
		Set<Ranking> rankings = mock(Set.class); 
		restaurante.setRankings(rankings);
		assertSame(rankings, restaurante.getRankings());
	}
	
	@Test
	public void testEquals(){
		Restaurante restauranteA = new Restaurante();
		restauranteA.setId(1l);
		
		Restaurante restauranteB = new Restaurante(); 
		restauranteB.setId(1l);
		
		assertTrue(restauranteA.equals(restauranteB));
	
	}
	
	@Test
	public void testNotEquals(){
		Restaurante restauranteA = new Restaurante();
		restauranteA.setId(1l);
		
		Restaurante restauranteB = new Restaurante(); 
		restauranteB.setId(2l);
		
		assertFalse(restauranteA.equals(restauranteB));
	
	}
}
