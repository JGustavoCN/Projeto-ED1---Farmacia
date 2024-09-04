package br.edu.ifs.farmacia.report;

import java.util.List;

public class ParameterReportEstoque {
    
    private String totalEntrada;
    private String totalSaida;
    private String totalLucro;
    private String totalQuantidade;
    private List<FieldReportEstoque> fields;

    public ParameterReportEstoque(String totalEntrada, String totalSaida, String totalLucro, String totalQuantidade, List<FieldReportEstoque> fields) {
        this.totalEntrada = totalEntrada;
        this.totalSaida = totalSaida;
        this.totalLucro = totalLucro;
        this.totalQuantidade = totalQuantidade;
        this.fields = fields;
    }

    public String getTotalEntrada() {
        return totalEntrada;
    }

    public void setTotalEntrada(String totalEntrada) {
        this.totalEntrada = totalEntrada;
    }

    public String getTotalSaida() {
        return totalSaida;
    }

    public void setTotalSaida(String totalSaida) {
        this.totalSaida = totalSaida;
    }

    public String getTotalLucro() {
        return totalLucro;
    }

    public void setTotalLucro(String totalLucro) {
        this.totalLucro = totalLucro;
    }

    public String getTotalQuantidade() {
        return totalQuantidade;
    }

    public void setTotalQuantidade(String totalQuantidade) {
        this.totalQuantidade = totalQuantidade;
    }

    public List<FieldReportEstoque> getFields() {
        return fields;
    }

    public void setFields(List<FieldReportEstoque> fields) {
        this.fields = fields;
    }

    
}
