package net.inator.qb2.booleanexpressions;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 11:03 AM
 */
public class And extends BinaryExp {

    public And(Exp firstExp, Exp secondExp) {
        super(firstExp, secondExp);
    }

    public And(String firstBooleanExpression, String secondBooleanExpression) {
        super(firstBooleanExpression, secondBooleanExpression);
    }

    public And(String firstBooleanExpression, Exp secondExp) {
        super(firstBooleanExpression, secondExp);
    }

    public And(Exp firstExp, String secondBooleanExpression) {
        super(firstExp, secondBooleanExpression);
    }

    @Override
    protected String operatorString() {
        return " and ";
    }
}
