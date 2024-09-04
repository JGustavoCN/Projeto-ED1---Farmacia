package br.edu.ifs.farmacia.controller;

import br.edu.ifs.farmacia.model.Venda;
import br.edu.ifs.farmacia.repository.VendaRepository;
import br.edu.ifs.farmacia.util.Lista;
import br.edu.ifs.farmacia.util.VendaJaExisteException;

public class VendaController {
    private final VendaRepository vendaRepository;
    private static VendaController instance;

    private VendaController() {
        this.vendaRepository = VendaRepository.getInstance();
    }

    public static VendaController getInstance() {
        if (instance == null) {
            instance = new VendaController();
        }
        return instance;
    }

    public void salvarDados() {
        vendaRepository.salvarTodos();
    }

    public boolean cadastrar(Venda venda) throws VendaJaExisteException {
        int resto = venda.getProduto().getQuantidadeEstoque()-venda.getQuantidade();
        venda.getProduto().setQuantidadeEstoque(resto);
        return vendaRepository.salvar(venda);
    }
    public boolean cadastrarTodos(Lista<Venda> vendas) throws VendaJaExisteException {
        for (int i = 0; i < vendas.tamanho(); i++) {
            if (!cadastrar(vendas.pegar(i))){
                return false;
            }
        }
        return true;
    }

    public Lista<Venda> lista() {
        return vendaRepository.buscarTodos();
    }

    public Lista<Venda> listaOrdenadaPorNome() {
        return vendaRepository.buscarTodosOrdenadoPorNome();
    }

}
