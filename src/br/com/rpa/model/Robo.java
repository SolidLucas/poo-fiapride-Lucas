package br.com.rpa.model;

/**
 * Desafio pessoal: um robô de automação (RPA) que processa itens
 * de uma fila de trabalho (notas fiscais, e-mails, planilhas...).
 */
public class Robo {

    private String nome;
    private String plataforma;
    private int itensProcessados;
    private int itensComErro;

    /**
     * Construtor padrão: robô ainda sem configuração definida.
     */
    public Robo() {
        this("Robô sem nome", "Não definida");
    }

    /**
     * Cria um robô em Python, a plataforma padrão da equipe.
     */
    public Robo(String nome) {
        this(nome, "Python");
    }

    public Robo(String nome, String plataforma) {
        setNome(nome);
        setPlataforma(plataforma);
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.out.println("O robô precisa de um nome.");
            return;
        }
        this.nome = nome.trim();
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        if (plataforma == null || plataforma.isBlank()) {
            System.out.println("Informe a plataforma do robô.");
            return;
        }
        this.plataforma = plataforma.trim();
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
