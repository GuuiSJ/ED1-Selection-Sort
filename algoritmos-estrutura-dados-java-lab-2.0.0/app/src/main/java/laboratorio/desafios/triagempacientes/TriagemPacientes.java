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

    @Override
    public void admitirPaciente(IPaciente paciente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'admitirPaciente'");
    }

    @Override
    public void processarTriagemEmLote() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processarTriagemEmLote'");
    }

    @Override
    public void tratarProximoPacienteCritico() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tratarProximoPacienteCritico'");
    }

    @Override
    public String obterStatusTriagem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterStatusTriagem'");
    } 

}