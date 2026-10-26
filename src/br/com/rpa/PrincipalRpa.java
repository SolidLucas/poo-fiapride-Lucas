package br.com.rpa;

import br.com.rpa.model.Robo;

public class PrincipalRpa {

    public static void main(String[] args) {
        Robo roboNotas = new Robo();
        roboNotas.nome = "Leitor de Notas Fiscais";
        roboNotas.plataforma = "Python";
        roboNotas.itensProcessados = 0;

        System.out.println("Robô: " + roboNotas.nome + " (" + roboNotas.plataforma + ")");
    }
}
