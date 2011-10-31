package net.inator.qb2.booleanexpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 11:25 AM
 */
public abstract class LinearExp implements Exp {
    private final List<CharSequence> exps;

    protected LinearExp() {
        this.exps = new ArrayList<CharSequence>();
    }

    protected LinearExp(List<CharSequence> exps) {
        this.exps = exps;
    }

    protected LinearExp(CharSequence... exps) {
        this.exps = new ArrayList<CharSequence>();

        Collections.addAll(this.exps, exps);
    }

    protected LinearExp(String... expressions) {
        this.exps = new ArrayList<CharSequence>();
        for(String expression : expressions) {
            this.exps.add(new StringExp(expression));
        }
    }

    public LinearExp append(String expression) {
        exps.add(new StringExp(expression));
        return this;
    }

    public LinearExp append(Exp exp) {
        exps.add(exp);
        return this;
    }

    protected abstract String operatorString();

    public List<CharSequence> getExps() {
        return exps;
    }

    private String operandToString(CharSequence exp) {
        StringBuilder sb = new StringBuilder();
        final boolean isStringBased = (exp instanceof Exp && exp instanceof StringExp) || !(exp instanceof Exp);
        if(!isStringBased) {
            sb.append("(");
        }
        sb.append(exp.toString());
        if(!isStringBased) {
            sb.append(")");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        boolean notFirst = false;
        for(CharSequence exp : getExps()) {
            if(notFirst) {
                sb.append(operatorString());
            } else {
                notFirst = true;
            }

            sb.append(operandToString(exp));
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
