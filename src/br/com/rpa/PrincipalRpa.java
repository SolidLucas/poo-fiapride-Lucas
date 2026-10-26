package br.com.rpa;

import br.com.rpa.model.Execucao;
import br.com.rpa.model.RoboAutomationAnywhere;
import br.com.rpa.model.RoboPowerAutomate;
import br.com.rpa.model.RoboPython;

public class PrincipalRpa {

    public static void main(String[] args) {
        RoboPython roboNotas = new RoboPython("Leitor de Notas Fiscais", "3.12");
        RoboPowerAutomate roboEmail = new RoboPowerAutomate("Triagem de E-mails", false);
        RoboAutomationAnywhere roboSap = new RoboAutomationAnywhere("Lançamento no SAP", 3);

        // Execucao aceita qualquer filha de Robo
        new Execucao(roboNotas, "NFs de segunda", 200).concluir(10);
        new Execucao(roboEmail, "Caixa do financeiro", 80).concluir(0);
        new Execucao(roboSap, "Pedidos de compra", 50).concluir(5);

        // Método herdado da mãe
        roboNotas.exibirInfo();
        roboEmail.exibirInfo();
        roboSap.exibirInfo();

        System.out.println("Versão do Python: " + roboNotas.getVersaoPython());
        System.out.println("Bot Runners do AA: " + roboSap.getBotRunnersDisponiveis());
    }
}
