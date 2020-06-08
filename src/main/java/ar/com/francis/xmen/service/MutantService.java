package ar.com.francis.xmen.service;

import java.math.BigDecimal;

/**
 * Servicio responsable de verificar si un humano es mutante.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public interface MutantService {

    /**
     * Verifica si un humano es mutante a partir de la secuencia de ADN.
     *
     * @param dna
     * @return true/false
     */
    public boolean isMutant(String[] dna);

    /**
     * Obtiene el ratio de mutantes registrados
     * [countMutant/(countMutant+countHuman)].
     *
     * @param countMutant
     * @param countHuman
     * @return ratio de mutantes
     */
    public BigDecimal getRatioMutant(int countMutant, int countHuman);

    /**
     * Obtiene la cantidad de mutantes registrados.
     *
     * @return cantidad de humanos mutantes
     */
    public int getCountMutant();

    /**
     * Obtiene la cantidad de humanos registrados.
     *
     * @return cantidad de humanos no mutantes
     */
    public int getCountHuman();
}
