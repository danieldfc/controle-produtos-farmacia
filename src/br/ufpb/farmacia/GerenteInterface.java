/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.farmacia;

import java.util.List;

/**
 *
 * @author danielfelizardo
 */
public interface GerenteInterface {
  public Funcionario buscaFuncionario(String cpf) throws FuncionarioNotFound;
  public boolean removerFuncionario(String cpf) throws FuncionarioNotFound;
  public boolean adicionaFuncionario(Funcionario funcionario);
}
