package br.com.aline.votenorestaurante.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Restaurante implements Entidade{
	
	public Restaurante() {
		
	}
	
	public Restaurante(String nome) {
		this.nome = nome; 
	}
	
	@Id
	@GeneratedValue
	private Long id; 
	private String nome;
	
	@OneToMany(mappedBy = "restaurante", targetEntity = Ranking.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Ranking> rankings; 
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Ranking> getRankings() {
		return rankings;
	}
	public void setRankings(Set<Ranking> rankings) {
		this.rankings = rankings;
	}
	
	@Override
	public boolean equals(Object obj){
		Restaurante restaurante = (Restaurante) obj; 
		return this == restaurante || this.id == restaurante.getId(); 
	}

}
