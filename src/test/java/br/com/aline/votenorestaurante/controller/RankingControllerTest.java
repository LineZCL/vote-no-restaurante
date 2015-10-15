package br.com.aline.votenorestaurante.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when; 
import static org.mockito.Matchers.eq; 

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.aline.votenorestaurante.DAO.RankingDAO;
import br.com.aline.votenorestaurante.model.Ranking;
import br.com.caelum.vraptor.util.test.MockResult;



public class RankingControllerTest {
	private MockResult mockResult; 
	private RankingController rankingController; 
	private RankingDAO rankingDao; 
	
	@Before
	public void setup(){
		mockResult = new MockResult(); 
		rankingDao = mock(RankingDAO.class);
		rankingController = new RankingController(rankingDao, mockResult); 
	}
	
	@SuppressWarnings("deprecation")
	@Test 
	public void testeRankingSemUsuario(){
		rankingController.rankingRestaurantes(null); 
		assertTrue(mockResult.included().containsKey("usuarioId"));
		assertEquals(null, mockResult.included("usuarioId"));
	}
	
	@Test
	public void testeRankingComUsuario(){
		List<Ranking> rankings = null;
		assertNull(rankings);
		when(rankingDao.lista(eq(Ranking.class))).thenReturn(new ArrayList<Ranking>());
		rankings = rankingController.rankingRestaurantes(1l);
		assertTrue(mockResult.included().containsKey("usuarioId"));
		assertNotNull(rankings);
	}
}
