package br.edu.ifs.farmacia.util;

public class VendaJaExisteException extends Exception{

    /**
     * Creates a new instance of <code>ProdutoJaExisteException</code> without
     * detail message.
     */
    public VendaJaExisteException() {
    }

    /**
     * Constructs an instance of <code>ProdutoJaExisteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public VendaJaExisteException(String msg) {
        super(msg);
    }
}
