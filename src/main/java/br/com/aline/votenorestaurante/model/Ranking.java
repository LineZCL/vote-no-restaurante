package br.com.aline.votenorestaurante.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ranking implements Entidade{
	
	@Id
	@GeneratedValue
	private Long id; 
	
	@ManyToOne(optional = false, targetEntity=Restaurante.class)
	@JoinColumn(name="restauranteId", referencedColumnName="id")
	private Restaurante restaurante;
	
	@ManyToOne(optional = false, targetEntity=Usuario.class)
	@JoinColumn(name="usuarioId", referencedColumnName="id")
	private Usuario usuario; 
	private Integer votos;
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	} 
	
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
