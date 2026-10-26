package br.com.fiapride.model;

/**
 * Veículo cadastrado por um motorista do FiapRide.
 */
public class Veiculo {

    private String placa;
    private final String modelo; // final: o modelo de um carro não muda nunca

    /**
     * O construtor obriga placa e modelo: não existe veículo "pela metade" no sistema.
     */
    public Veiculo(String placa, String modelo) {
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("O modelo do veículo é obrigatório.");
        }
        this.modelo = modelo.trim();
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

    public void exibirInfo() {
        System.out.println("Veículo: " + modelo + " | Placa: " + placa);
    }
}
