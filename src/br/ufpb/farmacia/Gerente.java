/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.farmacia;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author lucas
 */
public class Gerente extends Pessoa implements GerenteInterface {
  private List<Funcionario> funcionarios;

  public Gerente(List<Funcionario> funcionarios, String nome, int idade, String cpf) {
    super(nome, idade, cpf);
    this.funcionarios = funcionarios;
  }

  public List<Funcionario> getFuncionarios() {
    return funcionarios;
  }

  public void setFuncionarios(List<Funcionario> funcionarios) {
    this.funcionarios = funcionarios;
  }

  @Override
  public int hashCode() {
    int hash = 7;
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
    if (!Objects.equals(this.funcionarios, other.funcionarios)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Nome: " + this.getNome() + "CPF: " + this.getCpf();
  }

  @Override
  public Funcionario buscaFuncionario(String cpf) throws FuncionarioNotFound {
    for (Funcionario funcionario : this.funcionarios) {
      if (funcionario.getCpf().equalsIgnoreCase(cpf)) {
        return funcionario;
      }
    }

    throw new FuncionarioNotFound("Funcionário não encontrado no sistema.");
  }

  @Override
  public boolean removerFuncionario(String cpf) throws FuncionarioNotFound {
    for (Funcionario funcionario : this.funcionarios) {
      if (funcionario.getCpf().equalsIgnoreCase(cpf)) {
        return this.funcionarios.remove(funcionario);
      }
    }

    throw new FuncionarioNotFound("Funcionário não encontrado no sistema.");
  }

  @Override
  public boolean adicionaFuncionario(Funcionario funcionario) {
    if (this.getIdade() >= 18) {
      return this.funcionarios.add(funcionario);
    } else {
      return false;
    }
  }
}
