/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.farmacia;

/**
 *
 * @author danielfelizardo
 */
public interface CarrinhoDeCompras {
  public boolean adicionarProduto(Produto produto);
  public boolean removerProduto(Produto produto) throws ProdutoNotFoundPedido;
}
