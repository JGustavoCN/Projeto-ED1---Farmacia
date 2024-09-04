package br.edu.ifs.farmacia.report;

public class FieldReportEstoque {

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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
     * @return the entrada
     */
    public String getEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    /**
     * @return the saida
     */
    public String getSaida() {
        return saida;
    }

    /**
     * @param saida the saida to set
     */
    public void setSaida(String saida) {
        this.saida = saida;
    }

    public FieldReportEstoque(String n,  String codigo, String nome, String marca, String descricao, String quantidade, String entrada, String saida) {
        this.n = n;
        this.nome = nome;
        this.codigo = codigo;
        this.marca = marca;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.entrada = entrada;
        this.saida = saida;
    }
    
    private String n;
    private String nome;
    private String codigo;
    private String marca;
    private String descricao;
    private String quantidade;
    private String entrada;
    private String saida;
    
    
}
