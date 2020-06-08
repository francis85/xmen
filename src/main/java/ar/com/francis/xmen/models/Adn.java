package ar.com.francis.xmen.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para gestionar las secuencias de ADN.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public class Adn {

    private int cantidadLetrasIguales;
    private List<SecuenciaAdn> secuenciaAdnList;

    public Adn(int cantidadLetrasIguales, List<SecuenciaAdn> secuenciaAdnList) {
        this.cantidadLetrasIguales = cantidadLetrasIguales;
        this.secuenciaAdnList = secuenciaAdnList;
    }

    public List<SecuenciaAdn> getSecuenciaAdnList() {
        return secuenciaAdnList;
    }

    public void setSecuenciaAdnList(List<SecuenciaAdn> secuenciaAdnList) {
        this.secuenciaAdnList = secuenciaAdnList;
    }

    public int getCantidadLetrasIguales() {
        return cantidadLetrasIguales;
    }

    public void setCantidadLetrasIguales(int cantidadLetrasIguales) {
        this.cantidadLetrasIguales = cantidadLetrasIguales;
    }

    public List<SecuenciaAdn> getSecuenciaHorizontal() {
        return secuenciaAdnList;
    }

    public List<SecuenciaAdn> getSecuenciaVertical() {
        List<SecuenciaAdn> secuenciaVerticalList = new ArrayList<>();
        int longitudBaseNitrogenada = secuenciaAdnList.size();
        for (int columna = 0; columna < longitudBaseNitrogenada; columna++) {

            SecuenciaAdn secuenciaVertical = new SecuenciaAdn("");

            for (SecuenciaAdn secuenciaAdn : secuenciaAdnList) {
                Character letra = secuenciaAdn.getBaseNitrogenada().toCharArray()[columna];
                secuenciaVertical.setBaseNitrogenada(secuenciaVertical.getBaseNitrogenada().concat(letra.toString()));
            }
            secuenciaVerticalList.add(secuenciaVertical);
        }

        return secuenciaVerticalList;
    }

    public List<SecuenciaAdn> getSecuenciaOblicua() {
        List<SecuenciaAdn> secuenciaOblicuaList = new ArrayList<>();
        int dimensionN = secuenciaAdnList.size();

        for (int i = 0; i <= dimensionN - cantidadLetrasIguales; i++) {
            int columna = i;

            SecuenciaAdn secuenciaOblicua = new SecuenciaAdn("");

            for (SecuenciaAdn secuenciaAdn : secuenciaAdnList) {
                if (columna < dimensionN) {
                    Character letra = secuenciaAdn.getBaseNitrogenada().toCharArray()[columna];
                    secuenciaOblicua.setBaseNitrogenada(secuenciaOblicua.getBaseNitrogenada().concat(letra.toString()));
                    columna++;
                } else {
                    break;
                }
            }
            secuenciaOblicuaList.add(secuenciaOblicua);
        }

        for (int fila = 1; fila <= dimensionN - cantidadLetrasIguales; fila++) {

            SecuenciaAdn secuenciaOblicua = new SecuenciaAdn("");

            for (int columna = 0; columna < dimensionN - fila; columna++) {
                Character letra = secuenciaAdnList.get(fila + columna).getBaseNitrogenada().toCharArray()[columna];
                secuenciaOblicua.setBaseNitrogenada(secuenciaOblicua.getBaseNitrogenada().concat(letra.toString()));
            }
            secuenciaOblicuaList.add(secuenciaOblicua);
        }

        for (int fila = dimensionN - 1; fila >= cantidadLetrasIguales - 1; fila--) {

            SecuenciaAdn secuenciaOblicua = new SecuenciaAdn("");

            for (int columna = 0; columna <= fila; columna++) {
                Character letra = secuenciaAdnList.get(fila - columna).getBaseNitrogenada().toCharArray()[columna];
                secuenciaOblicua.setBaseNitrogenada(secuenciaOblicua.getBaseNitrogenada().concat(letra.toString()));
            }
            secuenciaOblicuaList.add(secuenciaOblicua);
        }

        for (int columna = 1; columna <= dimensionN - cantidadLetrasIguales; columna++) {

            SecuenciaAdn secuenciaOblicua = new SecuenciaAdn("");
            int contador = 0;
            for (int fila = dimensionN - 1; fila >= columna; fila--) {
                Character letra = secuenciaAdnList.get(fila).getBaseNitrogenada().toCharArray()[columna + contador];
                secuenciaOblicua.setBaseNitrogenada(secuenciaOblicua.getBaseNitrogenada().concat(letra.toString()));
                contador++;
            }
            secuenciaOblicuaList.add(secuenciaOblicua);
        }

        return secuenciaOblicuaList;
    }

    public boolean verificarTablaNxN() {
        int dimensionArreglo = secuenciaAdnList.size();
        for (SecuenciaAdn secuenciaAdn : secuenciaAdnList) {
            if (secuenciaAdn.getBaseNitrogenada() == null
                    || secuenciaAdn.getBaseNitrogenada().length() != dimensionArreglo) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public boolean verificarDimensionMinimaArreglo() {
        if (secuenciaAdnList != null && secuenciaAdnList.size() > 0) {
            int dimensionArreglo = secuenciaAdnList.size();
            if (dimensionArreglo >= cantidadLetrasIguales) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

}
