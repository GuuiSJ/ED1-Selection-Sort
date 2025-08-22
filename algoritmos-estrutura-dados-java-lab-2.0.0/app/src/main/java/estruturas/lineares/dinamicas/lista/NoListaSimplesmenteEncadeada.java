package estruturas.lineares.dinamicas.lista;

public class NoListaSimplesmenteEncadeada<T> implements INoListaSimplesmenteEncadeada<T> {

    private T dado;
    private INoListaSimplesmenteEncadeada<T> proximoNo;

    public NoListaSimplesmenteEncadeada(T dado) {
        this.dado = dado;
        this.proximoNo = null;
    }

    public NoListaSimplesmenteEncadeada(T dado, INoListaSimplesmenteEncadeada<T> proximoNo) {
        this.dado = dado;
        this.proximoNo = proximoNo;
    }
    
    @Override
    public T obterDado() {
        return this.dado;
    }

    @Override
    public void definirDado(T dado) {
        this.dado = dado;
    }

    @Override
    public INoListaSimplesmenteEncadeada<T> obterProximoNo() {
        return this.proximoNo;
    }

    @Override
    public void definirProximoNo(INoListaSimplesmenteEncadeada<T> proximoNo) {
        this.proximoNo = proximoNo;
    }

    @Override
    public String toString() {
        return "Dado: " + this.obterDado();
    }

}