package net.inator.qb2.booleanclauses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 11:25 AM
 */
public abstract class LinearBooleanExpression implements BooleanExpression {
    private final List<BooleanExpression> expressions;

    protected LinearBooleanExpression() {
        this.expressions = new ArrayList<BooleanExpression>();
    }

    protected LinearBooleanExpression(List<BooleanExpression> expressions) {
        this.expressions = expressions;
    }

    protected LinearBooleanExpression(BooleanExpression... expressions) {
        this.expressions = new ArrayList<BooleanExpression>();

        Collections.addAll(this.expressions, expressions);
    }

    protected LinearBooleanExpression(String... expressions) {
        this.expressions = new ArrayList<BooleanExpression>();
        for(String expression : expressions) {
            this.expressions.add(new StringBooleanExpression(expression));
        }
    }

    public LinearBooleanExpression append(String expression) {
        expressions.add(new StringBooleanExpression(expression));
        return this;
    }

    public LinearBooleanExpression append(BooleanExpression expression) {
        expressions.add(expression);
        return this;
    }

    protected abstract String operatorString();

    public List<BooleanExpression> getExpressions() {
        return expressions;
    }

    private String operandToString(BooleanExpression expression) {
        StringBuilder sb = new StringBuilder();
        final boolean isStringBased = expression instanceof StringBooleanExpression;
        if(!isStringBased) {
            sb.append("(");
        }
        sb.append(expression.toString());
        if(!isStringBased) {
            sb.append(")");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        boolean notFirst = false;
        for(BooleanExpression expression : getExpressions()) {
            if(notFirst) {
                sb.append(operatorString());
            } else {
                notFirst = true;
            }

            sb.append(operandToString(expression));
        }

        return sb.toString();
    }
}
