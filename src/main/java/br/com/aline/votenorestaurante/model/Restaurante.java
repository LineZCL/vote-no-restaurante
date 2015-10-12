package br.com.aline.votenorestaurante.model;

import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Restaurante {
	
	private Long id; 
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurante")
	private Set<Ranking> rankings; 
	
	public Long getId() {
		return id;
	}
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

}
