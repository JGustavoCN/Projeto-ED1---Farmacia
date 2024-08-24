package br.edu.ifs.farmacia.util;

public class ProdutoJaExisteException extends Exception{

    /**
     * Creates a new instance of <code>ProdutoJaExisteException</code> without
     * detail message.
     */
    public ProdutoJaExisteException() {
    }

    /**
     * Constructs an instance of <code>ProdutoJaExisteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ProdutoJaExisteException(String msg) {
        super(msg);
    }
}
