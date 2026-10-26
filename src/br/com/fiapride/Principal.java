package br.com.fiapride;

import br.com.fiapride.model.Passageiro;

public class Principal {

    public static void main(String[] args) {
        Passageiro ana = new Passageiro();
        ana.nome = "Ana Silva";
        ana.saldo = 50.0;

        ana.adicionarSaldo(100.0);
        ana.adicionarSaldo(-30.0); // barrado pela validação
        ana.exibirDados();

        boolean pagou = ana.pagar(35.90);
        System.out.println("Corrida de R$ 35,90 paga? " + pagou);

        boolean pagouCara = ana.pagar(1000.0);
        System.out.println("Corrida de R$ 1000,00 paga? " + pagouCara);

        ana.exibirDados();
    }
}
