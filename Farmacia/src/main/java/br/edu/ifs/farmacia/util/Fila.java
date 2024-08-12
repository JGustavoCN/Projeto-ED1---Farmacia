package br.edu.ifs.farmacia.util;

/**
 *
 * @author José Gustavo
 * @param <E>
 */
public class Fila<E> {

    private No<E> primeiro;
    private No<E> ultimo;
    private int tamanho;

    public Fila() {
    }

    public boolean enfileirar(E elemento) {
        No<E> no = new No(elemento);
        if (estaVazia()) {
            primeiro = no;
        } else {
            ultimo.setProximo(no);
        }
        ultimo = no;
        tamanho++;
        return true;
    }

    private void add(E elemento) {
        // Forma sem saber o ultimo No
        if (estaVazia()) {
            primeiro = new No(elemento);
        } else {
            No<E> no = primeiro;
            for (int i = 1; i < tamanho; i++) {
                no = no.getProximo();
            }
            no.setProximo(new No(elemento));
        }
    }

    public E desenfileirar() {
        if (estaVazia()) throw new VaziaException("Fila Vazia");
        final No<E> no = primeiro.recortar();
        primeiro = no.getProximo();
        tamanho--;
        if (estaVazia()) ultimo = null; 
        return no.getElemento();
    }

    public E primeiro() {
        if (estaVazia()) throw new VaziaException("Fila Vazia");
        return primeiro.getElemento();
    }

    public void limpar() {
        for (No atual = primeiro; atual != null; atual = atual.recortar().getProximo()){}
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }
    
    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public String toString() {
        if (estaVazia() || primeiro == null) return "[]";
        
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(primeiro.getElemento());
        No<E> no = primeiro;
        while (no.getProximo() != null) {
            no = no.getProximo();
            sb.append(", ").append(no.getElemento());
        }
        return sb.append("]").toString();
    }
}
