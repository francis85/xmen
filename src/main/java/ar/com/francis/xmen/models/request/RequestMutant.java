package ar.com.francis.xmen.models.request;

import java.io.Serializable;

/**
 * Clase request para consultar si una secuencia de ADN corresponde a un humano
 * mutante.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public class RequestMutant implements Serializable {

    private static final long serialVersionUID = 1L;

    private String[] dna;

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }


}
