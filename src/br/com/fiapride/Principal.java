package br.com.fiapride;

import br.com.fiapride.model.Carro;
import br.com.fiapride.model.Moto;
import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Viagem;

public class Principal {

    public static void main(String[] args) {
        Passageiro ana = new Passageiro("Ana Silva", 80.0);

        Carro onix = new Carro("ABC1D23", "Chevrolet Onix", 4, 44.0, 13.5);
        Moto cg = new Moto("XYZ9A87", "Honda CG 160", 160, 16.0, 40.0);

        // Métodos herdados da mãe, sem uma linha de código repetida
        onix.exibirInfo();
        cg.exibirInfo();
        System.out.println("Portas do Onix: " + onix.getQuantidadePortas());
        System.out.println("Cilindradas da CG: " + cg.getCilindradas());

        // A Viagem pede um Veiculo, e Carro/Moto SÃO veículos
        new Viagem(ana, onix, 10.0).finalizar();
        new Viagem(ana, cg, 5.0).finalizar();
        ana.exibirDados();
    }
}
