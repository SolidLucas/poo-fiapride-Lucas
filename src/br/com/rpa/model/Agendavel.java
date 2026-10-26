package br.com.rpa.model;

/**
 * Contrato para robôs que podem rodar sozinhos, em horário agendado.
 */
public interface Agendavel {

    // Padrão da equipe: dias úteis às 08:00 (formato cron)
    String CRON_PADRAO = "0 8 * * 1-5";

    void agendar(String expressaoCron);

    String getAgendamento();
}
