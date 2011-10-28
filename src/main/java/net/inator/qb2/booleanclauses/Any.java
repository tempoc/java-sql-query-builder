package net.inator.qb2.booleanclauses;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 11:38 AM
 */
public class Any extends LinearBooleanExpression {

    public Any() {
    }

    public Any(List<BooleanExpression> expressions) {
        super(expressions);
    }

    public Any(BooleanExpression... expressions) {
        super(expressions);
    }

    public Any(String... expressions) {
        super(expressions);
    }

    @Override
    protected String operatorString() {
        return " or ";
    }
}
