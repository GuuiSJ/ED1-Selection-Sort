package estruturas.lineares.estaticas.vetor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class VetorTamanhoFixo<T> implements TDAVetor<T>,Iterable<T> {

    private int tamanho;
    private T[] elementos;

    @SuppressWarnings("unchecked")
    public VetorTamanhoFixo(int capacidade) {
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
            throw new IllegalStateException("Capacidade máxima atingida.");
        }
    }

    @Override
    public int obterIndiceDo(T elemento) {
        for (int indice = 0; indice < tamanho; indice++) {
            if (Objects.equals(elemento, this.elementos[indice])) {
                return indice;
            }
        }
        return -1;
    }

    @Override
    public boolean contem(T elemento) {
        return obterIndiceDo(elemento) != -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void limpar() {
        this.elementos = (T[]) new Object[this.tamanho];
        this.tamanho = 0;
    }

    @Override
    public T obter(int indice) throws IndexOutOfBoundsException {
        verificarIndice(indice, 0, this.tamanho - 1);
        return (T) this.elementos[indice];
    }

    @Override
    public void atualizar(int indice, T elemento) throws IndexOutOfBoundsException {
        verificarIndice(indice, 0, this.tamanho - 1);
        this.elementos[indice] = elemento;
    }

    @Override
    public void adicionar(T elemento) {
       verificarCapacidade();
       this.elementos[this.tamanho++] = elemento;
    }

    @Override
    public void adicionar(int indice, T elemento) throws IndexOutOfBoundsException {
        verificarCapacidade();
        verificarIndice(indice, 0, this.tamanho);
        if (indice < this.tamanho){
            System.arraycopy(this.elementos, indice, this.elementos, indice + 1, this.tamanho - indice);
        }
        this.elementos[indice] = elemento;
        this.tamanho++;
    }

    @Override
    public void adicionarInicio(T elemento) {
        this.adicionar(0, elemento);
    }

    @Override
    public T remover(int indice) throws IndexOutOfBoundsException {
        verificarIndice(indice, 0, this.tamanho - 1);
        T elementoRemovido = this.elementos[indice];
        if (indice < this.tamanho - 1){
            System.arraycopy(this.elementos, indice + 1, this.elementos, indice, this.tamanho - 1 - indice);
        }
        this.tamanho--;
        this.elementos[this.tamanho] = null;
        return elementoRemovido;
    }

    @Override
    public void removerElemento(T elemento) {
        if (this.obterIndiceDo(elemento) != -1) {
            this.remover(this.obterIndiceDo(elemento));
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
        return new VetorIterator();
    }
        
        private class VetorIterator implements Iterator<T> {


        private int cursor;

            @Override
            public boolean hasNext() {
                return cursor < VetorTamanhoFixo.this.tamanho;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Não há mais elementos para iterar no vetor.");
                }
                return VetorTamanhoFixo.this.elementos[cursor++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("A operação de remoção não é suportada!");
            }
    }


}