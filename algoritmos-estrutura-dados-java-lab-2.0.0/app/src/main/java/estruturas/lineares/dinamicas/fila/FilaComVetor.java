package estruturas.lineares.dinamicas.fila;

import java.util.Iterator;
import java.util.Objects;

import estruturas.lineares.estaticas.vetor.TDAVetor;
import estruturas.lineares.estaticas.vetor.VetorTamanhoVariavel;

public class FilaComVetor<T> implements IFila<T> {

    private final TDAVetor<T> dados;

    public FilaComVetor() {
        this.dados = new VetorTamanhoVariavel<>();
    }

    public FilaComVetor(int capacidade) {
        this.dados = new VetorTamanhoVariavel<>(capacidade);
    }

    @Override
    public int tamanho() {
        return this.dados.tamanho();
    }

    @Override
    public boolean estaVazia() {
        return this.dados.estaVazio();
    }

    @Override
    public void limpar() {
        this.dados.limpar();
    }

    @Override
    public boolean contem(T dado) {
        return this.dados.contem(dado);
    }

    @Override
    public T obterFrente() {
        if (this.estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }
        return this.dados.obter(0);
    }

    @Override
    public void enfileirar(T dado) {
        this.dados.adicionar(dado);
    }

    @Override
    public T desenfileirar() {
        if (this.estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }
        return this.dados.remover(0);
    }

    @Override
    public int distancia(T dado) {
        // Percorre o vetor a partir da frente (índice 0) até o fim
        for (int i = 0; i < this.dados.tamanho(); i++) {
            T dadoAtual = this.dados.obter(i);
            // Verifica se encontrou o dado
            if (Objects.equals(dado, dadoAtual)) {
                // Retorna a posição relativa à frente
                return i;
            }
        }
        // Elemento não encontrado na fila
        return -1;
    }

    @Override
    public String imprimir() {
        return this.dados.imprimir();
    }

    @Override
    public Iterator<T> iterator() {
        return this.dados.iterator();
    }

}