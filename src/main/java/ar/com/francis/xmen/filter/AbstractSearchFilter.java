package ar.com.francis.xmen.filter;

import java.io.Serializable;

/**
 * Clase abstracta que representa una agrupación de criterios de filtrado.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public abstract class AbstractSearchFilter implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract boolean hasFilter();

}
