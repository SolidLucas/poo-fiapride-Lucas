package br.com.rpa;

import br.com.rpa.model.Robo;

public class PrincipalRpa {

    public static void main(String[] args) {
        Robo rascunho = new Robo();
        Robo roboNotas = new Robo("Leitor de Notas Fiscais");
        Robo roboEmail = new Robo("Triagem de E-mails", "Power Automate");

        roboNotas.registrarExecucao(95, 5);

        for (Robo robo : new Robo[] {rascunho, roboNotas, roboEmail}) {
            System.out.printf("%s (%s) -> taxa de sucesso: %.1f%%%n",
                    robo.getNome(), robo.getPlataforma(), robo.calcularTaxaSucesso());
        }
    }
}
