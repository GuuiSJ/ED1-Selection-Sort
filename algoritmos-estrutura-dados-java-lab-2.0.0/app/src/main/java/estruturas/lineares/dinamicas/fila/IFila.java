package estruturas.lineares.dinamicas.fila;

import java.util.Iterator;

public interface IFila<T> {

    //Retorna o número de dados que a fila possui
    public int tamanho();

    //Verifica se a fila esta vazia ou não
    public boolean estaVazia();

    //Remove todos os dados da fila
    public void limpar();

    //Verifica se a fila contém o dado passado como parâmetro
    public boolean contem(T dado);

    //Retorna o dado da frente da fila sem remover - ppek
    public T obterFrente(); 

    //Enfilera um dado no final da fila - enqueue
    public void enfileirar(T dado); 

    //Desenfilera e retorna o dado na frente da fila - dequeue
    public T desenfileirar(); 

    //Retorna a distancia de um dado em relacao a frente da fila
    //O vizinho mais proximo possui distancia 1 da frente da fila
    //Se o dado for o dado da frente da fila, entao retorna-se 0
    //Caso o dado nao exista na fila, retorna-se -1
    public int distancia(T dado);

    //Retorna um texto que representa a fila. Elementos dentro dos [] e separados por vírgula. Formato ex.:  [1,2,3,4]
    public String imprimir();

    //Retorna um iterador que possibilitará percorrer cada dado da fila
    public Iterator<T> iterator();
 
}
