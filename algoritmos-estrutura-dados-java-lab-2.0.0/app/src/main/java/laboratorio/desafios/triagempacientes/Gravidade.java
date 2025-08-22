package laboratorio.desafios.triagempacientes;

public enum Gravidade {

    EMERGENCIAL(1, "Emergencial"),
    MUITO_URGENTE(2, "Muito Urgente"),
    URGENTE(3, "Urgente"),
    POUCO_URGENTE(4, "Pouco Urgente"),
    NAO_URGENTE(5, "Não Urgente");
        
    private final int nivel;
    private final String descricao;

    Gravidade(int nivel, String descricao) {
        this.nivel = nivel;
        this.descricao = descricao;
    }
        
    public int obterNivel() {
        return this.nivel;
    }
        
    public String obterDescricao() {
        return this.descricao;
    }
        
    public boolean ehCritico() {
        return this.nivel <= 2;
    }
        
    public static Gravidade doNivel (int nivel) {
        for (Gravidade gravidade : values()) {
            if (gravidade.nivel == nivel) return gravidade;
        }
        throw new IllegalArgumentException("Nível de Gravidade Inválido: " + nivel);
    }
}