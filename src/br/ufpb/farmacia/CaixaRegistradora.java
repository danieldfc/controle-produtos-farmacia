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
public class CaixaRegistradora {
  
  private double total;
  
  public CaixaRegistradora(double total) {
    this.total = total;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return "CaixaRegistradora{" + "total=" + total + '}';
  }  
}
