package br.com.fiapride;

import br.com.fiapride.model.Passageiro;

public class Principal {

    public static void main(String[] args) {
        Passageiro ana = new Passageiro();
        ana.nome = "Ana Silva";
        ana.saldo = 50.0;

        Passageiro bruno = new Passageiro();
        bruno.nome = "Bruno Costa";
        bruno.saldo = 20.0;

        System.out.println(ana.nome + " tem R$ " + ana.saldo);
        System.out.println(bruno.nome + " tem R$ " + bruno.saldo);
    }
}
