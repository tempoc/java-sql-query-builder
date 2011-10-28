package net.inator.qb2.booleanclauses;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 12:19 PM
 */
public class All extends LinearBooleanExpression {

    public All() {
    }

    public All(List<BooleanExpression> expressions) {
        super(expressions);
    }

    public All(BooleanExpression... expressions) {
        super(expressions);
    }

    public All(String... expressions) {
        super(expressions);
    }

    @Override
    protected String operatorString() {
        return " and ";
    }
}
