package br.com.rpa.model;

/**
 * Contrato para robôs que avisam o time quando terminam ou dão erro.
 */
public interface Notificavel {

    String CANAL_PADRAO = "Teams #squad-automacao";

    void notificar(String mensagem);
}
