package br.com.fiapride;

import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Veiculo;

public class Principal {

    public static void main(String[] args) {
        // Três formas de nascer, todas válidas graças aos construtores
        Passageiro convidado = new Passageiro();
        Passageiro bruno = new Passageiro("Bruno Costa");
        Passageiro ana = new Passageiro("Ana Silva", 50.0);

        convidado.exibirDados();
        bruno.exibirDados();
        ana.exibirDados();

        Veiculo onix = new Veiculo("ABC1234", "Chevrolet Onix");
        onix.exibirInfo();
        onix.atualizarPlaca("ABC1D23", "");              // recusado
        onix.atualizarPlaca("ABC1D23", "DETRAN-2026-0042"); // processo oficial
        onix.exibirInfo();
    }
}
