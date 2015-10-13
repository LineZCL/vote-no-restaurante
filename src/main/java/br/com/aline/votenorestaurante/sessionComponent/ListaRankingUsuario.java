package br.com.aline.votenorestaurante.sessionComponent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import br.com.aline.votenorestaurante.model.Ranking;
import br.com.aline.votenorestaurante.model.Restaurante;

/**
 * Guarda na sessão enquanto o usuário está votando.
 * 
 * @author Aline Kimy Miyazaki
 *
 */

@SuppressWarnings("serial")
@SessionScoped
public class ListaRankingUsuario implements Serializable {

	private List<Ranking> rankingsUsuario;

	public ListaRankingUsuario() {
		reiniciarRanking();
	}

	/**
	 * Busca todos os rankings que o usuário votou
	 * 
	 * @return
	 */
	public List<Ranking> buscaListaRanking() {
		return rankingsUsuario;
	}

	/**
	 * Adiciona voto ao restaurante.
	 * 
	 * @param restaurante
	 */
	public void adicionaVoto(Restaurante restaurante) {
		Ranking ranking = buscaRankingExistente(restaurante);
		if (ranking == null) {
			ranking = new Ranking();
			ranking.setRestaurante(restaurante);
			ranking.setVotos(1);
			rankingsUsuario.add(ranking);
		} else {
			ranking.setVotos(ranking.getVotos() + 1);
		}

	}

	/**
	 * Verifica se o restaurante já foi votado, se sim ele retorna o Ranking
	 * para adicionar 1 no voto.
	 * 
	 * @param restaurante
	 * @return
	 */
	private Ranking buscaRankingExistente(Restaurante restaurante) {
		for (Ranking ranking : rankingsUsuario) {
			if (restaurante.equals(ranking.getRestaurante())) {
				return ranking;
			}
		}
		return null;
	}
	
	public void reiniciarRanking(){
		rankingsUsuario = new ArrayList<Ranking>(); 
	}

}
