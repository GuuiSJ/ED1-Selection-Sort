package estruturas.lineares.dinamicas.lista;

public class NoListaDuplamenteEncadeada<T> implements INoListaDuplamenteEncadeada<T> {

    private T dado;
    private INoListaDuplamenteEncadeada<T> proximoNo;
    private INoListaDuplamenteEncadeada<T> noAnterior;

    public NoListaDuplamenteEncadeada(T dado) {
        this.definirDado(dado);
        this.definirProximoNo(null);
        this.definirNoAnterior(null);
    }

    public NoListaDuplamenteEncadeada(T dado, INoListaDuplamenteEncadeada<T> proximoNo, INoListaDuplamenteEncadeada<T> noAnterior) {
        this.definirDado(dado);
        this.definirProximoNo(proximoNo);
        this.definirNoAnterior(noAnterior);
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
    public INoListaDuplamenteEncadeada<T> obterProximoNo() {
       return this.proximoNo;
    }

    @Override
    public void definirProximoNo(INoListaDuplamenteEncadeada<T> proximoNo) {
        this.proximoNo = proximoNo;
    }

    @Override
    public INoListaDuplamenteEncadeada<T> obterNoAnterior() {
       return this.noAnterior;
    }

    @Override
    public void definirNoAnterior(INoListaDuplamenteEncadeada<T> noAnterior) {
       this.noAnterior = noAnterior;
    }

}