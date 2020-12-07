/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.farmacia;

import java.util.ArrayList;
import java.util.List;
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
    System.out.println("3 - Buscar funcionário");
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
    System.out.print("Opção: ");
    int op = sc.nextInt();

    return op;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Funcionario> listFuncionarios = new ArrayList<Funcionario>();
    Gerente gerente = new Gerente(listFuncionarios, "Rafael", 22, "123.321.321-09");

    Farmacia farmacia = new Farmacia(listFuncionarios, gerente);

    int op = menu(sc);

    while (op != 4) {

      if (op == 1) {
        int opPratileira = menuPratileira(sc);

        if (opPratileira == 1) {
          try {
            System.out.print("Quantidade máxima de produtos que a pratileira suporta: ");
            int quantidadeMaxima = sc.nextInt();

            System.out.print("Quantidade de produtos para adicionar:");
            int quantidadeProdutos = sc.nextInt();
            
            if (quantidadeProdutos > quantidadeMaxima) {
              System.out.println("Quantidade inválida");
            } else {
              System.out.print("Qual o tipo de pratileira:");
              String tipo = sc.next();

              ArrayList<Produto> produtos = new ArrayList<Produto>();

              for (int i = 1; i <= quantidadeProdutos; i++) {
                System.out.print("Nome do produto [" + i + "]:");
                String nome = sc.next();

                System.out.print("Descrição do produto [" + i + "]:");
                String descricao = sc.next();

                System.out.print("Preço do produto [" + i + "]:");
                double preco = sc.nextDouble();

                Produto produto = new Produto(nome, descricao, preco, tipo);

                produtos.add(produto);
              }

              Pratileira pratilheira = new Pratileira(produtos, quantidadeMaxima, tipo);

              farmacia.adicionarPratileira(pratilheira);

              System.out.println("Pratileira adicionada com sucesso!");
            }            
          } catch (Exception err) {
            System.out.println(err.getMessage());
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
              System.out.print("Nome do produto [" + (i + 1) + "]:");
              String nome = sc.next();

              System.out.print("Descrição do produto [" + (i + 1) + "]:");
              String descricao = sc.next();

              System.out.print("Preço do produto [" + (i + 1) + "]:");
              double preco = sc.nextDouble();

              Produto produto = new Produto(nome, descricao, preco, tipo);

              produtos.add(produto);
            }

            pratileira.atualizarPratilheira(produtos, tipo);
          } catch (Exception err) {
            System.out.println(err.getMessage());
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

            Produto produto = new Produto(nome, descricao, preco, pratileira.getTipo());

            pratileira.adicionarProduto(produto);
          } catch (Exception err) {
            System.out.println("Error ao adicionar produto");
          }

        } else if (opPratileira == 4) {
          try {
            System.out.print("Qual tipo para listar? ");
            String tipoParaListar = sc.next();

            Pratileira pratileira = farmacia.showPratileiraDoTipo(tipoParaListar);

            System.out.print("Nome do produto: ");
            String nome = sc.next();

            pratileira.removerProduto(nome);
          } catch (Exception err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
          }
        } else if (opPratileira == 5) {
          try {
            System.out.print("Qual tipo para listar? ");
            String tipoParaListar = sc.next();

            Pratileira pratileira = farmacia.showPratileiraDoTipo(tipoParaListar);

            System.out.println(pratileira.listarProdutosDoTipo(tipoParaListar));
          } catch (Exception err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
          }
        }
      } else if (op == 2) {
        int opFuncionario = menuFuncionario(sc);

        if (opFuncionario == 1) {
          try {
            System.out.println("Informe os dados do Funcionário novo [Nome, Idade, Cpf e Função]: ");
            String nome = sc.next();
            int idade = sc.nextInt();
            String cpf = sc.next();
            String funcao = sc.next();
            gerente.adicionaFuncionario(new Funcionario(nome, idade, cpf, funcao));
          } catch (Exception err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
          }
        } else if (opFuncionario == 2) {
          try {
            System.out.println("Informe o CPF do Funcionário caso queira removelo: ");
            String cpf = sc.next();
            System.out.println(gerente.removerFuncionario(cpf));
          } catch (Exception err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
          }
        } else if (opFuncionario == 2) {
          try {
            System.out.println("Informe o CPF do Funcionário caso queira remover: ");
            String cpf = sc.next();
            System.out.println(gerente.removerFuncionario(cpf));
          } catch (Exception err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
          }
        } else if (opFuncionario == 3) {
          try {
            System.out.println("Informe o CPF do Funcionário para listar: ");
            String cpf = sc.next();
            System.out.println(gerente.buscaFuncionario(cpf));
          } catch (Exception err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
          }
        } else if (opFuncionario == 3) {
          try {
            System.out.println("Deseja buscar Funcionário [Informe o CPF]: ");
            String cpf = sc.next();
            gerente.buscaFuncionario(cpf);
          } catch (Exception err) {
            err.printStackTrace();
          }
        }
      } else if (op == 3) {
        int opPedido = menuPedido(sc);

        if (opPedido == 1) {
          try {
            System.out.print("Qual tipo para listar? ");
            String tipoParaListar = sc.next();

            Pratileira pratileira = farmacia.showPratileiraDoTipo(tipoParaListar);

            System.out.print("Quantidade de produtos para adicionar no pedido:");
            int quantidadeProdutos = sc.nextInt();

            ArrayList<Produto> produtos = new ArrayList<Produto>();

            for (int i = 0; i < quantidadeProdutos; i++) {
              System.out.print("Nome do produto [" + (i + 1) + "]:");
              String nome = sc.next();

              Produto produto = pratileira.showProduto(nome);

              produtos.add(produto);
            }

            Pedido pedido = new Pedido(produtos);

            farmacia.adicionaPedido(pedido);

            System.out.println("Pedido adicionado com sucesso.");
          } catch (Exception err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
          }
        } else if (opPedido == 2) {
          try {
            List<Pedido> pedidos = farmacia.getPedidos();
            System.out.println("Pedidos: \n" + pedidos);

            System.out.print("Qual dos pedidos quer verificar o total? ");
            int ID = sc.nextInt();
            Pedido pedidoParaTotal = farmacia.showPedido(ID);

            System.out.println("Total a pagar: " + farmacia.totalAPagar(pedidoParaTotal));
          } catch (Exception err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
          }

        } else if (opPedido == 3) {
          try {
            List<Pedido> pedidos = farmacia.getPedidos();
            System.out.println("Pedidos: \n" + pedidos);

            System.out.print("Qual dos pedidos quer verificar o total? ");
            int ID = sc.nextInt();
            Pedido pedidoParaTotal = farmacia.showPedido(ID);
            double total = farmacia.totalAPagar(pedidoParaTotal);

            System.out.println("Total: " + total);

            System.out.print("Quanto recebido do cliente? ");
            double recebido = sc.nextDouble();

            farmacia.finalizarPedido(pedidoParaTotal, total, recebido);

            System.out.println("Pedido finalizado com sucesso!");
          } catch (Exception err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
          }
        }
        System.out.println("3 - Finalizar pedido");
        System.out.println("4 - Cancelar pedido");
      }
      op = menu(sc);
    }

    System.out.print("Volte sempre!\n");
  }

}