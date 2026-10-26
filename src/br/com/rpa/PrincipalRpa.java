package br.com.rpa;

import java.util.List;

import br.com.rpa.model.Execucao;
import br.com.rpa.model.Robo;
import br.com.rpa.model.RoboAutomationAnywhere;
import br.com.rpa.model.RoboPowerAutomate;
import br.com.rpa.model.RoboPython;

public class PrincipalRpa {

    public static void main(String[] args) {
        // Robo generico = new Robo("?", "?", 1); -> não compila: Robo é abstract

        List<Robo> centroDeExcelencia = List.of(
                new RoboPython("Leitor de Notas Fiscais", "3.12"),
                new RoboPowerAutomate("Triagem de E-mails", true),
                new RoboAutomationAnywhere("Lançamento no SAP", 3));

        int lote = 300;
        System.out.println("=== Estimativa para um lote de " + lote + " itens ===");
        for (Robo robo : centroDeExcelencia) {
            System.out.printf("%-25s %-20s %6.0f s%n",
                    robo.getNome(), robo.getPlataforma(), robo.estimarTempoExecucao(lote));
        }

        new Execucao(centroDeExcelencia.get(0), "NFs de segunda", 200).concluir(10);
        centroDeExcelencia.get(0).exibirInfo();
    }
}
