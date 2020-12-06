/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.farmacia;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author danielfelizardo
 */
public class Gerente extends Pessoa {
  
  private String cpf;
  private List<Funcionario> funcionarios;
  
  public Gerente(String nome, int idade, String cpf) {
    super(nome, idade);
    this.cpf = cpf;
    this.funcionarios = new ArrayList<Funcionario>();
  }
  
  public Funcionario buscaFuncionario(String cpf) throws FuncionarioNotFound {
    for (Funcionario funcionario: this.funcionarios) {
      if (funcionario.getCpf().equals(cpf)) {
        return funcionario;
      }
    }
    
    throw new FuncionarioNotFound("Funcionario não encontrado no sistema.");
  }
  
  public boolean adicionaFuncionario(String nome, int idade, String cpf) {
    Funcionario funcionario = new Funcionario(nome, idade, cpf);
    return this.funcionarios.add(funcionario);
  }
  
  public boolean removerFuncionario(String cpf) throws FuncionarioNotFound {
    for (Funcionario funcionario: this.funcionarios) {
      if (funcionario.getCpf().equals(cpf)) {
        return this.funcionarios.remove(funcionario);
      }
    }
    throw new FuncionarioNotFound("Funcionario não encontrado no sistema.");
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public List<Funcionario> getFuncionarios() {
    return funcionarios;
  }

  public void setFuncionarios(List<Funcionario> funcionarios) {
    this.funcionarios = funcionarios;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 37 * hash + Objects.hashCode(this.cpf);
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
    final Gerente other = (Gerente) obj;
    if (!Objects.equals(this.cpf, other.cpf)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Gerente{" + "cpf=" + cpf + ", funcionarios=" + funcionarios + '}';
  }
}
