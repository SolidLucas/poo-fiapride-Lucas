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
