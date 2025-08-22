package estruturas.lineares.dinamicas.lista;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ListaDuplamenteEncadeada<T> implements IListaDuplamenteEncadeada<T>, Iterable<T> {

    private final INoListaDuplamenteEncadeada<T> noCabeca;
    private int quantidadeNos;

    public ListaDuplamenteEncadeada() {
        this.noCabeca = new NoListaDuplamenteEncadeada<>(null);
        this.noCabeca.definirProximoNo(this.noCabeca);
        this.noCabeca.definirNoAnterior(this.noCabeca);
        this.quantidadeNos = 0;
    }

    // Retorna o primeiro nó real da lista, ou null se estiver vazia.
    @Override
    public INoListaDuplamenteEncadeada<T> obterPrimeiroNo() {
        return estaVazia() ? null : this.noCabeca.obterProximoNo();
    }

    // Retorna o último nó real da lista, ou null se estiver vazia.
    @Override
    public INoListaDuplamenteEncadeada<T> obterUltimoNo() {
        return estaVazia() ? null : this.noCabeca.obterNoAnterior();
    }

    // Esvazia a lista.
    @Override
    public void limpar() {
        this.noCabeca.definirProximoNo(this.noCabeca);
        this.noCabeca.definirNoAnterior(this.noCabeca);
        this.quantidadeNos = 0;
    }

    // Retorna a quantidade de elementos armazenados na lista.
    @Override
    public int tamanho() {
        return this.quantidadeNos;
    }

    // Verifica se um dado específico está presente na lista.
    @Override
    public boolean contem(T dado) {
        INoListaDuplamenteEncadeada<T> noAtual = this.noCabeca.obterProximoNo();
        while (noAtual != this.noCabeca) {
            if (Objects.equals(noAtual.obterDado(), dado)) {
                return true;
            }
            noAtual = noAtual.obterProximoNo();
        }
        return false;
    }

    // Verifica se a lista não possui elementos.
    @Override
    public boolean estaVazia() {
        return this.quantidadeNos == 0;
    }

    // Adiciona um dado no início da lista.
    @Override
    public void adicionar(T dado) {
        adicionar(dado, 0);
    }

    // Adiciona um dado em uma posição específica da lista.
    @Override
    public void adicionar(T dado, int posicao) {
        if (posicao < 0 || posicao > this.quantidadeNos) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }
        INoListaDuplamenteEncadeada<T> noAtual = this.noCabeca;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.obterProximoNo();
        }
        INoListaDuplamenteEncadeada<T> novoNo = new NoListaDuplamenteEncadeada<>(dado);
        novoNo.definirProximoNo(noAtual.obterProximoNo());
        novoNo.definirNoAnterior(noAtual);
        noAtual.obterProximoNo().definirNoAnterior(novoNo);
        noAtual.definirProximoNo(novoNo);
        this.quantidadeNos++;
    }

    // Adiciona um dado no final da lista.
    @Override
    public void adicionarFim(T dado) {
        adicionar(dado, this.quantidadeNos);
    }

    // Remove o primeiro elemento da lista.
    @Override
    public void removerInicio() {
        if (!estaVazia()) {
            remover(0);
        }
    }

    // Remove o último elemento da lista.
    @Override
    public void removerFim() {
        if (!estaVazia()) {
            remover(this.quantidadeNos - 1);
        }
    }

    // Remove um elemento de uma posição específica.
    @Override
    public void remover(int posicao) {
        if (posicao < 0 || posicao >= this.quantidadeNos) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }
        INoListaDuplamenteEncadeada<T> noParaRemover = this.noCabeca.obterProximoNo();
        for(int i = 0; i < posicao; i++){
            noParaRemover = noParaRemover.obterProximoNo();
        }
        INoListaDuplamenteEncadeada<T> noAnterior = noParaRemover.obterNoAnterior();
        INoListaDuplamenteEncadeada<T> proximoNo = noParaRemover.obterProximoNo();
        noAnterior.definirProximoNo(proximoNo);
        proximoNo.definirNoAnterior(noAnterior);
        this.quantidadeNos--;
    }

    // Retorna uma representação em String de todos os dados da lista.
    @Override
    public String imprimir() {
        if (estaVazia()) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        INoListaDuplamenteEncadeada<T> noAtual = this.noCabeca.obterProximoNo();
        while (noAtual != this.noCabeca) {
            stringBuilder.append(noAtual.obterDado());
            noAtual = noAtual.obterProximoNo();
            if (noAtual != this.noCabeca) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // Retorna um iterador para percorrer os elementos da lista.
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private INoListaDuplamenteEncadeada<T> noAtual = noCabeca.obterProximoNo();
            @Override
            public boolean hasNext() {
                return noAtual != noCabeca;
            }
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T dado = noAtual.obterDado();
                noAtual = noAtual.obterProximoNo();
                return dado;
            }
        };
    }
}