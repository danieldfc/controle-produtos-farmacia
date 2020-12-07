/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.farmacia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author danielfelizardo
 */
public class ProgramaPrincipal {
  
  public static int menuPratileira(Scanner sc) {
    System.out.println("--- Pratileira ---");
    System.out.println("1 - Criar pratileira");
    System.out.println("2 - Atualizar pratileira");
    System.out.println("3 - Adicionar produto");
    System.out.println("4 - Remover produto");
    System.out.println("5 - Listar produtos do tipo");
    System.out.print("Opção: ");
    int op = sc.nextInt();
    
    return op;
  }
  
  public static int menuFuncionario(Scanner sc) {
    System.out.println("--- Funcionário ---");
    System.out.println("1 - Adicionar funcionário");
    System.out.println("2 - Remover funcionário");
    System.out.print("Opção: ");
    int op = sc.nextInt();
    
    return op;
  }

  public static int menuPedido(Scanner sc) {
    System.out.println("--- Pedido ---");
    System.out.println("1 - Criar pedido");
    System.out.println("2 - Total a pagar");
    System.out.println("3 - Finalizar pedido");
    System.out.println("4 - Cancelar pedido");
    System.out.print("Opção: ");
    int op = sc.nextInt();
    
    return op;
  }
  
  public static int menu(Scanner sc) {
    System.out.println("--- Farmácia UFPB ---");
    System.out.println("1 - Pratileira");
    System.out.println("2 - Funcionário");
    System.out.println("3 - Pedidos");
    System.out.println("4 - Sair");
    int op = sc.nextInt();
    
    return op;
  }
  
  public static void main(String[] args) {    
    Scanner sc = new Scanner(System.in);
    ArrayList<Funcionario> listFuncionarios = new ArrayList<Funcionario>();    
    Gerente gerente = new Gerente(listFuncionarios, "Rafael", 22, "123.321.321-09");

    Farmacia farmacia = new Farmacia(listFuncionarios, gerente);
    
    int op = menu(sc);
    
    while(op != 4) {
      if (op == 1) {
        int opPratileira = menuPratileira(sc);
        
        if (opPratileira == 1) {
          try {
            System.out.print("Quantidade máxima que a pratileira suporta: ");
            int quantidadeMaxima = sc.nextInt();
            
            System.out.print("Quantidade de produtos para adicionar:");
            int quantidadeProdutos = sc.nextInt();
            
            System.out.print("Qual o tipo de pratileira:");
            String tipo = sc.next();
            
            ArrayList<Produto> produtos = new ArrayList<Produto>();
            
            for (int i = 0; i < quantidadeProdutos; i++) {
              System.out.print("Nome do produto ["+(i+1)+"]:");
              String nome = sc.next();

              System.out.print("Descrição do produto ["+(i+1)+"]:");
              String descricao = sc.next();
              
              System.out.print("Preço do produto ["+(i+1)+"]:");
              double preco = sc.nextDouble();
              
              Produto produto = new Produto(nome, descricao, preco);
              
              produtos.add(produto);
            }
            
            Pratileira pratilheira = new Pratileira(produtos, quantidadeMaxima, tipo);
            
            farmacia.adicionarPratileira(pratilheira);
            
            System.out.println("Pratileira adicionada com sucesso!");
          } catch(Exception err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
          }
        } else if (opPratileira == 2) {
          try {
            System.out.print("Qual tipo para listar? ");
            String tipoParaListar = sc.next();
            
            Pratileira pratileira = farmacia.showPratileiraDoTipo(tipoParaListar);
            
            System.out.print("Quantidade de produtos para adicionar:");
            int quantidadeProdutos = sc.nextInt();
            
            System.out.print("Qual o tipo de pratileira:");
            String tipo = sc.next();
            
            ArrayList<Produto> produtos = new ArrayList<Produto>();
            
            for (int i = 0; i < quantidadeProdutos; i++) {
              System.out.print("Nome do produto ["+(i+1)+"]:");
              String nome = sc.next();

              System.out.print("Descrição do produto ["+(i+1)+"]:");
              String descricao = sc.next();
              
              System.out.print("Preço do produto ["+(i+1)+"]:");
              double preco = sc.nextDouble();
              
              Produto produto = new Produto(nome, descricao, preco);
              
              produtos.add(produto);
            }
            
            pratileira.atualizarPratilheira(produtos, tipo);
          } catch(Exception err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
          }
        
        } else if (opPratileira == 3) {
          try {
            System.out.print("Qual tipo para listar? ");
            String tipoParaListar = sc.next();
            
            Pratileira pratileira = farmacia.showPratileiraDoTipo(tipoParaListar);
            
            System.out.print("Nome do produto: ");
            String nome = sc.next();

            System.out.print("Descrição do produto: ");
            String descricao = sc.next();

            System.out.print("Preço do produto: ");
            double preco = sc.nextDouble();

            Produto produto = new Produto(nome, descricao, preco);
            
            pratileira.adicionarProduto(produto);
          } catch(Exception err) {
            System.out.println("Error ao adicionar produto");
            err.printStackTrace();
          }
        
        } else if (opPratileira == 4) {
          try {
            System.out.print("Qual tipo para listar? ");
            String tipoParaListar = sc.next();
            
            Pratileira pratileira = farmacia.showPratileiraDoTipo(tipoParaListar);
            
            System.out.print("Nome do produto: ");
            String nome = sc.next();
            
            pratileira.removerProduto(nome);
          } catch(Exception err) {
            System.out.println("Error ao remover produto");
            err.printStackTrace();
          }
        } else if (opPratileira == 5) {
          try {
            System.out.print("Qual tipo para listar? ");
            String tipoParaListar = sc.next();
            
            Pratileira pratileira = farmacia.showPratileiraDoTipo(tipoParaListar);
            
            System.out.println(pratileira.listarProdutosDoTipo(tipoParaListar));
          } catch(Exception err) {
            System.out.println("Erro ao listar produtos");
            err.printStackTrace();
          }
        }
      }
    }
  }
  
}
