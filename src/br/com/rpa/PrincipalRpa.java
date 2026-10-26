package br.com.rpa;

import java.util.List;

import br.com.rpa.model.Agendavel;
import br.com.rpa.model.Execucao;
import br.com.rpa.model.Robo;
import br.com.rpa.model.RoboAutomationAnywhere;
import br.com.rpa.model.RoboPowerAutomate;
import br.com.rpa.model.RoboPython;

/**
 * Demonstração final do desafio pessoal: Central de Robôs RPA.
 */
public class PrincipalRpa {

    public static void main(String[] args) {
        RoboPython roboNotas = new RoboPython("Leitor de Notas Fiscais", "3.12");
        RoboPowerAutomate roboEmail = new RoboPowerAutomate("Triagem de E-mails", true);
        RoboAutomationAnywhere roboSap = new RoboAutomationAnywhere("Lançamento no SAP", 3);

        List<Robo> centroDeExcelencia = List.of(roboNotas, roboEmail, roboSap);

        int lote = 300;
        System.out.println("=== Estimativa para um lote de " + lote + " itens ===");
        for (Robo robo : centroDeExcelencia) {
            System.out.printf("%-25s %-20s %6.0f s%n",
                    robo.getNome(), robo.getPlataforma(), robo.estimarTempoExecucao(lote));
        }

        System.out.println("\n=== Agendamentos ===");
        roboNotas.agendar("0 6 * * *");
        roboEmail.agendar("toda hora"); // inválido -> mantém o padrão
        for (Robo robo : centroDeExcelencia) {
            if (robo instanceof Agendavel agendavel) {
                System.out.println(robo.getNome() + " -> " + agendavel.getAgendamento());
            } else {
                System.out.println(robo.getNome() + " -> disparo manual pelo Control Room");
            }
        }

        System.out.println("\n=== Execuções ===");
        new Execucao(roboNotas, "NFs de segunda", 200).concluir(10);
        new Execucao(roboEmail, "Caixa do financeiro", 80).concluir(0);
        new Execucao(roboSap, "Pedidos de compra", 50).concluir(5);

        System.out.println("\n=== Painel ===");
        centroDeExcelencia.forEach(Robo::exibirInfo);
    }
}
