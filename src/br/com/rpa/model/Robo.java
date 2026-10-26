package br.com.rpa.model;

/**
 * Classe mãe de todos os robôs de automação (RPA).
 * Guarda o que todo robô tem, independentemente da ferramenta:
 * nome, plataforma e indicadores de execução.
 */
public class Robo {

    private String nome;
    private final String plataforma; // definida pela filha, não muda depois
    private int itensProcessados;
    private int itensComErro;

    // protected: cada filha usa esse valor nos próprios cálculos, mas ele
    // continua invisível para quem está fora da hierarquia de robôs.
    protected final double segundosPorItem;

    public Robo(String nome, String plataforma, double segundosPorItem) {
        setNome(nome);
        if (plataforma == null || plataforma.isBlank()) {
            throw new IllegalArgumentException("Informe a plataforma do robô.");
        }
        if (segundosPorItem <= 0) {
            throw new IllegalArgumentException("O tempo por item deve ser positivo.");
        }
        this.plataforma = plataforma;
        this.segundosPorItem = segundosPorItem;
    }

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

    public void exibirInfo() {
        System.out.printf("Robô: %s | Plataforma: %s | Sucesso: %.1f%%%n",
                nome, plataforma, calcularTaxaSucesso());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O robô precisa de um nome.");
        }
        this.nome = nome.trim();
    }

    public String getPlataforma() {
        return plataforma;
    }

    public int getItensProcessados() {
        return itensProcessados;
    }

    public int getItensComErro() {
        return itensComErro;
    }

    // Contadores sem setter: o histórico de execução não pode ser "maquiado"
    // para melhorar o indicador do robô. Só registrarExecucao() altera.
}
