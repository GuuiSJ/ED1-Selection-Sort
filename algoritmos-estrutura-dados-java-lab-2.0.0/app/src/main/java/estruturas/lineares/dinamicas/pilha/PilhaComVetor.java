package estruturas.lineares.dinamicas.pilha;

import java.util.Iterator;
import java.util.Objects;

import estruturas.lineares.estaticas.vetor.TDAVetor;
import estruturas.lineares.estaticas.vetor.VetorTamanhoVariavel;

public class PilhaComVetor<T> implements IPilha<T> {

    private final TDAVetor<T> dados;

    public PilhaComVetor() {
        this.dados = new VetorTamanhoVariavel<>();
    }

    public PilhaComVetor(int capacidade) {
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
    public T obterTopo() {
        if (this.estaVazia()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return this.dados.obter(dados.tamanho() - 1);
    }

    @Override
    public void empilhar(T dado) {
        this.dados.adicionar(dado); // Adiciona no fim fo vetor (topo da pilha)
    }

    @Override
    public T desempilhar() {
        if (this.estaVazia()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return this.dados.remover(this.dados.tamanho() - 1);
    }

    @Override
    public int distancia(T dado) {
         // Percorre do topo (último elemento) para a base (primeiro elemento)
         for (int i = this.dados.tamanho() - 1, distancia = 0; i >= 0; i--, distancia++) {
            if (Objects.equals(this.dados.obter(i), dado)) {
                return distancia;
            }
        }
        return -1; // Elemento não encontrado
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