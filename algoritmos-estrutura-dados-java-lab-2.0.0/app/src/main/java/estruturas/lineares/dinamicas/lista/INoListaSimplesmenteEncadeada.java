package estruturas.lineares.dinamicas.lista;

public interface INoListaSimplesmenteEncadeada<T> {

    //Retorna o dado armazenado no nó.
    public T obterDado();

    //Define o dado do nó
    public void definirDado(T dado);

    //Retorna o próximo nó da lista
    public INoListaSimplesmenteEncadeada<T> obterProximoNo();

    //Define o próximo nó da lista
    public void definirProximoNo(INoListaSimplesmenteEncadeada<T> proximoNo);

}