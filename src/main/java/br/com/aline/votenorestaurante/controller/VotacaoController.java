package br.com.aline.votenorestaurante.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.aline.votenorestaurante.DAO.RankingDAO;
import br.com.aline.votenorestaurante.DAO.RestauranteDAO;
import br.com.aline.votenorestaurante.DAO.UsuarioDAO;
import br.com.aline.votenorestaurante.model.Ranking;
import br.com.aline.votenorestaurante.model.Restaurante;
import br.com.aline.votenorestaurante.model.Usuario;
import br.com.aline.votenorestaurante.sessionComponent.ListaCartaoVoto;
import br.com.aline.votenorestaurante.sessionComponent.ListaRankingUsuario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
@Path("")
public class VotacaoController {

	private RestauranteDAO restauranteDao;
	private RankingDAO rankingDao;
	private UsuarioDAO usuarioDao;
	private ListaRankingUsuario listaRankingUsuario;
	private ListaCartaoVoto cartoesVotos;
	private Result result;

	@Inject
	public VotacaoController(RestauranteDAO restauranteDao,
			UsuarioDAO usuarioDao, RankingDAO rankingDao,
			ListaRankingUsuario listaRanking, ListaCartaoVoto cartoesVotos,
			Result result) {
		this.restauranteDao = restauranteDao;
		this.usuarioDao = usuarioDao;
		this.rankingDao = rankingDao;
		this.listaRankingUsuario = listaRanking;
		this.rankingDao = rankingDao;
		this.cartoesVotos = cartoesVotos;
		this.result = result;
	}

	/**
     * @deprecated CDI eyes only
     */
	public VotacaoController() {
		this(null, null, null, null, null, null);
	}

	@Path("")
	public List<Restaurante> index() {
		if (cartoesVotos.getCartoes() == null) {
			cartoesVotos.inicializaLista(restauranteDao);
		}
		return cartoesVotos.buscaRestaurantes();
	}

	
	@Path("/votar")
	public void votar(Long restauranteId) {
		if (restauranteId != null) {
			Restaurante restaurante = restauranteDao.buscaPorId(
					Restaurante.class, restauranteId);
			if (restaurante != null) {
				listaRankingUsuario.adicionaVoto(restaurante);
				cartoesVotos.removerCartaoVoto();
				if (cartoesVotos.terminouRestaurantes()) {
					result.redirectTo(this).newUser();
				}
				else{
					result.redirectTo(this).index();
				}
			}
		}
		else{
			result.include("mensagemErro", "Você precisa escolher uma opção");
			result.redirectTo(this).index();
		}
		
	}

	@Path("/newUser")
	public void newUser() {
	}

	@Path("/finalizarVotacao")
	public void finalizarVotacao(Usuario usuario) {
		usuario = usuarioDao.criar(usuario);

		for (Ranking ranking : listaRankingUsuario.buscaListaRanking()) {
			ranking.setUsuario(usuario);
			rankingDao.criar(ranking);
		}

		listaRankingUsuario.reiniciarRanking();
		cartoesVotos.inicializaLista(restauranteDao);

		result.redirectTo(RankingController.class).rankingRestaurantes(
				usuario.getId());

	}

}