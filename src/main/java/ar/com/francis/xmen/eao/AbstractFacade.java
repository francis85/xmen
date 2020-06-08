package ar.com.francis.xmen.eao;

import ar.com.francis.xmen.filter.AbstractSearchFilter;
import ar.com.francis.xmen.models.entity.BaseEntity;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.Map;

/**
 * Clase abstracta para manejar la persistencia de entidades
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 * @param <T> La entidad que debe manejar el Facade
 * @param <U> El filtro a ser utilizado para esa entidad
 */
public abstract class AbstractFacade<T extends BaseEntity, U extends AbstractSearchFilter> {

    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected DynamoDBMapper getMapper() {
        return new DynamoDBMapper(getClient());
    }

    private AmazonDynamoDB getClient() {
        return AmazonDynamoDBClientBuilder.standard().build();
    }

    public void create(BaseEntity entity) {
        DynamoDBMapper mapper = getMapper();
        mapper.save(entity);
    }

    public int countBySearchFilter(U sf) {
        DynamoDBMapper mapper = getMapper();
        if (sf.hasFilter()) {
            return mapper.count(entityClass, createWhereFromSearchFilter(sf));
        } else {
            return mapper.count(entityClass, new DynamoDBScanExpression());
        }
    }

    protected abstract DynamoDBScanExpression createWhereFromSearchFilter(U sf);

    protected DynamoDBScanExpression getScanExpression(Map<String, AttributeValue> eav, String expression) {

        return new DynamoDBScanExpression()
                .withFilterExpression(expression)
                .withExpressionAttributeValues(eav);
    }

    protected String appendAndConditionExpression(String exp1, String exp2) {
        if (exp1 == null) {
            return exp2;
        } else if (exp2 == null) {
            return exp1;
        }
        return exp1.concat(" AND ").concat(exp2);
    }
}
