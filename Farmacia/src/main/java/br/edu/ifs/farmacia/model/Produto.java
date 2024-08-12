package br.edu.ifs.farmacia.model;

/**
 *
 * @author Aluno
 */
public class Produto {

    private int codigo;
    private int descricao;
    private int marca;
    private int valorEntrada;
    private int valorSaida;
    private int quantidadeEstoque;

    public Produto(int codigo, int descricao, int marca, int valorEntrada, int valorSaida, int quantidadeEstoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.marca = marca;
        this.valorEntrada = valorEntrada;
        this.valorSaida = valorSaida;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Produto() {
    }

    public int getCódigo() {
        return codigo;
    }

    public void setCódigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDescrição() {
        return descricao;
    }

    public void setDescrição(int descricao) {
        this.descricao = descricao;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(int valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public int getValorSaída() {
        return valorSaida;
    }

    public void setValorSaída(int valorSaida) {
        this.valorSaida = valorSaida;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.codigo;
        hash = 83 * hash + this.descricao;
        hash = 83 * hash + this.marca;
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
        final Produto other = (Produto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.descricao != other.descricao) {
            return false;
        }
        return this.marca == other.marca;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", descricao=" + descricao + ", marca=" + marca + ", valorEntrada=" + valorEntrada + ", valorSaida=" + valorSaida + ", quantidadeEstoque=" + quantidadeEstoque + '}';
    }

}
