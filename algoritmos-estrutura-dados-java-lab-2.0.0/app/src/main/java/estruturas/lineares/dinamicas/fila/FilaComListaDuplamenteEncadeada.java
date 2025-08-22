package estruturas.lineares.dinamicas.fila;

import java.util.Iterator;

import estruturas.lineares.dinamicas.lista.IListaDuplamenteEncadeada;
import estruturas.lineares.dinamicas.lista.ListaDuplamenteEncadeada;

public class FilaComListaDuplamenteEncadeada<T> implements IFila<T> {

    private IListaDuplamenteEncadeada<T> lista;

    public FilaComListaDuplamenteEncadeada() {
        this.lista = new ListaDuplamenteEncadeada<>();
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
    public T obterFrente() {
        if (this.estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }
        return this.lista.obterPrimeiroNo().obterDado();
    }

    @Override
    public void enfileirar(T dado) {
        this.lista.adicionarFim(dado);
    }

    @Override
    public T desenfileirar() {
        if (this.estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }
        T frente = this.obterFrente();
        lista.removerInicio();
        return frente;
    }

    @Override
    public int distancia(T dado) {
        if (!this.contem(dado)) {
            return -1;
        }

        int distancia = 0;
        Iterator<T> iterator = this.lista.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(dado)) {
                return distancia;
            }
            distancia++;
        }
        return -1;
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