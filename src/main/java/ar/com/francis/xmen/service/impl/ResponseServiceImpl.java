package ar.com.francis.xmen.service.impl;

import ar.com.francis.xmen.eao.AbstractFacade;
import ar.com.francis.xmen.models.response.ResponseMutant;
import ar.com.francis.xmen.models.response.ResponseStats;
import ar.com.francis.xmen.models.entity.Xmen;
import ar.com.francis.xmen.service.MutantService;
import ar.com.francis.xmen.service.ResponseService;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Implementa el servicio ResponseService.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public class ResponseServiceImpl implements ResponseService {

    private final MutantService mutantService;
    private final AbstractFacade facade;

    public ResponseServiceImpl(MutantService mutantService, AbstractFacade facade) {
        this.mutantService = mutantService;
        this.facade = facade;
    }

    @Override
    public ResponseMutant getResponseMutant(String[] dna) {

        boolean mutant = this.mutantService.isMutant(dna);

        ResponseMutant responseMutant = new ResponseMutant();
        responseMutant.setMutant(mutant);

        Xmen xmen = new Xmen();
        xmen.setDna(Arrays.toString(dna));
        xmen.setMutant(mutant);
        this.facade.create(xmen);

        return responseMutant;
    }

    @Override
    public ResponseStats getResponseStats() {

        int countHuman = this.mutantService.getCountHuman();
        int countMutant = this.mutantService.getCountMutant();
        BigDecimal ratioMutant = this.mutantService.getRatioMutant(countMutant, countHuman);

        ResponseStats responseStats = new ResponseStats();
        responseStats.setCount_human_dna(countHuman);
        responseStats.setCount_mutant_dna(countMutant);
        responseStats.setRatio(ratioMutant);

        return responseStats;
    }

}
