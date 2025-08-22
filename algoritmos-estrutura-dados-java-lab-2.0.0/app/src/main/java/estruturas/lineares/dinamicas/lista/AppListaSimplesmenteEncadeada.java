package estruturas.lineares.dinamicas.lista;

public class AppListaSimplesmenteEncadeada {

    public static void main(String[] args) {

        //Exemplo de Uso da Lista Simplesmente Encadeada
        IListaSimplesmenteEncadeada<String> lista = new ListaSimplesmenteEncadeada<>();
        lista.adicionar("A");
        lista.adicionar("B");
        lista.adicionar("C");
        lista.adicionarFim("D");
        System.out.println(lista.imprimir());

    }


}