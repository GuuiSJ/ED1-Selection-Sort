package laboratorio.desafios.triagempacientes;

public class AppTriagemPacientes {

    public static void main(String[] args) {

        ITriagem triage = new TriagemPacientes();
        
        //Admintindo Pacientes na lista de espera
        triage.admitirPaciente(new Paciente("A",Gravidade.POUCO_URGENTE, 700)); //Paciente(A,4,0700) - 07:00 
        triage.admitirPaciente(new Paciente("B",Gravidade.EMERGENCIAL, 705));   //Paciente(B,1,0705) - 07:05
        triage.admitirPaciente(new Paciente("C",Gravidade.URGENTE, 712));       //Paciente(C,3,0712) - 07:12
        triage.admitirPaciente(new Paciente("D",2, 727));                       //Paciente(D,2,0727) - 07:27
        triage.admitirPaciente(new Paciente("E",1, 745));                       //Paciente(E,1,0745) - 07:45

        //Status da Triagem - Antes do Primeiro Processamento de Triagem em Lote
        System.out.println("[Primeiro Status - Antes do Primeiro Processamento de Triagem em Lote] \r\n" + triage.obterStatusTriagem());
        
        //Primeiro Processamento de Triagem em Lote
        triage.processarTriagemEmLote();
        System.out.println("[Primeiro Processamento de Triagem em Lote...] ");
        

        //Status da Triagem - Após o Primeiro Processamento de Triagem em Lote
        System.out.println("[Segundo Status - Após o Primeiro Processamento de Triagem em Lote] \r\n" + triage.obterStatusTriagem());
        
        //Tratando pacientes em estado crítico
        System.out.println("[Tratamento de Pacientes Críticos]");
        triage.tratarProximoPacienteCritico();
        triage.tratarProximoPacienteCritico();
        triage.tratarProximoPacienteCritico();

        //Status da Triagem - Após os Primeiros Tratamentos de Pacientes Críticos
        System.out.println("[Terceiro Status - Após os Primeiros Tratamentos de Pacientes Críticos] \r\n" + triage.obterStatusTriagem());

        //Admintindo Mais Pacientes na lista de espera
        triage.admitirPaciente(new Paciente("F",Gravidade.NAO_URGENTE, 800)); //Paciente(F,5,0800) - 08:00
        triage.admitirPaciente(new Paciente("G",2, 830)); //Paciente(G,2,0830) - 08:30
        triage.admitirPaciente(new Paciente("H",2, 825)); //Paciente(H,2,0825) - 08:25 

        //Status da Triagem - Antes do Segundo Processamento de Triagem em Lote
        System.out.println("[Quarto Status - Antes do Segundo Processamento de Triagem em Lote] \r\n" + triage.obterStatusTriagem());

        //Segundo Processamento de Triagem em Lote
        triage.processarTriagemEmLote();
        System.out.println("[Segundo Processamento de Triagem em Lote...] ");

        //Status da Triagem - Após o Segundo Processamento de Triagem em Lote
        System.out.println("[Quinto Status - Após o Segundo Processamento de Triagem em Lote] \r\n" + triage.obterStatusTriagem());

    }
}