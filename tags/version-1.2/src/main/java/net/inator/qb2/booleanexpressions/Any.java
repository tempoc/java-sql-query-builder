package net.inator.qb2.booleanexpressions;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 11:38 AM
 */
public class Any extends LinearExp {

    public Any() {
    }

    public Any(List<CharSequence> exps) {
        super(exps);
    }

    public Any(CharSequence... exps) {
        super(exps);
    }

    public Any(String... expressions) {
        super(expressions);
    }

    @Override
    protected String operatorString() {
        return " or ";
    }
}
