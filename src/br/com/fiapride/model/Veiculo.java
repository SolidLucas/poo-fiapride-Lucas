package br.com.fiapride.model;

/**
 * Classe mãe de todos os veículos do FiapRide.
 * Concentra o que é comum (placa, modelo, lotação) para Carro e Moto
 * não duplicarem código.
 * <p>
 * É abstract porque não existe "veículo genérico" no app: todo veículo
 * real é um Carro, uma Moto etc. Assim ninguém consegue fazer new Veiculo(...).
 */
public abstract class Veiculo {

    private String placa;
    private final String modelo; // final: o modelo de um carro não muda nunca

    // protected + final: as filhas podem LER direto (ex.: para montar mensagens),
    // mas ninguém consegue ALTERAR a lotação depois de criado.
    protected final int capacidadePassageiros;

    /**
     * O construtor obriga placa e modelo: não existe veículo "pela metade" no sistema.
     */
    public Veiculo(String placa, String modelo, int capacidadePassageiros) {
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("O modelo do veículo é obrigatório.");
        }
        if (capacidadePassageiros < 1) {
            throw new IllegalArgumentException("O veículo deve levar pelo menos 1 passageiro.");
        }
        this.modelo = modelo.trim();
        this.capacidadePassageiros = capacidadePassageiros;
        setPlaca(placa);
    }

    /**
     * Troca de placa só acontece por um processo oficial (ex.: conversão para o
     * padrão Mercosul no Detran). Por isso exigimos o protocolo, e o setPlaca é privado.
     *
     * @param novaPlaca        nova placa emitida pelo Detran
     * @param protocoloDetran  número do protocolo que comprova o processo
     */
    public void atualizarPlaca(String novaPlaca, String protocoloDetran) {
        if (protocoloDetran == null || protocoloDetran.isBlank()) {
            System.out.println("Troca de placa recusada: protocolo do Detran não informado.");
            return;
        }
        String placaAntiga = this.placa;
        setPlaca(novaPlaca);
        System.out.println("Placa atualizada de " + placaAntiga + " para " + this.placa
                + " (protocolo " + protocoloDetran + ")");
    }

    // Privado: só o construtor e o atualizarPlaca() podem mudar a placa.
    private void setPlaca(String placa) {
        if (placa == null || !placa.trim().toUpperCase().matches("[A-Z]{3}-?[0-9][A-Z0-9][0-9]{2}")) {
            throw new IllegalArgumentException("Placa inválida: " + placa);
        }
        this.placa = placa.trim().toUpperCase().replace("-", "");
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    // Não existe setModelo(): um Onix não vira um Corolla.

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    /**
     * Quantos km o veículo roda com o tanque/bateria cheios.
     * Abstrato: a mãe define O QUE fazer, cada filha é OBRIGADA a dizer COMO.
     * (Antes retornava 0, um valor falso que poderia enganar o sistema.)
     *
     * @return autonomia em km
     */
    public abstract double calcularAutonomia();

    /**
     * Preço cobrado por km rodado; cada categoria tem o seu.
     *
     * @return valor em reais por km
     */
    public abstract double calcularPrecoPorKm();

    public void exibirInfo() {
        System.out.println("Veículo: " + modelo + " | Placa: " + placa
                + " | Lugares: " + capacidadePassageiros);
    }
}
