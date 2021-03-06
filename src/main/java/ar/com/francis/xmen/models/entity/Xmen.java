package ar.com.francis.xmen.models.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;

/**
 * Clase que representa si un humano es mutante por medio de la secuencia de
 * ADN.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
@DynamoDBTable(tableName = "xmen")
public class Xmen extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey()
    private String id;
    @DynamoDBAttribute(attributeName = "dna")
    private String dna;
    @DynamoDBAttribute(attributeName = "mutant")
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL)
    private Boolean mutant;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDna() {
        return dna;
    }

    public void setDna(String dna) {
        this.dna = dna;
    }

    public Boolean getMutant() {
        return mutant;
    }

    public void setMutant(Boolean mutant) {
        this.mutant = mutant;
    }


}
