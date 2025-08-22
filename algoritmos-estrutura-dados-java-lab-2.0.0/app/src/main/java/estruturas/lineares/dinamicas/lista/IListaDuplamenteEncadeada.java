package estruturas.lineares.dinamicas.lista;

import java.util.Iterator;

public interface IListaDuplamenteEncadeada<T> {

     //Retorna a referencia do primeiro nó da lista
	public INoListaDuplamenteEncadeada<T> obterPrimeiroNo();

    //Retorna a referencia do último nó da lista
	public INoListaDuplamenteEncadeada<T> obterUltimoNo();

    //Remove todos os nós da lista
    public void limpar();

    //Retorna o número de nós da lista
    public int tamanho();

    //Verifica se a lista contém o dado passado como parâmetro
    public boolean contem(T dado);

    //Verifica se a lista está vazia
    public boolean estaVazia();

    //Adiciona um nó no início da lista - Padrão
    public void adicionar(T dado);

    //Adiciona um nó na posição indicada por parâmetro
    public void adicionar(T dado, int posicao);

    //Adiciona um nó no fim da lista
    public void adicionarFim(T dado);

    //Remove o nó do início da lista
    public void removerInicio();

    //Remove o nó do fim da lista
    public void removerFim();

    //Remove o nó de uma determinada posição
    public void remover(int posicao);

    //Retorna um texto que representa a lista. Elementos dentro dos [] e separados por vírgula. Formato ex.:  [1,2,3,4]
    public String imprimir();

    //Retorna um iterador que possibilitará percorrer cada elemento da lista
    public Iterator<T> iterator();

}