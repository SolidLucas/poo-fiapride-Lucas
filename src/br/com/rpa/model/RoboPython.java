package br.com.rpa.model;

/**
 * Robô escrito em Python (ex.: Selenium, Pandas, PyAutoGUI).
 */
public class RoboPython extends Robo {

    private final String versaoPython;

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

    public String getVersaoPython() {
        return versaoPython;
    }
}
