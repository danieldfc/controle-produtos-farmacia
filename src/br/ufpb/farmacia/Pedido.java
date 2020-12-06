/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.farmacia;

import java.util.List;

/**
 *
 * @author lucas
 */
public class Pedido implements CarrinhoDeComprasInterface {

    private int ID;
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
      return "Pedido{" + "ID=" + this.ID + ", produtos=" + produtos + '}';
    } 
  
    @Override
    public boolean adicionarProdutos(List<Produto> productos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean removerProduto(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
