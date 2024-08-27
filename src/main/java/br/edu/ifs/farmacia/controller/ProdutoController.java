package br.edu.ifs.farmacia.controller;

import br.edu.ifs.farmacia.model.Produto;
import br.edu.ifs.farmacia.repository.ProdutoRepository;
import br.edu.ifs.farmacia.util.Lista;
import br.edu.ifs.farmacia.util.ProdutoJaExisteException;
import br.edu.ifs.farmacia.util.ProdutoNaoEncontradoException;

public class ProdutoController {

    private final ProdutoRepository produtoRepository;
    private static ProdutoController instance;

    private ProdutoController() {
        this.produtoRepository = ProdutoRepository.getInstance();
    }

    public static ProdutoController getInstance() {
        if (instance == null) {
            instance = new ProdutoController();
        }
        return instance;
    }

    public void salvarDados() {
        produtoRepository.salvarTodos();
    }

    public boolean cadastrar(Produto produto) throws ProdutoJaExisteException {
        return produtoRepository.salvar(produto);
    }

    public Lista<Produto> lista() {
        return produtoRepository.buscarTodos();
    }

    public Lista<Produto> listaOrdenadaPorNome() {
        return produtoRepository.buscarTodosOrdenadoPorNome();
    }

    public void atualizar(Produto dataEdit) {
        try {
            Produto produto = produtoRepository.buscarPorCodigo(dataEdit.getCodigo());
            produto.setValorEntrada(dataEdit.getValorEntrada());
            produto.setValorSaida(dataEdit.getValorSaida());
            produto.setQuantidadeEstoque(dataEdit.getQuantidadeEstoque());
        } catch (ProdutoNaoEncontradoException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
