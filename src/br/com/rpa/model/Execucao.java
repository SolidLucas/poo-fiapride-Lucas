package br.com.rpa.model;

/**
 * Uma execução (job) de um robô sobre um lote de itens.
 * <p>
 * Associação TEM-UM: a Execucao TEM UM Robo. Ao concluir, ela atualiza
 * os indicadores do próprio robô, por isso guarda o objeto inteiro.
 */
public class Execucao {

    private final Robo robo;
    private final String descricaoLote;
    private final int totalItens;
    private boolean concluida;

    public Execucao(Robo robo, String descricaoLote, int totalItens) {
        if (robo == null) {
            throw new IllegalArgumentException("Uma execução precisa de um robô.");
        }
        if (totalItens <= 0) {
            throw new IllegalArgumentException("O lote precisa ter pelo menos 1 item.");
        }
        this.robo = robo;
        this.descricaoLote = descricaoLote;
        this.totalItens = totalItens;
    }

    /**
     * Conclui o job informando quantos itens falharam.
     *
     * @param itensComErro itens que caíram em exceção de negócio
     */
    public void concluir(int itensComErro) {
        if (concluida) {
            System.out.println("Execução já concluída.");
            return;
        }
        if (itensComErro < 0 || itensComErro > totalItens) {
            System.out.println("Quantidade de erros inválida.");
            return;
        }
        robo.registrarExecucao(totalItens - itensComErro, itensComErro);
        concluida = true;
        String resumo = String.format("lote \"%s\": %d itens, %d com erro.",
                descricaoLote, totalItens, itensComErro);
        // Só avisa o time se o robô assinou o contrato Notificavel
        if (robo instanceof Notificavel notificavel) {
            notificavel.notificar(resumo);
        } else {
            System.out.println("[" + robo.getNome() + "] " + resumo);
        }
    }

    public Robo getRobo() {
        return robo;
    }

    public boolean isConcluida() {
        return concluida;
    }
}
