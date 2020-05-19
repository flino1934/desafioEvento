package com.qintess.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "concert_hall")
public class CasaDeShow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name_concert_hall")
	private String nomeCasaShow;

	@Column(name = "cep")
	private String cep;

	@Column(name = "andress")
	private String endereco;

	@Column(name = "capacity")
	private int capacidade;

	@Column(name = "description")
	private String descricao;

	@Column(name = "rent_amount")
	private double valorAluguel;
	
	@JsonIgnore
	@OneToMany(mappedBy = "casaDeShow",
			cascade = {CascadeType.DETACH,CascadeType.MERGE,
					   CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Evento>eventos;

	public CasaDeShow() {
		// TODO Auto-generated constructor stub
	}

	public CasaDeShow(String nomeCasaShow, String cep, String endereco, int capacidade, String descricao,
			double valorAluguel) {
		this.nomeCasaShow = nomeCasaShow;
		this.cep = cep;
		this.endereco = endereco;
		this.capacidade = capacidade;
		this.descricao = descricao;
		this.valorAluguel = valorAluguel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCasaShow() {
		return nomeCasaShow;
	}

	public void setNomeCasaShow(String nomeCasaShow) {
		this.nomeCasaShow = nomeCasaShow;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public void addEvento(Evento tempEvento) {
		
		if	(eventos == null) {//vai verificar se a nossa lista esta vazia se estiver 
			
			eventos = new ArrayList<>();//vai criar uma nova lista
			
		}
		
		eventos.add(tempEvento);
		tempEvento.setCasaDeShow(this);//Vou passar esta casa de show
		
	}

}
