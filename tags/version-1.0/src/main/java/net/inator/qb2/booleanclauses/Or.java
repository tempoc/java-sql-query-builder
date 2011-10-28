package net.inator.qb2.booleanclauses;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 11:34 AM
 */
public class Or extends BinaryBooleanExpression {
    public Or(BooleanExpression firstBooleanExpression, BooleanExpression secondBooleanExpression) {
        super(firstBooleanExpression, secondBooleanExpression);
    }

    public Or(String firstBooleanExpression, String secondBooleanExpression) {
        super(firstBooleanExpression, secondBooleanExpression);
    }

    public Or(String firstBooleanExpression, BooleanExpression secondBooleanExpression) {
        super(firstBooleanExpression, secondBooleanExpression);
    }

    public Or(BooleanExpression firstBooleanExpression, String secondBooleanExpression) {
        super(firstBooleanExpression, secondBooleanExpression);
    }

    @Override
    protected String operatorString() {
        return " or ";
    }
}

