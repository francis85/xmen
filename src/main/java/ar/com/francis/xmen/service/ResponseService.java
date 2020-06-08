package ar.com.francis.xmen.service;

import ar.com.francis.xmen.models.response.ResponseMutant;
import ar.com.francis.xmen.models.response.ResponseStats;

/**
 * Servicio responsable de obtener los response.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public interface ResponseService {

    /**
     * Obtiene el response de si un humano es mutante por medio de la secuencia
     * de ADN.
     *
     * @param dna
     * @return ResponseMutant
     */
    public ResponseMutant getResponseMutant(String[] dna);

    /**
     * Obtiene el response del ratio de mutantes consultados.
     *
     * @return ResponseStats
     */
    public ResponseStats getResponseStats();

}
