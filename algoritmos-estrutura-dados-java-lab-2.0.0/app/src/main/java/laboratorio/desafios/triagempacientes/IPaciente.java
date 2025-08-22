package laboratorio.desafios.triagempacientes;

//Representa um paciente no sistema de triagem do hospital
public interface IPaciente {

    //Retorna o nível de gravidade do paciente
    public Gravidade obterGravidade();

    //Retorna o registro de data e hora de chegada do paciente no hospital
    public int obterHorarioChegada();

}