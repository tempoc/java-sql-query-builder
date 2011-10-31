package net.inator.qb2;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/26/11
 * Time: 9:09 PM
 */
public class Join {

    private final JoinType type;
    private final String clause;

    public Join(String clause) {
        this.type = JoinType.JOIN;
        this.clause = clause;
    }

    public Join(JoinType type, String clause) {
        this.type = type;
        this.clause = clause;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(type.getName());

        sb.append(" ").append(clause);

        return sb.toString();
    }

    public enum JoinType {
        JOIN("join"),
        LEFT_OUTER("left outer join");

        private String name;

        JoinType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
