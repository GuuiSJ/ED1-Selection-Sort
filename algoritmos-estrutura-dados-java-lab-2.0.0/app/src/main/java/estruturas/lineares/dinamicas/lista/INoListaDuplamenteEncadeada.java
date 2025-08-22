package estruturas.lineares.dinamicas.lista;

public interface INoListaDuplamenteEncadeada<T> {

    //Retorna o dado armazenado no nó.
    public T obterDado();

    //Define o dado do nó
    public void definirDado(T dado);

    //Retorna o próximo nó da lista
    public INoListaDuplamenteEncadeada<T> obterProximoNo();

    //Define o próximo nó da lista
    public void definirProximoNo(INoListaDuplamenteEncadeada<T> proximoNo);

    //Retorna o nó anterior da lista
    public INoListaDuplamenteEncadeada<T> obterNoAnterior();

    //Define o nó anterior da lista
    public void definirNoAnterior(INoListaDuplamenteEncadeada<T> noAnterior);


}