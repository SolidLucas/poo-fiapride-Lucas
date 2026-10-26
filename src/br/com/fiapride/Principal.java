package br.com.fiapride;

import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Veiculo;
import br.com.fiapride.model.Viagem;

public class Principal {

    public static void main(String[] args) {
        Passageiro ana = new Passageiro("Ana Silva", 50.0);
        Passageiro bruno = new Passageiro("Bruno Costa", 10.0);
        Veiculo onix = new Veiculo("ABC1D23", "Chevrolet Onix");

        Viagem viagemAna = new Viagem(ana, onix, 12.5);
        viagemAna.exibirResumo();
        viagemAna.finalizar();
        viagemAna.exibirResumo();
        ana.exibirDados(); // o saldo da Ana mudou: a viagem mexeu no objeto real

        Viagem viagemBruno = new Viagem(bruno, onix, 8.0);
        viagemBruno.finalizar(); // saldo insuficiente
    }
}
