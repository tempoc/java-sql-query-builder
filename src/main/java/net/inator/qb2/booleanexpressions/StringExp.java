package net.inator.qb2.booleanexpressions;

import net.inator.qb2.Q;
import net.inator.qb2.listables.Listable;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 11:47 AM
 */
public class StringExp implements Exp {
    private final String expression;
    private In in;

    public StringExp(String expression) {
        this.expression = expression;
    }

    public StringExp in(String s) {
        in = new In(Listable.parse(s));
        return this;
    }

    public <T> StringExp in(T... a) {
        in = new In(Listable.parse(a));
        return this;
    }

    public <T> StringExp in(Collection<T> c) {
        in = new In(Listable.parse(c));
        return this;
    }

    public StringExp in(Q subQuery) {
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

    public int length() {
        return toString().length();
    }

    public char charAt(int index) {
        return toString().charAt(index);
    }

    public CharSequence subSequence(int start, int end) {
        return toString().subSequence(start, end);
    }
}
