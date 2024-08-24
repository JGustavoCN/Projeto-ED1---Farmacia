package br.edu.ifs.farmacia.util;

/**
 *
 * @author José Gustavo
 * @param <E> Tipo do Nó
 */
public class Pilha<E> {
    
    private No<E> topo;
    private int tamanho;

    public Pilha() {
    }
    
    public boolean empilhar(E elemento){
        topo = new No<E>(elemento, topo);
        tamanho++;
        return true;
    }
    
    public E desempilhar(){
        if (estaVazia()) throw new VaziaException("Pilha esta vazia");
        E elemento = topo.getElemento();
        No<E> no = topo;
        topo = topo.getProximo();
        no.setElemento(null);
        no.setProximo(null);
        tamanho--;
        return elemento;
    }
    
    public E topo (){
        return topo.getElemento();
    }
    
    public int tamanho(){
        return tamanho;
    }
    
    public boolean estaVazia(){
        return tamanho == 0;
    }

    @Override
    public String toString() {
        if (estaVazia()) return "[]"; 
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(topo.getElemento());
        No<E> no = topo;
        while (no.getProximo() != null) {
            no = no.getProximo();
            sb.append(",").append(no.getElemento());
        }
        return sb.append("]").toString();
    }
    
}
