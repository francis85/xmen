package ar.com.francis.xmen.models.entity;

import java.io.Serializable;


/**
 * Clase base de la que heredan todas las entidades del modelo. PK es la clase
 * ID para la entidad
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 * @param <PK>
 */
public abstract class BaseEntity<PK extends Serializable> implements Serializable {

    private static final long serialVersionUID = 5L;

    /**
     * Retorna true si la entidad es puede considerarse como nueva.
     *
     * @return
     */
    public boolean esNueva() {
        return getId() == null;
    }

    /**
     * Retorna el objeto que es la clave de la entidad
     *
     * @return
     */
    public abstract PK getId();

    /**
     * Retorna un objeto clave primaria a partir de la representación en String
     * del Id
     *
     * @param id
     * @return
     */
    public PK calculateId(String id) {
        if (this.getId() instanceof Integer) {
            return (PK) Integer.valueOf(id);
        }
        if (this.getId() instanceof Long) {
            return (PK) Long.valueOf(id);
        }
        if (this.getId() instanceof String) {
            return (PK) id;
        }
        return null;
    }

    /**
     * Retorna la representación en String del ID de la clase que puede ser
     * vuelta a convertir en ID
     *
     * @return
     */
    public String getStringId() {
        if (getId() != null) {
            return String.valueOf(getId());
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof BaseEntity)) {
            return false;
        }

        BaseEntity other = (BaseEntity) obj;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.
                getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        final int prime = 31;
        hash += prime + (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return String.format("%s [id=%s]", this.getClass().getName(), String.valueOf(getId()));
    }

}
