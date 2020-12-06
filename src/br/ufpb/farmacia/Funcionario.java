/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.farmacia;

import java.util.Objects;

/**
 *
 * @author danielfelizardo
 */
public class Funcionario extends Pessoa {
  
  private String cpf;
  
  public Funcionario(String nome, int idade, String cpf) {
    super(nome, idade);
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + Objects.hashCode(this.cpf);
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
    final Funcionario other = (Funcionario) obj;
    if (!Objects.equals(this.cpf, other.cpf)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Funcionario{" + "nome: "+ this.getNome() + "idade: "+
      this.getIdade() + "cpf: "+ this.cpf + "}";
  }
}
