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
  
//  public boolean atualizarPratilheira(List<Produto> produto) {
//    return true; // TODO: criar
//  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }

  @Override
  public String toString() {
    return "Pratilheira{" + "produtos=" + produtos + ", quantidadeMaxima=" + quantidadeMaxima + '}';
  }
}
