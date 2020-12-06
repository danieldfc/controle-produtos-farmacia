/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.farmacia;

import java.util.List;

/**
 *
 * @author danielfelizardo
 */
public class Pratilheira {
  
  private List<Produto> produtos;
  private final int quantidadeMaxima;
  private String tipo;
  
  public Pratilheira(
  	List<Produto> produtos,
  	int quantidadeMaxima,
    String tipo
	) {
  	this.produtos = produtos;
  	this.quantidadeMaxima = quantidadeMaxima;
    this.tipo = tipo;
  }
  
  private boolean existeProduto(Produto produto) {
    for (Produto each: this.produtos) {
      if (each.equals(produto)) {
        return true;
      }
    }

    return false;
  }
  
  public boolean removerProduto(String nomeProduto) {
    for (Produto each: this.produtos) {
      if (each.getNome().equals(nomeProduto)) {
        return this.produtos.remove(each);
      }
    }
    
    return false;
  }
  
  public boolean adicionarProduto(Produto produto) {
    if (existeProduto(produto)) {
      return false;
    }

    if (this.produtos.size() == this.quantidadeMaxima) {
      return false;
    } else {
      return this.produtos.add(produto);
    }
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    return "Pratilheira{" + "produtos=" + produtos + ", quantidadeMaxima=" + quantidadeMaxima + ", tipo=" + tipo + '}';
  }
}
