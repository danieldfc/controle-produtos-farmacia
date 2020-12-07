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
public class Farmacia extends CaixaRegistradora {

  private Gerente gerente;
  private List<Pedido> pedidos;
  private List<Funcionario> funcionarios;

  public Farmacia() {
    super(0);
    this.gerente = new Gerente(new ArrayList<Funcionario>(), "", 0, "");
    this.funcionarios = new ArrayList<Funcionario>();
    this.pedidos = new ArrayList<Pedido>();
  }

  public boolean adicionaPedido(Pedido pedido) {
    return this.pedidos.add(pedido);
  }

  public boolean cancelarPedido(int ID) throws PedidoNotFound {
    for (Pedido pedido : this.pedidos) {
      if (pedido.getID() == ID) {
        return this.pedidos.remove(pedido);
      }
    }

    throw new PedidoNotFound("Pedido não encontrado no sistema.");
  }

  public double totalAPagar(Pedido pedido) {
    List<Produto> produtos = pedido.getProdutos();
    double total = 0;

    for (Produto produto : produtos) {
      total += produto.getPreco();
    }

    return total;
  }

  public boolean finalizarPedido(Pedido pedido, double total, double recebido) {
    if (recebido >= total) {
      this.setTotal(total);
      return this.pedidos.remove(pedido);
    }

    return false;
  }

  public Gerente getGerente() {
    return gerente;
  }

  public void setGerente(Gerente gerente) {
    this.gerente = gerente;
  }

  public List<Pedido> getPedidos() {
    return pedidos;
  }

  public void setPedidos(List<Pedido> pedidos) {
    this.pedidos = pedidos;
  }

  public List<Funcionario> getFuncionarios() {
    return funcionarios;
  }

  public void setFuncionarios(List<Funcionario> funcionarios) {
    this.funcionarios = funcionarios;
  }

  @Override
  public String toString() {
    return "Farmacia{" + "pedidos=" + pedidos + '}';
  }
}
