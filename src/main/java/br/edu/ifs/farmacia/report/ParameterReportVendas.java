package br.edu.ifs.farmacia.report;

import java.util.List;

public class ParameterReportVendas {
    
    private String totalVendido;
    private String totalQuantidade;
    private List<FieldReportVendas> fields;

    public ParameterReportVendas(String totalVendido, String totalQuantidade, List<FieldReportVendas> fields) {
        this.totalVendido = totalVendido;
        this.totalQuantidade = totalQuantidade;
        this.fields = fields;
    }

    /**
     * @return the totalVendido
     */
    public String getTotalVendido() {
        return totalVendido;
    }

    /**
     * @param totalVendido the totalVendido to set
     */
    public void setTotalVendido(String totalVendido) {
        this.totalVendido = totalVendido;
    }

    /**
     * @return the totalQuantidade
     */
    public String getTotalQuantidade() {
        return totalQuantidade;
    }

    /**
     * @param totalQuantidade the totalQuantidade to set
     */
    public void setTotalQuantidade(String totalQuantidade) {
        this.totalQuantidade = totalQuantidade;
    }

    /**
     * @return the fields
     */
    public List<FieldReportVendas> getFields() {
        return fields;
    }

    /**
     * @param fields the fields to set
     */
    public void setFields(List<FieldReportVendas> fields) {
        this.fields = fields;
    }

   
    
}
