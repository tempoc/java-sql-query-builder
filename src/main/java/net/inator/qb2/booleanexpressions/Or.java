package net.inator.qb2.booleanexpressions;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 11:34 AM
 */
public class Or extends BinaryExp {
    public Or(Exp firstExp, Exp secondExp) {
        super(firstExp, secondExp);
    }

    public Or(String firstBooleanExpression, String secondBooleanExpression) {
        super(firstBooleanExpression, secondBooleanExpression);
    }

    public Or(String firstBooleanExpression, Exp secondExp) {
        super(firstBooleanExpression, secondExp);
    }

    public Or(Exp firstExp, String secondBooleanExpression) {
        super(firstExp, secondBooleanExpression);
    }

    @Override
    protected String operatorString() {
        return " or ";
    }
}

