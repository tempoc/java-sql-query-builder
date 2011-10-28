package net.inator.qb2.booleanclauses;

import net.inator.qb2.Q;
import net.inator.qb2.listables.Listable;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 11:47 AM
 */
public class StringBooleanExpression implements BooleanExpression{
    private final String expression;
    private In in;

    public StringBooleanExpression(String expression) {
        this.expression = expression;
    }

    public StringBooleanExpression in(String s) {
        in = new In(Listable.parse(s));
        return this;
    }

    public <T> StringBooleanExpression in(T... a) {
        in = new In(Listable.parse(a));
        return this;
    }

    public <T> StringBooleanExpression in(Collection<T> c) {
        in = new In(Listable.parse(c));
        return this;
    }

    public StringBooleanExpression in(Q subQuery) {
        in = new In(subQuery);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(expression);

        if(in!=null) {
            sb.append(" in (").append(in.toString()).append(")");
        }

        return sb.toString();
    }
}
