package br.com.fiapride.model;

/**
 * Carro É-UM Veiculo: herda placa, modelo e lotação da mãe.
 */
public class Carro extends Veiculo {

    private final int quantidadePortas;
    private final double capacidadeTanqueLitros;
    private final double consumoKmPorLitro;
    private boolean arCondicionadoLigado;

    public Carro(String placa, String modelo, int quantidadePortas,
                 double capacidadeTanqueLitros, double consumoKmPorLitro) {
        // super() precisa ser a primeira linha: a "parte mãe" do objeto nasce antes
        super(placa, modelo, 4);
        if (quantidadePortas != 2 && quantidadePortas != 4) {
            throw new IllegalArgumentException("Um carro do app deve ter 2 ou 4 portas.");
        }
        if (capacidadeTanqueLitros <= 0 || consumoKmPorLitro <= 0) {
            throw new IllegalArgumentException("Tanque e consumo devem ser positivos.");
        }
        this.quantidadePortas = quantidadePortas;
        this.capacidadeTanqueLitros = capacidadeTanqueLitros;
        this.consumoKmPorLitro = consumoKmPorLitro;
    }

    /**
     * Carro: tanque x consumo, perdendo 10% com o ar-condicionado ligado.
     */
    @Override
    public double calcularAutonomia() {
        double autonomia = capacidadeTanqueLitros * consumoKmPorLitro;
        return arCondicionadoLigado ? autonomia * 0.9 : autonomia;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo(); // reaproveita a parte comum da mãe
        System.out.println("   -> Carro " + quantidadePortas + " portas | Ar: "
                + (arCondicionadoLigado ? "ligado" : "desligado"));
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public double getCapacidadeTanqueLitros() {
        return capacidadeTanqueLitros;
    }

    public double getConsumoKmPorLitro() {
        return consumoKmPorLitro;
    }

    public boolean isArCondicionadoLigado() {
        return arCondicionadoLigado;
    }

    public void setArCondicionadoLigado(boolean arCondicionadoLigado) {
        this.arCondicionadoLigado = arCondicionadoLigado;
    }
}
