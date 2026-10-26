package br.com.fiapride.model;

/**
 * Molde de um passageiro do FiapRide.
 * Cada usuário do app vira um objeto criado a partir desta classe.
 */
public class Passageiro {

    // private: ninguém de fora mexe direto no dado, só pelos métodos com regra
    private String nome;
    private double saldo;

    /**
     * Construtor padrão: cria um passageiro convidado, sem saldo.
     * Usa this(...) para reaproveitar o construtor completo em vez de duplicar regras.
     */
    public Passageiro() {
        this("Passageiro Convidado", 0.0);
    }

    /**
     * Cria um passageiro novo, que começa sem saldo.
     */
    public Passageiro(String nome) {
        this(nome, 0.0);
    }

    /**
     * Construtor completo: único ponto que realmente inicializa o objeto.
     *
     * @param nome         nome do passageiro
     * @param saldoInicial saldo de boas-vindas (não pode ser negativo)
     */
    public Passageiro(String nome, double saldoInicial) {
        setNome(nome);
        if (saldoInicial > 0) {
            this.saldo = saldoInicial;
        }
    }

    /**
     * Adiciona créditos à carteira. Centralizar a regra aqui evita que
     * alguém espalhe "saldo = saldo + x" pelo código sem validar nada.
     *
     * @param valor valor a ser creditado (deve ser positivo)
     */
    public void adicionarSaldo(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido: o crédito deve ser maior que zero.");
            return;
        }
        saldo += valor;
    }

    /**
     * Tenta pagar uma corrida.
     *
     * @param valor valor da corrida
     * @return true se o pagamento foi feito; false se o valor é inválido ou falta saldo
     */
    public boolean pagar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public void exibirDados() {
        System.out.printf("Passageiro: %s | Saldo: R$ %.2f%n", nome, saldo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.out.println("Nome inválido: o passageiro precisa de um nome.");
            return;
        }
        this.nome = nome.trim();
    }

    public double getSaldo() {
        return saldo;
    }

    // Sem setSaldo() de propósito: o saldo só muda via adicionarSaldo() e pagar(),
    // que aplicam as regras de negócio. Um setSaldo(9999) seria uma porta para fraude.
}
