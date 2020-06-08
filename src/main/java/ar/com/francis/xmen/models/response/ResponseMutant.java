package ar.com.francis.xmen.models.response;

import java.io.Serializable;

/**
 * Clase response para obtener si un humano es mutante.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public class ResponseMutant implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean mutant;

    public boolean isMutant() {
        return mutant;
    }

    public void setMutant(boolean mutant) {
        this.mutant = mutant;
    }

}
