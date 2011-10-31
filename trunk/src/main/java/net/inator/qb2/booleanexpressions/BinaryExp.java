package net.inator.qb2.booleanexpressions;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 10:46 AM
 */
public abstract class BinaryExp implements Exp {
    private Exp firstExp;
    private Exp secondExp;

    protected BinaryExp(Exp firstExp,
                        Exp secondExp) {
        this.firstExp = firstExp;
        this.secondExp = secondExp;
    }

    protected BinaryExp(String firstBooleanExpression,
                        String secondBooleanExpression) {
        this.firstExp = new StringExp(firstBooleanExpression);
        this.secondExp = new StringExp(secondBooleanExpression);
    }

    protected BinaryExp(String firstBooleanExpression,
                        Exp secondExp) {
        this.firstExp = new StringExp(firstBooleanExpression);
        this.secondExp = secondExp;
    }

    protected BinaryExp(Exp firstExp,
                        String secondBooleanExpression) {
        this.firstExp = firstExp;
        this.secondExp = new StringExp(secondBooleanExpression);
    }

    public String firstOperandToString() {
        return operandToString(firstExp);
    }

    public String secondOperandToString() {
        return operandToString(secondExp);
    }

    private String operandToString(Exp exp) {
        StringBuilder sb = new StringBuilder();
        final boolean isStringBased = exp instanceof StringExp;
        if(!isStringBased) {
            sb.append("(");
        }
        sb.append(exp.toString());
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
