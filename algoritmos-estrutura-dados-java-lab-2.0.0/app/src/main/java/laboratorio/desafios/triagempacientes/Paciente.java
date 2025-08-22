package laboratorio.desafios.triagempacientes;

public class Paciente implements IPaciente {

    private final String nome;
    private final Gravidade gravidade;
    private final int horarioChegada;
    
    public Paciente(String nome ,Gravidade gravidade, int horarioChegada) {
        this.nome = nome;
        this.gravidade = gravidade;
        this.horarioChegada = horarioChegada;
    }
    
    public Paciente(String nome, int nivelGravidade, int horarioChegada) {
        this.nome = nome;
        this.gravidade = Gravidade.doNivel(nivelGravidade);
        this.horarioChegada = horarioChegada;
    }

    public String obterNome() {
        return this.nome;
    }
    
    public Gravidade obterGravidade() {
        return this.gravidade;
    }
    
    public int obterHorarioChegada() {
        return this.horarioChegada;
    }
    
    @Override
    public String toString() {
        return String.format("Paciente(%s,%s,%04d)", this.nome, this.gravidade.obterNivel(), this.horarioChegada);
    }

}