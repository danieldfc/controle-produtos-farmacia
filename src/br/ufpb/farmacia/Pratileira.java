/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.farmacia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danielfelizardo
 */
public class Pratileira {

  private List<Produto> produtos;
  private final int quantidadeMaxima;
  private String tipo;

  public Pratileira(List<Produto> produtos, int quantidadeMaxima, String tipo) {
    this.produtos = produtos;
    this.quantidadeMaxima = quantidadeMaxima;
    this.tipo = tipo;
  }

  private boolean existeProduto(Produto produto) {
    for (Produto each : this.produtos) {
      if (each.equals(produto)) {
        return true;
      }
    }

    return false;
  }

  public boolean removerProduto(String nomeProduto) {
    for (Produto each : this.produtos) {
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

  public boolean atualizarPratilheira(List<Produto> produtos, String tipo) {
    this.produtos.removeAll(this.produtos);
    this.setTipo(tipo);
    return this.produtos.addAll(produtos);
  }

  public Produto showProduto(String nome) throws ProdutoNotFound {
    for (Produto produto : this.produtos) {
      if (produto.getNome().equalsIgnoreCase(nome)) {
        return produto;
      }
    }
    
    throw new ProdutoNotFound("Produto não encontrado no sistema.");
  }

  public ArrayList<Produto> listarProdutosDoTipo(String tipo) {
    ArrayList<Produto> produtosDoTipo = new ArrayList<Produto>();

    for (Produto produto : this.produtos) {
      if (produto.getTipo().equalsIgnoreCase(tipo)) {
        produtosDoTipo.add(produto);
      }
    }

    return produtosDoTipo;
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
    return ">>>Pratilheira<<<" + "\ntipo:" + tipo + "\nproduto:" + produtos + "\nquantidadeMaxima:" + quantidadeMaxima;
  }
}
