package br.com.rpa.model;

/**
 * Robô escrito em Python (ex.: Selenium, Pandas, PyAutoGUI).
 */
public class RoboPython extends Robo implements Agendavel {

    private final String versaoPython;
    private String agendamento = CRON_PADRAO;

    public RoboPython(String nome, String versaoPython) {
        super(nome, "Python", 0.8);
        if (versaoPython == null || !versaoPython.startsWith("3.")) {
            throw new IllegalArgumentException("Use Python 3.x (Python 2 já morreu!).");
        }
        this.versaoPython = versaoPython;
    }

    /**
     * Python: rápido por item, só paga ~5s para ativar o ambiente virtual.
     */
    @Override
    public double estimarTempoExecucao(int quantidadeItens) {
        return 5 + quantidadeItens * segundosPorItem;
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

    public String getVersaoPython() {
        return versaoPython;
    }
}
