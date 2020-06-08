package ar.com.francis.xmen.eao;

import ar.com.francis.xmen.filter.XmenSearchFilter;
import ar.com.francis.xmen.models.entity.Xmen;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Capa de acceso a datos de la entidad Xmen.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public class XmenFacade extends AbstractFacade<Xmen, XmenSearchFilter> {

    public XmenFacade() {
        super(Xmen.class);
    }

    @Override
    protected DynamoDBScanExpression createWhereFromSearchFilter(XmenSearchFilter sf) {
        Map<String, AttributeValue> eav = new HashMap<>();
        String expression = null;
        if (sf.hasFilterMunt()) {
            eav.put(":mutant", new AttributeValue().withBOOL(sf.getMutant()));
            String exp1 = "mutant = :mutant";
            expression = appendAndConditionExpression(expression, exp1);
        }

        return getScanExpression(eav, expression);
    }

}
