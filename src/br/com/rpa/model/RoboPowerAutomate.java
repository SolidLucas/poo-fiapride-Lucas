package br.com.rpa.model;

/**
 * Fluxo do Power Automate, que pode rodar na nuvem ou no Desktop.
 */
public class RoboPowerAutomate extends Robo implements Agendavel, Notificavel {

    private final boolean fluxoDesktop;
    private String agendamento = CRON_PADRAO;

    public RoboPowerAutomate(String nome, boolean fluxoDesktop) {
        super(nome, "Power Automate", fluxoDesktop ? 2.5 : 1.2);
        this.fluxoDesktop = fluxoDesktop;
    }

    /**
     * Desktop precisa abrir a sessão na máquina (~30s); Cloud só dispara o gatilho (~10s).
     */
    @Override
    public double estimarTempoExecucao(int quantidadeItens) {
        double overhead = fluxoDesktop ? 30 : 10;
        return overhead + quantidadeItens * segundosPorItem;
    }

    @Override
    public void agendar(String expressaoCron) {
        if (expressaoCron == null || expressaoCron.trim().split("\\s+").length != 5) {
            System.out.println("Cron inválido, mantendo o padrão: " + CRON_PADRAO);
            return;
        }
        this.agendamento = expressaoCron.trim();
    }

    @Override
    public String getAgendamento() {
        return agendamento;
    }

    @Override
    public void notificar(String mensagem) {
        System.out.println("[" + CANAL_PADRAO + "] " + getNome() + ": " + mensagem);
    }

    public boolean isFluxoDesktop() {
        return fluxoDesktop;
    }
}
