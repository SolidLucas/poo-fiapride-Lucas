package br.com.rpa;

import br.com.rpa.model.Robo;

public class PrincipalRpa {

    public static void main(String[] args) {
        Robo roboNotas = new Robo();
        roboNotas.nome = "Leitor de Notas Fiscais";
        roboNotas.plataforma = "Python";

        roboNotas.registrarExecucao(95, 5);
        roboNotas.registrarExecucao(-10, 0); // barrado

        System.out.printf("%s -> taxa de sucesso: %.1f%%%n",
                roboNotas.nome, roboNotas.calcularTaxaSucesso());
    }
}
