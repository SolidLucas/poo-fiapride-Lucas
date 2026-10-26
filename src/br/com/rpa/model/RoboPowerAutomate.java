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

    public boolean isFluxoDesktop() {
        return fluxoDesktop;
    }
}
