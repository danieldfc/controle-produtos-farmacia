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
public interface CarrinhoDeComprasInterface {
    
    public boolean adicionarProdutos(List<Produto> productos);
    public boolean removerProduto(Produto produto);
}
