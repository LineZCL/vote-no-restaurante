package br.com.aline.votenorestaurante.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.aline.votenorestaurante.DAO.RankingDAO;
import br.com.aline.votenorestaurante.model.Ranking;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Path("/ranking")
@Controller
public class RankingController {
	
	private RankingDAO rankingDao; 
	private Result result; 
	
	@Inject
	public RankingController(RankingDAO rankingDao, Result result){
		this.rankingDao = rankingDao; 
		this.result = result; 
	}
	
	public RankingController()
	{
		this(null, null);
	}
	
	public List<Ranking> rankingRestaurantes(Long usuarioId){
		
		result.include("usuarioId", usuarioId);
		return rankingDao.lista(Ranking.class); 
	}
}
