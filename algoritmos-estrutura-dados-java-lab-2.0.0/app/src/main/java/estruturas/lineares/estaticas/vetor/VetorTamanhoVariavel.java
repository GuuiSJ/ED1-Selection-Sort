package estruturas.lineares.estaticas.vetor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class VetorTamanhoVariavel<T> implements TDAVetor<T>,Iterable<T> {

    private static final int CAPACIDADE_PADRAO = 10;
    private int tamanho;
    private T[] elementos;

    public VetorTamanhoVariavel() {
        this(CAPACIDADE_PADRAO);
    }

    @SuppressWarnings("unchecked")
    public VetorTamanhoVariavel(int capacidade) {
        if (capacidade < 0) {
            throw new IllegalArgumentException("A capacidade do vetor não pode ser negativa");
        }
        this.tamanho = 0;
        this.elementos = (T[]) new Object[capacidade];
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public boolean estaVazio() {
        return this.tamanho == 0;
    }

    @Override
    public void verificarIndice(int indice, int minimo, int maximo) {
        if (indice < minimo || indice > maximo) {
            throw new IndexOutOfBoundsException(
                    String.format("Índice: %d, Tamanho: %d", indice, this.tamanho)
            );
        }
    }

    @Override
    public void verificarCapacidade() {
        if (this.tamanho == this.elementos.length) {
            int novaCapacidade = this.elementos.length == 0 ? 1 : this.elementos.length * 2;
            redimensionar(novaCapacidade);
        }
    }

    private void verificarReducaoCapacidade() {
        if (this.tamanho > 0 && this.tamanho <= this.elementos.length / 4) {
            int novaCapacidade = Math.max(this.elementos.length / 2, CAPACIDADE_PADRAO);
            redimensionar(novaCapacidade);
        }
    }

    @SuppressWarnings("unchecked")
    private void redimensionar(int novaCapacidade) {
        T[] novoVetor =  (T[]) new Object[novaCapacidade];
        System.arraycopy(this.elementos, 0, novoVetor, 0, this.tamanho);
        this.elementos = novoVetor;
    }

    @Override
    public int obterIndiceDo(T elemento) {
        for (int indice = 0; indice < this.tamanho; indice++) {
            if (Objects.equals(elemento, this.elementos[indice])) {
                return indice;
            }
        }
        return -1;
    }

    @Override
    public boolean contem(T elemento) {
        return this.obterIndiceDo(elemento) != -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void limpar() {
        this.elementos = (T[]) new Object[this.tamanho];
        this.tamanho = 0;
        redimensionar(CAPACIDADE_PADRAO);
    }

    @Override
    public T obter(int indice) throws IndexOutOfBoundsException {
        this.verificarIndice(indice, 0, this.tamanho - 1);
        return (T) this.elementos[indice];
    }

    @Override
    public void atualizar(int indice, T elemento) throws IndexOutOfBoundsException {
        this.verificarIndice(indice, 0, this.tamanho - 1);
        this.elementos[indice] = elemento;
    }

    @Override
    public void adicionar(T elemento) {
        this.verificarCapacidade();
        this.elementos[this.tamanho++] = elemento;
    }

    @Override
    public void adicionar(int indice, T elemento) throws IndexOutOfBoundsException {
        this.verificarIndice(indice, 0, this.tamanho);
        this.verificarCapacidade();
        System.arraycopy(this.elementos, indice, this.elementos, indice + 1, this.tamanho - indice);
        this.elementos[indice] = elemento;
        this.tamanho++;
    }

    @Override
    public void adicionarInicio(T elemento) {
        this.adicionar(0, elemento);
    }

    public void adicionarTodos(T[] novosElementos) {
        if (novosElementos == null || novosElementos.length == 0) {
            return;
        }
        int tamanhoFinal = this.tamanho + novosElementos.length;
        if (tamanhoFinal > this.elementos.length) {
            int novaCapacidade, capacidadeDobro = this.elementos.length * 2;
            if (tamanhoFinal > capacidadeDobro) {
                novaCapacidade = tamanhoFinal;
            } else {
                novaCapacidade = capacidadeDobro;
            }
            redimensionar(novaCapacidade);
        }
        System.arraycopy(novosElementos, 0, this.elementos, this.tamanho, novosElementos.length);
        this.tamanho += novosElementos.length;
    }

    @Override
    public T remover(int indice) throws IndexOutOfBoundsException {
        this.verificarIndice(indice, 0, this.tamanho - 1);
        T elementoRemovido = (T) this.elementos[indice];

        int numeroElementosDeslocados = this.tamanho - indice - 1;
        if (numeroElementosDeslocados > 0) {
            System.arraycopy(this.elementos, indice + 1, this.elementos, indice, numeroElementosDeslocados);
        }
        this.elementos[--this.tamanho] = null;
        this.verificarReducaoCapacidade();
        return elementoRemovido;
    }

    @Override
    public void removerElemento(T elemento) {
        if (this.contem(elemento)) {
            int indice = this.obterIndiceDo(elemento);
            this.remover(indice);
        }
    }

    @Override
    public void removerInicio() {
        this.remover(0);
    }

    @Override
    public void removerFim() {
        this.remover(this.tamanho - 1);
    }

    @Override
    public String imprimir() {
        return Arrays.toString(Arrays.copyOf(this.elementos, this.tamanho));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int indice = 0;

            @Override
            public boolean hasNext() {
                return indice < tamanho;
            }

            @Override
            public T next() throws NoSuchElementException  {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elementos[indice++];
            }
        };
    }

}