package br.com.rpa.model;

/**
 * Desafio pessoal: um robô de automação (RPA) que processa itens
 * de uma fila de trabalho (notas fiscais, e-mails, planilhas...).
 */
public class Robo {

    public String nome;
    public String plataforma;
    public int itensProcessados;
    public int itensComErro;

    /**
     * Registra o resultado de uma execução do robô.
     *
     * @param sucesso quantidade de itens processados com sucesso
     * @param erros   quantidade de itens que falharam
     */
    public void registrarExecucao(int sucesso, int erros) {
        if (sucesso < 0 || erros < 0) {
            System.out.println("Quantidades não podem ser negativas.");
            return;
        }
        itensProcessados += sucesso;
        itensComErro += erros;
    }

    /**
     * @return percentual de itens processados com sucesso (0 a 100)
     */
    public double calcularTaxaSucesso() {
        int total = itensProcessados + itensComErro;
        if (total == 0) {
            return 0;
        }
        return itensProcessados * 100.0 / total;
    }
}
