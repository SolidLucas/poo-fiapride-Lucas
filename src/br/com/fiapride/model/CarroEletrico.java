package br.com.fiapride.model;

/**
 * Carro elétrico: herda de UMA mãe (Veiculo) e assina DOIS contratos
 * (Recarregavel e Rastreavel). Herança simples + múltiplas interfaces.
 */
public class CarroEletrico extends Veiculo implements Recarregavel, Rastreavel {

    private final double capacidadeBateriaKwh;
    private final double kmPorKwh;
    private int nivelBateria;

    public CarroEletrico(String placa, String modelo, double capacidadeBateriaKwh, double kmPorKwh) {
        super(placa, modelo, 4);
        if (capacidadeBateriaKwh <= 0 || kmPorKwh <= 0) {
            throw new IllegalArgumentException("Bateria e eficiência devem ser positivas.");
        }
        this.capacidadeBateriaKwh = capacidadeBateriaKwh;
        this.kmPorKwh = kmPorKwh;
        this.nivelBateria = CARGA_MAXIMA_PERCENTUAL; // sai da fábrica carregado
    }

    /**
     * Elétrico: a autonomia depende de quanto ainda resta na bateria.
     */
    @Override
    public double calcularAutonomia() {
        return capacidadeBateriaKwh * kmPorKwh * nivelBateria / 100.0;
    }

    @Override
    public double calcularPrecoPorKm() {
        return 1.80; // energia mais barata que gasolina
    }

    @Override
    public void recarregar(int percentual) {
        if (percentual <= 0) {
            System.out.println("Percentual de recarga inválido.");
            return;
        }
        nivelBateria = Math.min(CARGA_MAXIMA_PERCENTUAL, nivelBateria + percentual);
        System.out.println(getModelo() + " recarregado: " + nivelBateria + "%");
    }

    /**
     * Gasta bateria conforme a distância percorrida.
     *
     * @param km distância rodada
     */
    public void rodar(double km) {
        double kmComCargaCheia = capacidadeBateriaKwh * kmPorKwh;
        int consumoPercentual = (int) Math.ceil(km / kmComCargaCheia * 100);
        nivelBateria = Math.max(0, nivelBateria - consumoPercentual);
    }

    public boolean podeAceitarCorrida() {
        return nivelBateria >= CARGA_MINIMA_PARA_CORRIDA;
    }

    @Override
    public int getNivelBateria() {
        return nivelBateria;
    }

    @Override
    public String obterLocalizacao() {
        return PREFIXO_RASTREIO + getPlaca() + " -> Av. Paulista, 1106 (FIAP)";
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("   -> Elétrico | Bateria: " + nivelBateria + "%");
    }
}
