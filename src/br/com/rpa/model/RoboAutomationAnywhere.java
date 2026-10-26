package br.com.rpa.model;

/**
 * Bot do Automation Anywhere, disparado pelo Control Room.
 */
public class RoboAutomationAnywhere extends Robo {

    private final int botRunnersDisponiveis;

    public RoboAutomationAnywhere(String nome, int botRunnersDisponiveis) {
        super(nome, "Automation Anywhere", 2.0);
        if (botRunnersDisponiveis < 1) {
            throw new IllegalArgumentException("É preciso pelo menos 1 Bot Runner.");
        }
        this.botRunnersDisponiveis = botRunnersDisponiveis;
    }

    public int getBotRunnersDisponiveis() {
        return botRunnersDisponiveis;
    }
}
