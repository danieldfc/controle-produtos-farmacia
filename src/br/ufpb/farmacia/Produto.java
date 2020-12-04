package br.ufpb.farmacia;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danielfelizardo
 */
public class Produto {

  private String nome;
	private String descricao;
	private double preco;
	private String tipo;
																																										
	public Produto() {
		this("", "", 0.0);
	}
  
  public Produto(String nome, String descricao, double preco){
  	this.nome = nome;
 		this.descricao = descricao;
		this.preco = preco;
	}

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.nome);
    hash = 89 * hash + Objects.hashCode(this.tipo);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Produto other = (Produto) obj;
    if (!Objects.equals(this.nome, other.nome)) {
      return false;
    }
    if (!Objects.equals(this.tipo, other.tipo)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Produto{" + "nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", tipo=" + tipo + '}';
  }
}
