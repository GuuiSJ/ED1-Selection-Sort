package laboratorio.desafios.triagempacientes;

import estruturas.lineares.dinamicas.fila.IFila;
import estruturas.lineares.dinamicas.fila.FilaComListaDuplamenteEncadeada;
import estruturas.lineares.dinamicas.pilha.IPilha;
import estruturas.lineares.dinamicas.pilha.PilhaComListaSimplesmenteEncadeada;

public class TriagemPacientes implements ITriagem {

    //A classe deve ter dois atributos que representam a lista de espera e a lista de prioridades.
    //Esses atributos devem ser privados e finais (private final)
    //Vocês devem a partir da interpretação do problema definir que tipo de estrutura de dados cada lista dessa sera (Piha ou Fila)
    //Deve-se usar as interfaces de IFila e IPilha já definidas neste projeto
    //Deve-se usar as classes já implementadas neste projeto (FilaComListaDuplamenteEncadeada e PilhaComListaSimplesmenteEncadeada)
    //Implemente os casos de uso;metodos admitirPaciente, processarTriagemEmLote, tratarProximoPacienteCritico e obterStatusTriagem.
    //Pode implementar novos métodos para auxiliar os casos de uso
    private final IFila<IPaciente> listaDeEspera;
    private final IPilha<IPaciente> listaDePrioridades;

    public TriagemPacientes() {
        this.listaDeEspera = new FilaComListaDuplamenteEncadeada<>();
        this.listaDePrioridades= new PilhaComListaSimplesmenteEncadeada<>();
    }

    @Override
    public void admitirPaciente(IPaciente paciente) {
        // Novos pacientes entram no final da fila de espera.
        this.listaDeEspera.enfileirar(paciente);
    }

    @Override
    public void processarTriagemEmLote() {
        // Etapa 1: Separar pacientes em críticos e não críticos
        IFila<IPaciente> naoCriticos = new FilaComListaDuplamenteEncadeada<>();
        IFila<IPaciente> criticosParaOrdenar = new FilaComListaDuplamenteEncadeada<>();

        while (!this.listaDeEspera.estaVazia()) {
            IPaciente paciente = this.listaDeEspera.desenfileirar();
            // Assumindo que a classe Gravidade tem um método ehCritico()
            if (paciente.obterGravidade().ehCritico()) { 
                criticosParaOrdenar.enfileirar(paciente);
            } else {
                naoCriticos.enfileirar(paciente);
            }
        }

        // Etapa 2: Ordenar os pacientes críticos com Selection Sort usando Filas
        int totalCriticos = criticosParaOrdenar.tamanho();
        IFila<IPaciente> criticosOrdenados = new FilaComListaDuplamenteEncadeada<>();

        for (int i = 0; i < totalCriticos; i++) {
            IPaciente pacienteMaisUrgenteDaVez = criticosParaOrdenar.desenfileirar();
            IFila<IPaciente> filaRestante = new FilaComListaDuplamenteEncadeada<>();
            
            while (!criticosParaOrdenar.estaVazia()) {
                IPaciente pacienteAtual = criticosParaOrdenar.desenfileirar();
                
                // --- CORREÇÃO DOS NOMES DOS MÉTODOS AQUI ---
                if (pacienteAtual.obterGravidade().obterNivel() < pacienteMaisUrgenteDaVez.obterGravidade().obterNivel() ||
                   (pacienteAtual.obterGravidade().obterNivel() == pacienteMaisUrgenteDaVez.obterGravidade().obterNivel() &&
                    pacienteAtual.obterHorarioChegada() < pacienteMaisUrgenteDaVez.obterHorarioChegada())) {
                    
                    filaRestante.enfileirar(pacienteMaisUrgenteDaVez);
                    pacienteMaisUrgenteDaVez = pacienteAtual;
                } else {
                    filaRestante.enfileirar(pacienteAtual);
                }
            }
            
            criticosOrdenados.enfileirar(pacienteMaisUrgenteDaVez);
            criticosParaOrdenar = filaRestante;
        }

        // Etapa 3: Reorganizar as listas
        IPilha<IPaciente> pilhaInversora = new PilhaComListaSimplesmenteEncadeada<>();
        while (!criticosOrdenados.estaVazia()) {
            pilhaInversora.empilhar(criticosOrdenados.desenfileirar());
        }

        while (!pilhaInversora.estaVazia()) {
            this.listaDePrioridades.empilhar(pilhaInversora.desempilhar());
        }

        while (!naoCriticos.estaVazia()) {
            this.listaDeEspera.enfileirar(naoCriticos.desenfileirar());
        }
    }

    @Override
    public void tratarProximoPacienteCritico() {
        if (!this.listaDePrioridades.estaVazia()) {
            IPaciente pacienteTratado = this.listaDePrioridades.desempilhar();
            System.out.println("Tratando o Paciente: " + pacienteTratado.toString());
        }
    }

    @Override
    public String obterStatusTriagem() {
        StringBuilder status = new StringBuilder();
        status.append("- Lista de Espera: ");
        status.append(this.listaDeEspera.imprimir());
        status.append("\n");
        status.append("- Lista de Prioridade: ");
        status.append(this.listaDePrioridades.imprimir());
        return status.toString();
    } 
}
