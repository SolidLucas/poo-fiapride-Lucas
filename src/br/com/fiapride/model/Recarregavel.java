package br.com.fiapride.model;

/**
 * Contrato para qualquer coisa que tenha bateria e possa ser recarregada.
 * Não é um "tipo de veículo": é uma CAPACIDADE. Por isso é interface, e não classe mãe.
 */
public interface Recarregavel {

    // Constantes de interface: implicitamente public static final
    int CARGA_MAXIMA_PERCENTUAL = 100;
    int CARGA_MINIMA_PARA_CORRIDA = 20;

    /**
     * @param percentual quantos pontos percentuais adicionar à bateria
     */
    void recarregar(int percentual);

    int getNivelBateria();
}
