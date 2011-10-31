package net.inator.qb2.booleanexpressions;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 12:19 PM
 */
public class All extends LinearExp {

    public All() {
    }

    public All(List<CharSequence> exps) {
        super(exps);
    }

    public All(CharSequence... exps) {
        super(exps);
    }

    public All(String... expressions) {
        super(expressions);
    }

    @Override
    protected String operatorString() {
        return " and ";
    }
}
