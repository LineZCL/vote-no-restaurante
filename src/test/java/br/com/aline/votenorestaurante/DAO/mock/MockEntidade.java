package br.com.aline.votenorestaurante.DAO.mock;

import br.com.aline.votenorestaurante.model.Entidade;

public class MockEntidade implements Entidade{

	private Long id;
	
	@Override
	public Long getId() {
		return id; 
	}

	@Override
	public void setId(Long id) {
		this.id = id; 
	}
	
}
