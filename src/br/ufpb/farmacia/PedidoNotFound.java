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
public class PedidoNotFound extends Exception {
  
  public static final long serialVersionUID = 1L;
  
  public PedidoNotFound(String msg) {
    super(msg);
  }
}
