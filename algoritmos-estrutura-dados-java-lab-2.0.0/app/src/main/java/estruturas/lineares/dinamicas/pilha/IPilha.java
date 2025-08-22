package estruturas.lineares.dinamicas.pilha;

import java.util.Iterator;

public interface IPilha<T> {

    //Retorna o número de elementos que a pilha possui
    public int tamanho();

    //Verifica se a pilha esta vazia ou não
    public boolean estaVazia();

    //Remove todos os elementos da pilha
    public void limpar();

    //Verifica se a pilha contém o dado passado como parâmetro
    public boolean contem(T dado);

    //Retorna o elemento do topo sem remover
    public T obterTopo(); //Peek

    //Empilha um elemento no topo da pilha.
    public void empilhar(T dado); //Push

    //Desempilha e retorna o elemento do topo da pilha.
    public T desempilhar(); // Pop

    //Retorna a distancia de um dado em relacao ao topo
	//O vizinho mais proximo possui distancia 1 do topo
	//Se o elemento for o proprio topo, entao retorna-se 0
	//Caso o elemento nao exista, retorna-se -1
	public int distancia(T dado);

    //Retorna um texto que representa a pilha. Elementos dentro dos [] e separados por vírgula. Formato ex.:  [1,2,3,4]
    public String imprimir();

    //Retorna um iterador que possibilitará percorrer cada elemento da piha
    public Iterator<T> iterator();

}