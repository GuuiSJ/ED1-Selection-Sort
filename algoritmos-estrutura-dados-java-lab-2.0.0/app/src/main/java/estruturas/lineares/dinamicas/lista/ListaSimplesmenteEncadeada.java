package estruturas.lineares.dinamicas.lista;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaSimplesmenteEncadeada<T> implements IListaSimplesmenteEncadeada<T>,Iterable<T> {

    //private int tamanho;

    private INoListaSimplesmenteEncadeada<T> primeirNo;
    private INoListaSimplesmenteEncadeada<T> ultimoNo;
    private int quantidadeNos;

    public ListaSimplesmenteEncadeada(){
        this.limpar();
    }

    @Override
    public INoListaSimplesmenteEncadeada<T> obterPrimeiroNo() {
        return this.primeirNo;
    }

    @Override
    public INoListaSimplesmenteEncadeada<T> obterUltimoNo() {
        return this.ultimoNo;
    }

    @Override
    public void limpar() {
        this.primeirNo = null;
        this.ultimoNo = null;
        this.quantidadeNos = 0;
    }

    @Override
    public int tamanho() {
        return this.quantidadeNos;
    }

    @Override
    public boolean contem(T dado) {
        INoListaSimplesmenteEncadeada<T> noAtual = this.primeirNo;
        while (noAtual != null) {
            if (noAtual.obterDado().equals(dado)) {
                return true;
            }
            noAtual = noAtual.obterProximoNo();
        }
        return false;
    }

    @Override
    public boolean estaVazia() {
        if (this.quantidadeNos == 0){
            return true;
        }
        return false;
    }

    @Override
    public int posicao(T dado) {
        INoListaSimplesmenteEncadeada<T> noAtual = this.primeirNo;
        int posicao = 0;
        while (noAtual != null) {
            if (noAtual.obterDado().equals(dado)) {
                return posicao;
            }
            noAtual = noAtual.obterProximoNo();
            posicao++;
        }
        return -1; // Retorna -1 se o dado não for encontrado na lista
    }

    @Override
    public void adicionar(T dado) {
        INoListaSimplesmenteEncadeada<T> novoNo = new NoListaSimplesmenteEncadeada<>(dado);
        if (this.primeirNo == null){
            this.primeirNo = novoNo;
            this.ultimoNo = novoNo;
        }else{
            novoNo.definirProximoNo(this.primeirNo);
            this.primeirNo = novoNo;
        }
        quantidadeNos++;
    }

    @Override
    public void adicionar(T dado, int posicao) {
        INoListaSimplesmenteEncadeada<T> novoNo = new NoListaSimplesmenteEncadeada<T>(dado);
        INoListaSimplesmenteEncadeada<T> noAtual = this.primeirNo;
        if (posicao < 0 || posicao > quantidadeNos) {
            throw new IndexOutOfBoundsException();
        }
        else if (posicao == 0){
            this.adicionar(dado);
        }
        else if (posicao == quantidadeNos) {
            this.adicionarFim(dado);
        }
        else{
            int i = 1;
            while (i < quantidadeNos) {
                if (i == posicao) {
                    novoNo.definirProximoNo(noAtual.obterProximoNo());
                    noAtual.definirProximoNo(novoNo);
                    quantidadeNos++;
                    break;
                }
                noAtual = noAtual.obterProximoNo();
                i++;
            }
        }
    }

    @Override
    public void adicionarFim(T dado) {
        INoListaSimplesmenteEncadeada<T> novoNo = new NoListaSimplesmenteEncadeada<>(dado);
        if (this.primeirNo == null){
            this.primeirNo = novoNo;
            this.ultimoNo = novoNo;
        } else {
            this.ultimoNo.definirProximoNo(novoNo);
            this.ultimoNo = novoNo;
        }
        quantidadeNos++;
    }

    @Override
    public void removerInicio() {
        if (!this.estaVazia()){
            this.primeirNo = this.primeirNo.obterProximoNo();
            quantidadeNos--;
        }
    }

    @Override
    public void removerFim() {
        if (!this.estaVazia()) {
            INoListaSimplesmenteEncadeada<T> noAtual = this.primeirNo;
            if (quantidadeNos == 1) {
                this.limpar();
            } else {
                while (noAtual.obterProximoNo() != this.ultimoNo) {
                    noAtual = noAtual.obterProximoNo();
                }
                noAtual.definirProximoNo(null);
                this.ultimoNo = noAtual;
                quantidadeNos--;
            }
        }
    }

    @Override
    public void remover(T dado) {
        //Dicas para implementação
        //1 - Verificar se elemento existe com o contem()
        //2 - Verificar se o dado do primeiro nó é igual ao dado que deve ser removido passado por parâmetro.
            //2.1 - Executa a remoção no ínicio da lista
        //3 - Verificar se o dado do último nó é igual ao dado que deve ser removido passado por parâmetro.
            //3.1 -  Executa a remoção no fim da lista
        //4 - Percorra a lista para localizar o nó anterior ao que contém o dado a ser removido.
            //4.1 Atualizar o ponteiro do nó anterior para pular o nó que contém o elemento a ser removido, efetivamente removendo-o da lista.
    }

    @Override
    public String imprimir() {
        StringBuilder stringBuilder = new StringBuilder();
        INoListaSimplesmenteEncadeada<T> noAtual = this.primeirNo;
        while (noAtual != null) {
            stringBuilder.append(noAtual.obterDado().toString());
            noAtual = noAtual.obterProximoNo();
            if (noAtual != null) {
                stringBuilder.append(" -> ");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            INoListaSimplesmenteEncadeada<T> noAtual = primeirNo;

            @Override
            public boolean hasNext() {
                if (noAtual != null) {
                    return true;
                } else {
                    this.noAtual = primeirNo;
                    return false;
                }
            }

            @Override
            public T next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    T dado = (T) noAtual.obterDado();
                    noAtual = noAtual.obterProximoNo();
                    return dado;
                }
            }
        };
    }

}