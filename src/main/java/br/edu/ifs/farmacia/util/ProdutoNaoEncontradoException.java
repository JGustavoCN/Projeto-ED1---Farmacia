package br.edu.ifs.farmacia.util;


public class ProdutoNaoEncontradoException extends Exception {

    /**
     * Creates a new instance of <code>ProdutoNaoEncontradoException</code>
     * without detail message.
     */
    public ProdutoNaoEncontradoException() {
    }

    /**
     * Constructs an instance of <code>ProdutoNaoEncontradoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ProdutoNaoEncontradoException(String msg) {
        super(msg);
    }
}
