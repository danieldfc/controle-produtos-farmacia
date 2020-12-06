package br.ufpb.farmacia;

import java.util.Objects;

public class Funcionario extends Pessoa {
    private String cpfFunc;

    public Funcionario(String cpf, String nome, int idade) {
        super(nome, idade);
        this.cpfFunc = cpf;
    }

    public String getCpf() {
        return cpfFunc;
    }

    public void setCpf(String cpf) {
        this.cpfFunc = cpf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.cpfFunc);
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
        if (!Objects.equals(this.cpfFunc, other.cpfFunc)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "Cpf: " + cpfFunc;
    }
}
