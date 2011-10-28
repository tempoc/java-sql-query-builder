package net.inator.qb2.booleanclauses;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 10:46 AM
 */
public abstract class BinaryBooleanExpression implements BooleanExpression {
    private BooleanExpression firstBooleanExpression;
    private BooleanExpression secondBooleanExpression;

    protected BinaryBooleanExpression(BooleanExpression firstBooleanExpression,
                                      BooleanExpression secondBooleanExpression) {
        this.firstBooleanExpression = firstBooleanExpression;
        this.secondBooleanExpression = secondBooleanExpression;
    }

    protected BinaryBooleanExpression(String firstBooleanExpression,
                                      String secondBooleanExpression) {
        this.firstBooleanExpression = new StringBooleanExpression(firstBooleanExpression);
        this.secondBooleanExpression = new StringBooleanExpression(secondBooleanExpression);
    }

    protected BinaryBooleanExpression(String firstBooleanExpression,
                                      BooleanExpression secondBooleanExpression) {
        this.firstBooleanExpression = new StringBooleanExpression(firstBooleanExpression);
        this.secondBooleanExpression = secondBooleanExpression;
    }

    protected BinaryBooleanExpression(BooleanExpression firstBooleanExpression,
                                      String secondBooleanExpression) {
        this.firstBooleanExpression = firstBooleanExpression;
        this.secondBooleanExpression = new StringBooleanExpression(secondBooleanExpression);
    }

    public String firstOperandToString() {
        return operandToString(firstBooleanExpression);
    }

    public String secondOperandToString() {
        return operandToString(secondBooleanExpression);
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

    protected abstract String operatorString();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(firstOperandToString()).append(operatorString()).append(secondOperandToString());

        return sb.toString();
    }
}
