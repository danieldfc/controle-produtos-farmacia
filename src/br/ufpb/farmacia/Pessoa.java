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
public abstract class Pessoa {
  
  private String nome;
  private int idade;

  public Pessoa() {
    this("", 0);
  }
   
  public Pessoa(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + Objects.hashCode(this.nome);
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
    final Pessoa other = (Pessoa) obj;
    if (!Objects.equals(this.nome, other.nome)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Pessoa{" + "nome=" + nome + ", idade=" + idade + '}';
  }
}
