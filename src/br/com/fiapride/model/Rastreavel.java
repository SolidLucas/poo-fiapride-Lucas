package br.com.fiapride.model;

/**
 * Contrato para veículos com GPS, que o app consegue mostrar no mapa.
 */
public interface Rastreavel {

    String PREFIXO_RASTREIO = "FR-GPS-";

    /**
     * @return descrição da posição atual do veículo
     */
    String obterLocalizacao();
}
