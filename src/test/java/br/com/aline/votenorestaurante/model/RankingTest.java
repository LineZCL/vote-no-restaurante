package br.com.aline.votenorestaurante.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import static org.mockito.Mockito.mock;

public class RankingTest {
	
	private Ranking ranking; 
	
	@Before
	public void setup(){
		ranking = new Ranking(); 
	}
	
	@Test
	public void testeGetSetId(){
		assertNull(ranking.getId());
		Long id = 1l;
		ranking.setId(id);
		assertSame(id, ranking.getId());
	}
	
	@Test
	public void testeGetSetRestaurante(){
		assertNull(ranking.getRestaurante());
		Restaurante restaurante = mock(Restaurante.class);
		ranking.setRestaurante(restaurante);
		assertSame(restaurante, ranking.getRestaurante());
	}
	
	@Test
	public void testeGetSetUsuario(){
		assertNull(ranking.getUsuario());
		Usuario usuario = mock(Usuario.class); 
		ranking.setUsuario(usuario);
		assertSame(usuario, ranking.getUsuario());
	}
	
	@Test
	public void testeGetSetVotos(){
		assertNull(ranking.getVotos());
		Integer votos = 1;  
		ranking.setVotos(1);
		assertSame(votos, ranking.getVotos());
	}
	
}
