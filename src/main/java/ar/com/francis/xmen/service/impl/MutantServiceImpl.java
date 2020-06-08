package ar.com.francis.xmen.service.impl;

import ar.com.francis.xmen.controllers.InstantApp;
import ar.com.francis.xmen.eao.AbstractFacade;
import ar.com.francis.xmen.filter.XmenSearchFilter;
import ar.com.francis.xmen.models.Adn;
import ar.com.francis.xmen.models.SecuenciaAdn;
import java.util.ArrayList;
import java.util.List;
import ar.com.francis.xmen.service.MutantService;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Implementa el servicio MutantService.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public class MutantServiceImpl implements MutantService {

    private static final String SECUENCIA_A = "AAAA";
    private static final String SECUENCIA_T = "TTTT";
    private static final String SECUENCIA_C = "CCCC";
    private static final String SECUENCIA_G = "GGGG";
    private static final int CANTIDAD_ELEMENTOS_IGUALES = 4;
    private static final int CANTIDAD_MINIMA_SECUENCIA_IGUALES = 2;

    @Override
    public boolean isMutant(String[] dna) {

        List<SecuenciaAdn> secuenciaAdnList = new ArrayList<>();

        for (int i = 0; i < dna.length; i++) {
            SecuenciaAdn secuenciaAdn = new SecuenciaAdn();
            secuenciaAdn.setBaseNitrogenada(dna[i].toUpperCase());
            secuenciaAdnList.add(secuenciaAdn);
        }

        Adn adn = new Adn(CANTIDAD_ELEMENTOS_IGUALES, secuenciaAdnList);

        int cantidadSecuenciasIguales = 0;
        if (adn.verificarDimensionMinimaArreglo() && adn.verificarTablaNxN()) {
            cantidadSecuenciasIguales = getCantidadSecuencias(adn.getSecuenciaHorizontal());

            cantidadSecuenciasIguales = cantidadSecuenciasIguales
                    + getCantidadSecuencias(adn.getSecuenciaVertical());

            cantidadSecuenciasIguales = cantidadSecuenciasIguales
                    + getCantidadSecuencias(adn.getSecuenciaOblicua());
        }

        if (cantidadSecuenciasIguales >= CANTIDAD_MINIMA_SECUENCIA_IGUALES) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    private int getCantidadSecuencias(List<SecuenciaAdn> listSecuenciaADN) {
        int cantidadSecuenciasIguales = 0;
        for (SecuenciaAdn secuenciaAdn : listSecuenciaADN) {
            if (secuenciaLetrasIguales(secuenciaAdn.getBaseNitrogenada())) {
                cantidadSecuenciasIguales++;
            }
        }
        return cantidadSecuenciasIguales;
    }

    private boolean secuenciaLetrasIguales(String secuencia) {
        if (secuencia.contains(SECUENCIA_A)) {
            return Boolean.TRUE;
        } else if (secuencia.contains(SECUENCIA_T)) {
            return Boolean.TRUE;

        } else if (secuencia.contains(SECUENCIA_C)) {
            return Boolean.TRUE;

        } else if (secuencia.contains(SECUENCIA_G)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public BigDecimal getRatioMutant(int countMutant, int countHuman) {
        int total = countHuman + countMutant;

        if (total > 0) {
            return new BigDecimal(countMutant).divide(new BigDecimal(total), 4, RoundingMode.HALF_UP);
        }

        return BigDecimal.ZERO;
    }

    @Override
    public int getCountMutant() {
        XmenSearchFilter xmenSearchFilter = new XmenSearchFilter();
        xmenSearchFilter.setMutant(Boolean.TRUE);

        AbstractFacade xmenFacade = InstantApp.resolveFacade();
        return xmenFacade.countBySearchFilter(xmenSearchFilter);
    }

    @Override
    public int getCountHuman() {
        XmenSearchFilter xmenSearchFilter = new XmenSearchFilter();
        xmenSearchFilter.setMutant(Boolean.FALSE);

        AbstractFacade xmenFacade = InstantApp.resolveFacade();
        return xmenFacade.countBySearchFilter(xmenSearchFilter);
    }
}
