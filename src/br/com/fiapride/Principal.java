package br.com.fiapride;

import br.com.fiapride.model.Passageiro;

public class Principal {

    public static void main(String[] args) {
        Passageiro ana = new Passageiro();
        ana.setNome("Ana Silva");
        ana.setNome("   "); // barrado: nome em branco
        ana.adicionarSaldo(50.0);

        // ana.saldo = 1_000_000; -> não compila mais! O atributo é private.

        ana.pagar(35.90);
        System.out.printf("%s ficou com R$ %.2f%n", ana.getNome(), ana.getSaldo());
    }
}
