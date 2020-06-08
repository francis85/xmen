package ar.com.francis.xmen.models;

/**
 * Clase para gestionar la base nitrogenada de ADN.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public class SecuenciaAdn {

    private String baseNitrogenada;

    public SecuenciaAdn() {
    }

    public SecuenciaAdn(String baseNitrogenada) {
        this.baseNitrogenada = baseNitrogenada;
    }

    public String getBaseNitrogenada() {
        return baseNitrogenada;
    }

    public void setBaseNitrogenada(String baseNitrogenada) {
        this.baseNitrogenada = baseNitrogenada;
    }


}
