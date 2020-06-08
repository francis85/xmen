package ar.com.francis.xmen.models.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Clase response para obtener el ratio de mutantes.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public class ResponseStats implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer count_mutant_dna;
    private Integer count_human_dna;
    private BigDecimal ratio;

    public Integer getCount_mutant_dna() {
        return count_mutant_dna;
    }

    public void setCount_mutant_dna(Integer count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    public Integer getCount_human_dna() {
        return count_human_dna;
    }

    public void setCount_human_dna(Integer count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }
}
