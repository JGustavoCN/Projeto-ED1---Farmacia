package br.edu.ifs.farmacia.controller;

import br.edu.ifs.farmacia.model.Produto;
import br.edu.ifs.farmacia.repository.ProdutoRepository;
import br.edu.ifs.farmacia.util.Lista;
import br.edu.ifs.farmacia.util.ProdutoJaExisteException;

public class ProdutoController {

    private final ProdutoRepository produtoRepository;
    private static ProdutoController instance;

    private ProdutoController() {
        this.produtoRepository = ProdutoRepository.getInstance();
    }
    public static ProdutoController getInstance(){
        if(instance == null){
            instance = new ProdutoController();
        }
        return instance;
    }

    public boolean cadastrar(Produto produto) {
        try {
            return produtoRepository.salvar(produto);
        } catch (ProdutoJaExisteException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Lista<Produto> lista() {
        return produtoRepository.buscarTodos();
    }

    public Lista<Produto> listaOrdenadaPorNome() {
        return produtoRepository.buscarTodosOrdenadoPorNome();
    }
}
