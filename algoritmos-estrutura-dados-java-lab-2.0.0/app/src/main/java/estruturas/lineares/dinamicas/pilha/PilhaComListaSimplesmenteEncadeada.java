package estruturas.lineares.dinamicas.pilha;

import java.util.Iterator;
import java.util.NoSuchElementException;
//import java.util.Objects;

import estruturas.lineares.dinamicas.lista.IListaSimplesmenteEncadeada;
import estruturas.lineares.dinamicas.lista.ListaSimplesmenteEncadeada;

public class PilhaComListaSimplesmenteEncadeada<T> implements IPilha<T> {

    private final IListaSimplesmenteEncadeada<T> lista;

    public PilhaComListaSimplesmenteEncadeada() {
        this.lista = new ListaSimplesmenteEncadeada<>();
    }

    @Override
    public int tamanho() {
        return this.lista.tamanho();
    }

    @Override
    public boolean estaVazia() {
        return this.lista.estaVazia();
    }

    @Override
    public void limpar() {
        this.lista.limpar();
    }

    @Override
    public boolean contem(T dado) {
        return this.lista.contem(dado);
    }

    @Override
    public T obterTopo() {
        if (this.estaVazia()) {
            throw new NoSuchElementException("A pilha esta Vazia");
        }
        return this.lista.obterPrimeiroNo().obterDado();
    }

    @Override
    public void empilhar(T dado) {
        this.lista.adicionar(dado);
    }

    @Override
    public T desempilhar() {
        if (this.estaVazia()) {
            throw new NoSuchElementException("A pilha esta Vazia");
        }
        T dadoDoTopo = this.obterTopo();
        this.lista.removerInicio();
        return dadoDoTopo;
    }

    @Override
    public int distancia(T dado) {
        return this.lista.posicao(dado);
    }

    @Override
    public String imprimir() {
        return this.lista.imprimir();
    }

    @Override
    public Iterator<T> iterator() {
        return this.lista.iterator();
    }

}