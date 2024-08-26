package br.edu.ifs.farmacia.repository;

import br.edu.ifs.farmacia.model.Produto;
import br.edu.ifs.farmacia.persistence.ProdutoDataManager;
import br.edu.ifs.farmacia.util.Lista;
import br.edu.ifs.farmacia.util.ProdutoJaExisteException;
import br.edu.ifs.farmacia.util.ProdutoNaoEncontradoException;
import java.io.Serializable;

/**
 *
 * @author Aluno
 */
public class ProdutoRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    private Lista<Produto> produtos;
    
    public Produto buscarPorCodigo(int codigo) throws ProdutoNaoEncontradoException {
        for (int i = 0; i < produtos.tamanho(); i++) {
            if (produtos.pegar(i).getCodigo() == codigo) {
                return produtos.pegar(i);
            }
        }
        throw new ProdutoNaoEncontradoException("Produto com código " + codigo + " não encontrado.");
    }

    public void salvarTodos(){
        ProdutoDataManager.salvar(this);
    }
    
    public boolean salvar(Produto produto) throws ProdutoJaExisteException {
        if (produtos.contem(produto) ) {
            throw new ProdutoJaExisteException("Produto com código " + produto.getCodigo() + " já existe.");
        }
        return produtos.adicionar(produto);
    }

    public Lista<Produto> buscarTodos() {
        return produtos;
    }

    public Lista<Produto> buscarTodosOrdenadoPorNome() {
        Lista<Produto> produtosOrdenados = new Lista<>();
        // Adiciona todos os produtos na lista de produtosOrdenados
        for (int i = 0; i < produtos.tamanho(); i++) {
            produtosOrdenados.adicionarUltimo(produtos.pegar(i));
        }

        // Ordena a lista de produtos por nome
        produtosOrdenados.ordenar((Produto p1, Produto p2) -> p1.getNome().compareToIgnoreCase(p2.getNome()));

        return produtosOrdenados;
    }
    
    private ProdutoRepository() {
        produtos = new Lista<>();
        // Exemplo de dados para criar um objeto Produto
        String nome = "Paracetamol";
        int codigo = 123;
        String descricao = "Analgésico e antipirético usado para aliviar dor e febre.";
        String marca = "Farmácia ABC";
        double valorEntrada = 10; // R$ 10,00 convertido para centavos
        double valorSaida = 20; // R$ 20,00 convertido para centavos
        int quantidadeEstoque = 10;

        // Cria o objeto Produto
        Produto produto = new Produto(nome, codigo, descricao, marca, valorEntrada, valorSaida, quantidadeEstoque);

        produtos.adicionar(produto);
    }
    
    public static ProdutoRepository getInstance() {
        if (instance == null) {
            instance = ProdutoDataManager.carregar();
        }
        
        return instance;
    }
    private static ProdutoRepository instance;
}
