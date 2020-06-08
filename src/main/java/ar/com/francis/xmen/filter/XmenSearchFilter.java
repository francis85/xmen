package ar.com.francis.xmen.filter;

/**
 * Search filter para la entidad Xmen.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public class XmenSearchFilter extends AbstractSearchFilter {

    private static final long serialVersionUID = 1L;

    private Boolean mutant;

    @Override
    public boolean hasFilter() {
        return hasFilterMunt();
    }

    public boolean hasFilterMunt() {
        return mutant != null;
    }

    public Boolean getMutant() {
        return mutant;
    }

    public void setMutant(Boolean mutant) {
        this.mutant = mutant;
    }

}
