package algoritmos.recursivos;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static int fibonacciRecursivo(int n){
        if ((n == 0) || (n == 1)){
            return n;
        }
        else {
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        }
    }

    public static int fibonacciIterativo(int n) {
        int i, fibonacci = 0;
        int fibAnterior = 0;
        int fibPosterior = 1;
        if ((n == 0) || (n == 1)){
            return n;
        }
        else {
            for (i = 2; i <= n; i++){
                fibonacci = fibAnterior + fibPosterior;
                fibAnterior = fibPosterior;
                fibPosterior = fibonacci;
            }
            return fibonacci;
        }
    }

    public static int fibonacciRecursivoMemorizado (int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 0 || n == 1) {
            memo.put(n, n);
            return n;
        }
        int resultado = fibonacciRecursivoMemorizado(n - 1, memo) + fibonacciRecursivoMemorizado(n - 2, memo);
        memo.put(n, resultado);
        return resultado;
    }

    public static void main(String[] args) {
        int n = 4;
       
        //Medição do tempo para versão recursiva
        long inicioRecursivo = System.nanoTime();
        int resultadoRecursivo = fibonacciRecursivo(n);
        long fimRecursivo = System.nanoTime();
        long tempoRecursivo = fimRecursivo - inicioRecursivo;

        //Medição do tempo para versão iterativa
        long inicioIterativo = System.nanoTime();
        int resultadoIterativo = fibonacciIterativo(n);
        long fimIterativo = System.nanoTime();
        long tempoIterativo = fimIterativo - inicioIterativo;

        //Medição do tempo para versão recursivo memorizado
        Map<Integer, Integer> memo = new HashMap<>();
        long inicioMemo = System.nanoTime();
        int resultadoMemo = fibonacciRecursivoMemorizado(n, memo);
        long fimMemo = System.nanoTime();
        long tempoMemo = fimMemo - inicioMemo;

        //Apresentação dos Resultados Medidos
		System.out.println("Resultado recursivo: " + resultadoRecursivo);
        System.out.println("Tempo recursivo (ns): " + tempoRecursivo);
        System.out.println("Resultado iterativo: " + resultadoIterativo);
        System.out.println("Tempo iterativo (ns): " + tempoIterativo);
        System.out.println("Diferença (ns): " + (tempoRecursivo - tempoIterativo));
        System.out.println("Resultado recursivo memorizado: " + resultadoMemo);
        System.out.println("Tempo recursivo memorizado (ns): " + tempoMemo);
        System.out.println("Diferença entre recursivo e memorizado (ns): " + (tempoRecursivo - tempoMemo));
    }

}
