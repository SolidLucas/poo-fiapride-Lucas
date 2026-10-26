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
        // Veiculo generico = new Veiculo("AAA1111", "?", 1);
        // -> não compila: Veiculo é abstract, não pode ser instanciado.

        List<Veiculo> frota = new ArrayList<>();
        frota.add(new Carro("ABC1D23", "Chevrolet Onix", 4, 44.0, 13.5));
        frota.add(new Moto("XYZ9A87", "Honda CG 160", 160, 16.0, 40.0));

        System.out.println("=== Frota FiapRide ===");
        for (Veiculo veiculo : frota) {
            veiculo.exibirInfo();
            System.out.printf("   -> Autonomia: %.0f km | R$ %.2f/km%n",
                    veiculo.calcularAutonomia(), veiculo.calcularPrecoPorKm());
        }

        // Mesma distância, preços diferentes conforme o tipo de veículo
        Passageiro ana = new Passageiro("Ana Silva", 80.0);
        for (Veiculo veiculo : frota) {
            Viagem viagem = new Viagem(ana, veiculo, 10.0);
            viagem.finalizar();
        }
        ana.exibirDados();
    }
}
