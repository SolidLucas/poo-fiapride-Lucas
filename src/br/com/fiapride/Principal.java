package br.com.fiapride;

import java.util.ArrayList;
import java.util.List;

import br.com.fiapride.model.Carro;
import br.com.fiapride.model.CarroEletrico;
import br.com.fiapride.model.Moto;
import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Rastreavel;
import br.com.fiapride.model.Recarregavel;
import br.com.fiapride.model.Veiculo;
import br.com.fiapride.model.Viagem;

/**
 * Demonstração final do FiapRide (aulas 1 a 9).
 */
public class Principal {

    public static void main(String[] args) {
        Carro onix = new Carro("ABC1D23", "Chevrolet Onix", 4, 44.0, 13.5);
        Moto cg = new Moto("XYZ9A87", "Honda CG 160", 160, 16.0, 40.0);
        CarroEletrico dolphin = new CarroEletrico("BYD2E26", "BYD Dolphin", 44.9, 6.5);

        List<Veiculo> frota = new ArrayList<>(List.of(onix, cg, dolphin));

        System.out.println("=== Frota FiapRide ===");
        for (Veiculo veiculo : frota) {
            veiculo.exibirInfo();
            System.out.printf("   -> Autonomia: %.0f km | R$ %.2f/km%n",
                    veiculo.calcularAutonomia(), veiculo.calcularPrecoPorKm());
        }

        // Interface como tipo: só quem assinou o contrato Rastreavel entra aqui
        System.out.println("\n=== Mapa (veículos rastreáveis) ===");
        for (Veiculo veiculo : frota) {
            if (veiculo instanceof Rastreavel rastreavel) {
                System.out.println(rastreavel.obterLocalizacao());
            }
        }

        System.out.println("\n=== Corridas ===");
        Passageiro ana = new Passageiro("Ana Silva", 100.0);
        new Viagem(ana, dolphin, 15.0).finalizar();
        dolphin.rodar(240);
        System.out.println("Bateria do Dolphin após rodar: " + dolphin.getNivelBateria() + "%");

        if (!dolphin.podeAceitarCorrida()) {
            System.out.println("Abaixo de " + Recarregavel.CARGA_MINIMA_PARA_CORRIDA
                    + "%: o Dolphin precisa recarregar antes da próxima corrida.");
            dolphin.recarregar(60);
        }
        new Viagem(ana, dolphin, 5.0).finalizar();
        ana.exibirDados();
    }
}
