package br.com.rpa.model;

/**
 * Fluxo do Power Automate, que pode rodar na nuvem ou no Desktop.
 */
public class RoboPowerAutomate extends Robo {

    private final boolean fluxoDesktop;

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

    public boolean isFluxoDesktop() {
        return fluxoDesktop;
    }
}
