package br.ufpb.farmacia;


import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danielfelizardo
 */
public class Pedido implements CarrinhoDeCompras {
  
  private int ID = 0;
  private List<Produto> produtos;
  
  public Pedido(List<Produto> produtos) {
    this.produtos = produtos;
    this.ID += 1;
  }

  public int getID() {
    return ID;
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }

  @Override
  public String toString() {
    return "Pedido{" + "ID=" + ID + ", produtos=" + produtos + '}';
  } 

  @Override
  public boolean adicionarProduto(Produto produto) {
    return this.produtos.add(produto);
  }
  
  @Override
  public boolean removerProduto(Produto produto) throws ProdutoNotFoundPedido {
    for (Produto each: this.produtos) {
      if (each.equals(produto)) {
        return this.produtos.remove(each);
      }
    }
    
    throw new ProdutoNotFoundPedido("Produto não encontrado no carrinho.");
  }
}
