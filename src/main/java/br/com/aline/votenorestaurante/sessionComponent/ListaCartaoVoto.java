package br.com.aline.votenorestaurante.sessionComponent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import br.com.aline.votenorestaurante.DAO.RestauranteDAO;
import br.com.aline.votenorestaurante.model.Restaurante;

@SuppressWarnings("serial")
@SessionScoped
public class ListaCartaoVoto implements Serializable {

	private List<CartaoVoto> cartoes;

	public void inicializaLista(RestauranteDAO restauranteDAO) {
		List<Restaurante> restaurantes = restauranteDAO
				.lista(Restaurante.class);
		cartoes = new ArrayList<ListaCartaoVoto.CartaoVoto>();

		if (restaurantes.size() > 1) {
			for (int i = 0; i < restaurantes.size() - 1; i++) {
				for (int j = i + 1; j < restaurantes.size(); j++) {
					cartoes.add(new CartaoVoto(restaurantes.get(i),
							restaurantes.get(j)));
				}
			}
		}
	}

	public List<CartaoVoto> getCartoes() {
		return cartoes;
	}

	public List<Restaurante> buscaRestaurantes() {
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();
		if (cartoes.size() > 0) {
			CartaoVoto cartao = cartoes.get(0);

			restaurantes.add(cartao.getRestauranteA());
			restaurantes.add(cartao.getRestauranteB());

			cartoes.remove(cartao);
		}
		return restaurantes;
	}

	public Boolean terminouRestaurantes() {
		return cartoes.isEmpty();
	}

	public class CartaoVoto {
		private Restaurante restauranteA;
		private Restaurante restauranteB;

		public CartaoVoto(Restaurante restauranteA, Restaurante restauranteB) {
			this.restauranteA = restauranteA;
			this.restauranteB = restauranteB;
		}

		public Restaurante getRestauranteA() {
			return restauranteA;
		}

		public Restaurante getRestauranteB() {
			return restauranteB;
		}
	}
}
