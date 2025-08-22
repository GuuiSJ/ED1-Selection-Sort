package laboratorio.desafios.triagempacientes;

//Define as operações principais para gerenciar a triagem de paciente em um hospital
public interface ITriagem {

    //Admite novos pacientes no hospital
    public void admitirPaciente(IPaciente paciente);

    //Processa os pacientes admitidos de acordo com as regras de triagem
    public void processarTriagemEmLote();

    //Trata o próximo paciente crítico - lida com o tratamento do caso mais urgente
    public void tratarProximoPacienteCritico();

    //Apresenta o status da Triagem
    public String obterStatusTriagem();

}