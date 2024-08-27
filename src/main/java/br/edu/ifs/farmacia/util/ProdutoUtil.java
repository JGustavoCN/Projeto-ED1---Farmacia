package br.edu.ifs.farmacia.util;

import br.edu.ifs.farmacia.model.Produto;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ProdutoUtil {
    
    public static Object[] produtoToTableRow(Produto produto, int rowNum){
        NumberFormat nf = new DecimalFormat("$ #,##0.##");
        Object[] produtoToTableRow = new Object[]{
            false, 
            rowNum, 
            produto.getCodigo(),
            produto, 
            produto.getMarca(),
            produto.getDescricao(),
            produto.getQuantidadeEstoque(), 
            nf.format(produto.getValorEntrada()), 
            nf.format(produto.getValorSaida())
        };
        return produtoToTableRow;
    }
    
}
