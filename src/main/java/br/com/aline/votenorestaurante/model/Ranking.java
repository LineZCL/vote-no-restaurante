package br.com.aline.votenorestaurante.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Ranking {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="restauranteId", nullable = false)
	private Restaurante restaurante;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="usuarioId", nullable = false)
	private Usuario usuario; 
	private Integer votos;
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Integer getVotos() {
		return votos;
	}
	public void setVotos(Integer votos) {
		this.votos = votos;
	} 

}
