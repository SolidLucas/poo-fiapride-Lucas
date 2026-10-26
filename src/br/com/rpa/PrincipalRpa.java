package br.com.rpa;

import br.com.rpa.model.Robo;

public class PrincipalRpa {

    public static void main(String[] args) {
        Robo roboNotas = new Robo();
        roboNotas.setNome("Leitor de Notas Fiscais");
        roboNotas.setPlataforma("Python");
        roboNotas.setPlataforma(""); // barrado

        roboNotas.registrarExecucao(95, 5);

        System.out.printf("%s (%s) -> taxa de sucesso: %.1f%%%n",
                roboNotas.getNome(), roboNotas.getPlataforma(), roboNotas.calcularTaxaSucesso());
    }
}
