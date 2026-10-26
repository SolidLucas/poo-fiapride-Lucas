package br.com.fiapride;

import java.util.ArrayList;
import java.util.List;

import br.com.fiapride.model.Carro;
import br.com.fiapride.model.Moto;
import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Veiculo;
import br.com.fiapride.model.Viagem;

public class Principal {

    public static void main(String[] args) {
        Carro onix = new Carro("ABC1D23", "Chevrolet Onix", 4, 44.0, 13.5);
        Carro hb20 = new Carro("DEF4G56", "Hyundai HB20", 4, 50.0, 12.0);
        hb20.setArCondicionadoLigado(true);
        Moto cg = new Moto("XYZ9A87", "Honda CG 160", 160, 16.0, 40.0);

        // A lista é de Veiculo, mas guarda Carros e Motos
        List<Veiculo> frota = new ArrayList<>();
        frota.add(onix);
        frota.add(hb20);
        frota.add(cg);

        System.out.println("=== Frota FiapRide ===");
        for (Veiculo veiculo : frota) {
            // Mesma chamada, comportamento diferente: o Java decide em tempo de
            // execução qual versão de calcularAutonomia() usar (Carro ou Moto).
            veiculo.exibirInfo();
            System.out.printf("   -> Autonomia: %.0f km%n", veiculo.calcularAutonomia());
        }

        Passageiro ana = new Passageiro("Ana Silva", 80.0);
        new Viagem(ana, cg, 7.0).finalizar();
        ana.exibirDados();
    }
}
