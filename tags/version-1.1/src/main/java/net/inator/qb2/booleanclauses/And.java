package net.inator.qb2.booleanclauses;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 11:03 AM
 */
public class And extends BinaryBooleanExpression {

    public And(BooleanExpression firstBooleanExpression, BooleanExpression secondBooleanExpression) {
        super(firstBooleanExpression, secondBooleanExpression);
    }

    public And(String firstBooleanExpression, String secondBooleanExpression) {
        super(firstBooleanExpression, secondBooleanExpression);
    }

    public And(String firstBooleanExpression, BooleanExpression secondBooleanExpression) {
        super(firstBooleanExpression, secondBooleanExpression);
    }

    public And(BooleanExpression firstBooleanExpression, String secondBooleanExpression) {
        super(firstBooleanExpression, secondBooleanExpression);
    }

    @Override
    protected String operatorString() {
        return " and ";
    }
}
