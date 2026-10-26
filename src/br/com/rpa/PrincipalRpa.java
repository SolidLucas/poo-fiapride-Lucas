package br.com.rpa;

import br.com.rpa.model.Execucao;
import br.com.rpa.model.Robo;

public class PrincipalRpa {

    public static void main(String[] args) {
        Robo roboNotas = new Robo("Leitor de Notas Fiscais");

        Execucao segunda = new Execucao(roboNotas, "NFs de segunda", 200);
        Execucao terca = new Execucao(roboNotas, "NFs de terça", 150);

        segunda.concluir(10);
        terca.concluir(3);

        System.out.printf("%s acumulou %d itens ok -> taxa de sucesso: %.1f%%%n",
                roboNotas.getNome(), roboNotas.getItensProcessados(), roboNotas.calcularTaxaSucesso());
    }
}
