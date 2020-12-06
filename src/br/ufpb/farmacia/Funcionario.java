package br.ufpb.farmacia;

import java.util.Objects;

public class Funcionario extends Pessoa {
    private String funcao;

    public Funcionario(String funcao, String nome, int idade, String cpf) {
        super(nome, idade, cpf);
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.funcao);
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
        if (!Objects.equals(this.funcao, other.funcao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "CPF: " + getCpf();
    }
    
    
}
