package br.com.fiapride.model;

/**
 * Molde de um passageiro do FiapRide.
 * Cada usuário do app vira um objeto criado a partir desta classe.
 */
public class Passageiro {

    public String nome;
    public double saldo;

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
}
