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

    /**
     * AA divide o lote entre os Bot Runners, mas gasta ~20s com o Control Room.
     */
    @Override
    public double estimarTempoExecucao(int quantidadeItens) {
        return 20 + (quantidadeItens * segundosPorItem) / botRunnersDisponiveis;
    }

    public int getBotRunnersDisponiveis() {
        return botRunnersDisponiveis;
    }
}
