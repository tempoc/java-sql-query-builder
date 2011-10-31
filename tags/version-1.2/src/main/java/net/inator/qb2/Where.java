package net.inator.qb2;

import net.inator.qb2.booleanexpressions.Exp;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 10:42 AM
 */
public class Where {
    private String clause;
    private Exp exp;

    public Where(String clause) {
        this.clause = clause;
    }

    public Where(Exp exp) {
        this.exp = exp;
    }

    public boolean isEmpty() {
        return (clause==null && exp ==null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("where");

        if(clause!=null) {
            sb.append(" ").append(clause);
        } else {
            sb.append(" ").append(exp.toString());
        }

        return sb.toString();
    }
}
