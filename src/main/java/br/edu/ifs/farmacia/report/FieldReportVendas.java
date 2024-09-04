package br.edu.ifs.farmacia.report;

public class FieldReportVendas {

    private String n;
    private String codigo;
    private String nome;
    private String marca;
    private String valorUnidade;
    private String quantidade;
    private String valorTotal;

    public FieldReportVendas(String n, String codigo, String nome, String marca, String valorUnidade, String quantidade, String valorTotal) {
        this.n = n;
        this.nome = nome;
        this.codigo = codigo;
        this.marca = marca;
        this.valorUnidade = valorUnidade;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    /**
     * @return the n
     */
    public String getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(String n) {
        this.n = n;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the valorUnidade
     */
    public String getValorUnidade() {
        return valorUnidade;
    }

    /**
     * @param valorUnidade the valorUnidade to set
     */
    public void setValorUnidade(String valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    /**
     * @return the quantidade
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorTotal
     */
    public String getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

}
