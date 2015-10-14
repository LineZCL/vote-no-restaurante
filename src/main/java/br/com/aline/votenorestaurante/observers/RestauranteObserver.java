package br.com.aline.votenorestaurante.observers;

import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.aline.votenorestaurante.DAO.RestauranteDAO;
import br.com.aline.votenorestaurante.model.Restaurante;
import br.com.caelum.vraptor.events.VRaptorInitialized;

public class RestauranteObserver {
	@Inject
	private RestauranteDAO restauranteDao;

	public void inicializarRestaurantes(
			@Observes VRaptorInitialized eventoIniciador) {

		List<Restaurante> restaurantes = restauranteDao
				.lista(Restaurante.class);

		if (restaurantes.isEmpty()) {
			restauranteDao.criar(new Restaurante("Outback"));
			restauranteDao.criar(new Restaurante("AppleBees"));
			restauranteDao.criar(new Restaurante("Madero"));
			restauranteDao.criar(new Restaurante("Si Señor"));
			restauranteDao.criar(new Restaurante("Tony Roma's"));
		}
	}
}
