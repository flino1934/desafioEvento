package com.qintess.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "date")

	private Date data;

	@Column(name = "andress")
	private String endereco;

	@Column(name = "price")
	private double preco;

	@Column(name = "capacity")
	private int capacidade;

	@Column(name = "event_description")
	private String descricaoEvento;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "eventos_clientes", joinColumns = @JoinColumn(name = "evento_id"), inverseJoinColumns = @JoinColumn(name = "cliente_id"))
	private List<Cliente> clientes;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "concert_hall_id_evento_id", joinColumns = @JoinColumn(name = "evento_id"), inverseJoinColumns = @JoinColumn(name = "concert_hall_id"))
	private CasaDeShow casaDeShow;

	// acabei de colocar

	@OneToMany(mappedBy = "evento", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<Ingresso> ingressos;

	public Evento() {
		// TODO Auto-generated constructor stub
	}

	public Evento(Date data, String endereco, double preco, int capacidade, String descricaoEvento) {
		this.data = data;
		this.endereco = endereco;
		this.preco = preco;
		this.capacidade = capacidade;
		this.descricaoEvento = descricaoEvento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getDescricaoEvento() {
		return descricaoEvento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public CasaDeShow getCasaDeShow() {
		return casaDeShow;
	}

	public void setCasaDeShow(CasaDeShow casaDeShow) {
		this.casaDeShow = casaDeShow;
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public void addCliente(Cliente theCliente) {

		if (clientes == null) {

			clientes = new ArrayList<>();

		}

		clientes.add(theCliente);

	}

	//ultima atualização 

	public void addIngresso(Ingresso theIngresso) {

		if (theIngresso.getQuantidade() > 4) {

			System.out.println("Erro");

		}  else  {
			
		 

			if (ingressos == null) {

				ingressos = new ArrayList<>();

			}

			ingressos.add(theIngresso);
			theIngresso.setEvento(this);

		}

	}


}
