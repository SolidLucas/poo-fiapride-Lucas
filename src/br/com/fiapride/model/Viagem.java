package br.com.fiapride.model;

/**
 * Uma corrida do FiapRide.
 * <p>
 * Associação (TEM-UM): a Viagem TEM UM Passageiro e TEM UM Veiculo.
 * Guardamos o objeto inteiro (e não só o nome) porque a viagem precisa
 * agir sobre ele: descontar o saldo ao final da corrida.
 */
public class Viagem {

    private static final double TARIFA_BASE = 5.00;

    private final Passageiro solicitante;
    private final Veiculo veiculo;
    private final double distanciaKm;
    private boolean finalizada;

    public Viagem(Passageiro solicitante, Veiculo veiculo, double distanciaKm) {
        if (solicitante == null || veiculo == null) {
            throw new IllegalArgumentException("Toda viagem precisa de um passageiro e de um veículo.");
        }
        if (distanciaKm <= 0) {
            throw new IllegalArgumentException("A distância deve ser maior que zero.");
        }
        this.solicitante = solicitante;
        this.veiculo = veiculo;
        this.distanciaKm = distanciaKm;
    }

    public double calcularValor() {
        // Polimorfismo: o preço por km vem do tipo real do veículo (Carro, Moto...)
        return TARIFA_BASE + distanciaKm * veiculo.calcularPrecoPorKm();
    }

    /**
     * Encerra a corrida e cobra o passageiro. Só é possível porque a Viagem
     * conhece o objeto Passageiro, não apenas uma String com o nome dele.
     *
     * @return true se a cobrança foi feita
     */
    public boolean finalizar() {
        if (finalizada) {
            System.out.println("Essa viagem já foi finalizada.");
            return false;
        }
        boolean pagou = solicitante.pagar(calcularValor());
        if (pagou) {
            finalizada = true;
            System.out.printf("Viagem finalizada! R$ %.2f debitados de %s.%n",
                    calcularValor(), solicitante.getNome());
        } else {
            System.out.printf("Saldo insuficiente: %s tem R$ %.2f e a corrida custa R$ %.2f.%n",
                    solicitante.getNome(), solicitante.getSaldo(), calcularValor());
        }
        return pagou;
    }

    public void exibirResumo() {
        System.out.printf("Resumo: %s | %s (%s) | %.1f km | R$ %.2f | %s%n",
                solicitante.getNome(), veiculo.getModelo(), veiculo.getPlaca(),
                distanciaKm, calcularValor(), finalizada ? "FINALIZADA" : "EM ANDAMENTO");
    }

    public Passageiro getSolicitante() {
        return solicitante;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public boolean isFinalizada() {
        return finalizada;
    }
}
