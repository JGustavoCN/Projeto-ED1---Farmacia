package br.edu.ifs.farmacia.util;

public class ProdutoNaoPodeSerVendidoException extends Exception{

    /**
     * Creates a new instance of <code>ProdutoJaExisteException</code> without
     * detail message.
     */
    public ProdutoNaoPodeSerVendidoException() {
    }

    /**
     * Constructs an instance of <code>ProdutoJaExisteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ProdutoNaoPodeSerVendidoException(String msg) {
        super(msg);
    }
}
