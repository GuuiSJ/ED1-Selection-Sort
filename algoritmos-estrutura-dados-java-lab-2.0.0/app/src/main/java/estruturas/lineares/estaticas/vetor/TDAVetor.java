package estruturas.lineares.estaticas.vetor;

import java.util.Iterator;

public interface TDAVetor<T> {

  //Retorna o número de elementos de um vetor
  public int tamanho();

  //Verifica se um vetor está vazio
  public boolean estaVazio();

  //Verifica se o índice passado como parâmetro está fora dos limites do vetor (IndexOutOfBounds)
  public void verificarIndice(int indice, int minimo, int maximo);

  //Verifica a capacidade do vetor
  public void verificarCapacidade();

  //Retorna o índice da primeira ocorrência do elemento no vetor
  public int obterIndiceDo(T elemento);

  //Verifica se o vetor contém o elemento passado como parâmetro
  public boolean contem(T elemento);

  //Remove todos os elementos do vetor
  public void limpar();

  //Retorna o elemento que está armazenado no índice passado por parâmetro
  public T obter(int indice) throws IndexOutOfBoundsException;

  //Atualiza o elemento que está armazenado no índice passado por parâmetro
  public void atualizar(int indice, T elemento) throws IndexOutOfBoundsException;

  //Adiciona o elemento no fim do vetor - padrão
  public void adicionar(T elemento);

  //Adiciona o elemento em um índice específico do vetor
  public void adicionar(int indice, T elemento) throws IndexOutOfBoundsException;

  //Adiciona o elemento no início do vetor
  public void adicionarInicio(T elemento);

  //Remove e retorna o elemento do índice passado por parâmetro
  public T remover(int indice) throws IndexOutOfBoundsException;

  //Busca e remove o elemento  passado por parâmetro do vetor
  public void removerElemento(T elemento);

  //Remove o primeiro elemento do vetor
  public void removerInicio();

  //Remove o último elemento  do vetor
  public void removerFim();

  //Retorna um texto que representa o vetor. Elementos dentro dos [] e separados por vírgula. Formato ex.:  [1,2,3,4]
  public String imprimir();

  //Retorna um iterador que possibilitará percorrer cada elemento da coleção no vetor
  public Iterator<T> iterator();

}