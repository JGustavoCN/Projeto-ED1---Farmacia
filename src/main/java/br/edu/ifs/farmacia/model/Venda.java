package br.edu.ifs.farmacia.model;

import br.edu.ifs.farmacia.util.ProdutoNaoPodeSerVendidoException;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Aluno
 */
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;  
    private UUID id;
    private Produto produto;
    private int quantidade;
    private double total;
    private double valorVendido;

    public Venda(Produto produto, int quantidade) throws ProdutoNaoPodeSerVendidoException {
        if (!produto.isVendivel(quantidade)) throw new ProdutoNaoPodeSerVendidoException("Produto ["+ produto.getNome()+"] não pode ser vendido, estoque insuficiente para venda");
        this.id = UUID.randomUUID();
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorVendido = produto.getValorSaida();
        this.total = produto.getValorSaida()*quantidade;
    }
    public Venda(Produto produto) throws ProdutoNaoPodeSerVendidoException {
        this(produto, 1);
    }

    public UUID getId() {
        return id;
    }

    public double getValorVendido() {
        return valorVendido;
    }

    public void setValorVendido(double valorVendido) {
        this.valorVendido = valorVendido;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws ProdutoNaoPodeSerVendidoException {
        if (!produto.isVendivel(quantidade)) throw new ProdutoNaoPodeSerVendidoException("Produto não pode ser vendido quantidade vendida acima do valor em estoque");
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Venda other = (Venda) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", produto=" + produto + ", quantidade=" + quantidade + ", total=" + total + ", valorVendido=" + valorVendido + '}';
    }

    
}
