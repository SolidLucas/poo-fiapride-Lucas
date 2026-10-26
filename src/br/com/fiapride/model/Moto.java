package br.com.fiapride.model;

/**
 * Moto É-UM Veiculo, usada no FiapRide Moto (1 passageiro na garupa).
 */
public class Moto extends Veiculo {

    private final int cilindradas;
    private final double capacidadeTanqueLitros;
    private final double consumoKmPorLitro;

    public Moto(String placa, String modelo, int cilindradas,
                double capacidadeTanqueLitros, double consumoKmPorLitro) {
        super(placa, modelo, 1);
        if (cilindradas < 50) {
            throw new IllegalArgumentException("Cilindrada inválida.");
        }
        if (capacidadeTanqueLitros <= 0 || consumoKmPorLitro <= 0) {
            throw new IllegalArgumentException("Tanque e consumo devem ser positivos.");
        }
        this.cilindradas = cilindradas;
        this.capacidadeTanqueLitros = capacidadeTanqueLitros;
        this.consumoKmPorLitro = consumoKmPorLitro;
    }

    /**
     * Moto: tanque x consumo, sem perdas extras.
     */
    @Override
    public double calcularAutonomia() {
        return capacidadeTanqueLitros * consumoKmPorLitro;
    }

    /**
     * Corrida de moto é mais barata: gasta menos e leva só 1 passageiro.
     */
    @Override
    public double calcularPrecoPorKm() {
        return 1.50;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("   -> Moto " + cilindradas + " cc | Garupa para "
                + capacidadePassageiros + " passageiro");
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public double getCapacidadeTanqueLitros() {
        return capacidadeTanqueLitros;
    }

    public double getConsumoKmPorLitro() {
        return consumoKmPorLitro;
    }
}
