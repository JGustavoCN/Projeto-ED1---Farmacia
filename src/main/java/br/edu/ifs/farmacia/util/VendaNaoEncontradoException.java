package br.edu.ifs.farmacia.util;


public class VendaNaoEncontradoException extends Exception {

    /**
     * Creates a new instance of <code>ProdutoNaoEncontradoException</code>
     * without detail message.
     */
    public VendaNaoEncontradoException() {
    }

    /**
     * Constructs an instance of <code>ProdutoNaoEncontradoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public VendaNaoEncontradoException(String msg) {
        super(msg);
    }
}
