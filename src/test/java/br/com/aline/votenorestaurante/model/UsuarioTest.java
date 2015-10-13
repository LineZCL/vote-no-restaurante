package br.com.aline.votenorestaurante.model;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	private Usuario usuario; 
	
	@Before
	public void setup(){
		usuario = new Usuario(); 
	}
	
	@Test
	public void testeGetSetId(){
		assertNull(usuario.getId());
		Long id = 1l; 
		usuario.setId(id);
		assertSame(id, usuario.getId());
	}
	
	@Test
	public void testeGetSetNome(){
		assertNull(usuario.getNome());
		String nome = "Maria";
		usuario.setNome(nome);
		assertSame(nome, usuario.getNome());
	}
	
	@Test
	public void testeGetSetEmail(){
		assertNull(usuario.getEmail());
		String email = "maria@teste.com.br";
		usuario.setEmail(email);
		assertSame(email, usuario.getEmail());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testeGetSetRankings(){
		assertNull(usuario.getRankings());
		Set<Ranking> rankings = mock(Set.class); 
		usuario.setRankings(rankings);
		assertSame(rankings, usuario.getRankings());
	}

}
