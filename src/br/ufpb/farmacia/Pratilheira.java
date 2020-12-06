/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.farmacia;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author danielfelizardo
 */
public class Pratilheira {
  
  private List<Produto> produtos;
  private final int quantidadeMaxima;
  
  public Pratilheira(
  	List<Produto> produtos,
  	int quantidadeMaxima
	) {
  	this.produtos = produtos;
  	this.quantidadeMaxima = quantidadeMaxima;
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
    
    return this.produtos.add(produto);
  }
  
  public boolean atualizarPratilheira(List<Produto> produtos) {
    this.produtos.removeAll(this.produtos);
    return this.produtos.addAll(produtos);
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 41 * hash + Objects.hashCode(this.produtos);
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
    final Pratilheira other = (Pratilheira) obj;
    if (!Objects.equals(this.produtos, other.produtos)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Pratilheira{" + "produtos=" + produtos + ", quantidadeMaxima=" + quantidadeMaxima + '}';
  }
}
