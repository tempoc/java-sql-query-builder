package net.inator.qb2;

import net.inator.qb2.booleanclauses.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/26/11
 * Time: 8:29 PM
 */
public class QueryTest {

    @Test
    public void selectStringTest() {
        Query q = new Query();
        q.select("mission.*");
        Assert.assertEquals("select mission.*", q.toString());
    }

    @Test
    public void selectArrayTest() {
        Query q = new Query();
        q.select("mission.*", "traveler.*");
        Assert.assertEquals("select mission.*, traveler.*", q.toString());
    }

    @Test
    public void selectCollectionTest() {
        Query q = new Query();

        final ArrayList<String> strings = new ArrayList<String>();
        strings.add("mission.*");
        strings.add("traveler.*");
        q.select(strings);
        Assert.assertEquals("select mission.*, traveler.*", q.toString());
    }

    @Test
    public void fromStringTest() {
        Query q = new Query();
        q.select("m.*").from("mission m");
        Assert.assertEquals("select m.* from mission m", q.toString());
    }

    @Test
    public void fromArrayTest() {
        Query q = new Query();
        q.select("m.*", "t.*").from("mission m", "traveler t");
        Assert.assertEquals("select m.*, t.* from mission m, traveler t", q.toString());
    }

    @Test
    public void fromCollectionTest() {
        final ArrayList<String> selects = new ArrayList<String>();
        selects.add("m.*");
        selects.add("t.*");

        final ArrayList<String> froms = new ArrayList<String>();
        froms.add("mission m");
        froms.add("traveler t");

        Query q = new Query();
        q.select(selects).from(froms);
        Assert.assertEquals("select m.*, t.* from mission m, traveler t", q.toString());
    }

    @Test
    public void testJoin() {
        Query q = new Query();
        q.select("*").from("mission m").join("m.traveler t");
        Assert.assertEquals("select * from mission m join m.traveler t", q.toString());
    }

    @Test
    public void testLeftOuterJoin() {
        Query q = new Query();
        q.select("*").from("mission m").leftOuterJoin("m.traveler t");
        Assert.assertEquals("select * from mission m left outer join m.traveler t", q.toString());
    }

    @Test
    public void whereStringTest() {
        Query q = new Query();
        q.select("m.*", "t.*").from("mission m", "traveler t").where("m.id=1");
        Assert.assertEquals("select m.*, t.* from mission m, traveler t where m.id=1", q.toString());
    }

    @Test
    public void andStringTest() {
        Query q = new Query();
        q.select("m.*", "t.*").from("mission m", "traveler t").where(
                new Where(new And("m.id=1", "t.id=2"))
        );
        Assert.assertEquals("select m.*, t.* from mission m, traveler t where m.id=1 and t.id=2", q.toString());
    }

    @Test
    public void andNestedTest() {
        Query q = new Query();
        q.select("m.*", "t.*").from("mission m", "traveler t").where(
                new Where(new And(new And("m.id=1", "t.id=2"), new And("m.id=1", "t.id=2")))
        );
        Assert.assertEquals("select m.*, t.* from mission m, traveler t where (m.id=1 and t.id=2) and (m.id=1 and t.id=2)", q.toString());
    }

    @Test
    public void andCombinedTest1() {
        Query q = new Query();
        q.select("m.*", "t.*").from("mission m", "traveler t").where(
                new Where(new And("m.id=1", new And("m.id=1", "t.id=2")))
        );
        Assert.assertEquals("select m.*, t.* from mission m, traveler t where m.id=1 and (m.id=1 and t.id=2)", q.toString());
    }

    @Test
    public void andCombinedTest2() {
        Query q = new Query();
        q.select("m.*", "t.*").from("mission m", "traveler t").where(
                new Where(new And(new And("m.id=1", "t.id=2"), "m.id=1"))
        );
        Assert.assertEquals("select m.*, t.* from mission m, traveler t where (m.id=1 and t.id=2) and m.id=1", q.toString());
    }

    @Test
    public void orStringTest() {
        Query q = new Query();
        q.select("m.*", "t.*").from("mission m", "traveler t").where(
                new Where(new Or("m.id=1", "t.id=2"))
        );
        Assert.assertEquals("select m.*, t.* from mission m, traveler t where m.id=1 or t.id=2", q.toString());
    }

    @Test
    public void orNestedTest() {
        Query q = new Query();
        q.select("m.*", "t.*").from("mission m", "traveler t").where(
                new Where(new Or(new Or("m.id=1", "t.id=2"), new Or("m.id=1", "t.id=2")))
        );
        Assert.assertEquals("select m.*, t.* from mission m, traveler t where (m.id=1 or t.id=2) or (m.id=1 or t.id=2)", q.toString());
    }

    @Test
    public void orCombinedTest1() {
        Query q = new Query();
        q.select("m.*", "t.*").from("mission m", "traveler t").where(
                new Where(new Or("m.id=1", new Or("m.id=1", "t.id=2")))
        );
        Assert.assertEquals("select m.*, t.* from mission m, traveler t where m.id=1 or (m.id=1 or t.id=2)", q.toString());
    }

    @Test
    public void orCombinedTest2() {
        Query q = new Query();
        q.select("m.*", "t.*").from("mission m", "traveler t").where(
                new Where(new Or(new Or("m.id=1", "t.id=2"), "m.id=1"))
        );
        Assert.assertEquals("select m.*, t.* from mission m, traveler t where (m.id=1 or t.id=2) or m.id=1", q.toString());
    }

    @Test
    public void testAny() {
        Query q = new Query();
        q.select("*").from("mission m").where(new Where(
                new Any("a=b", "c=d", "e=f")
        ));
        Assert.assertEquals("select * from mission m where a=b or c=d or e=f", q.toString());
    }

    @Test
    public void testAll() {
        Query q = new Query();
        q.select("*").from("mission m").where(new Where(
                new All("a=b", "c=d", "e=f")
        ));
        Assert.assertEquals("select * from mission m where a=b and c=d and e=f", q.toString());
    }

    @Test
    public void nestAnyAllTest() {
        Query q = new Query();
        q.select("*").from("mission m").where(new Where(new Or(new All("a", "b", "c"), new All("d", "e"))));
        Assert.assertEquals("select * from mission m where (a and b and c) or (d and e)", q.toString());
    }

    @Test
    public void nestAndOrTest() {
        Query q = new Query();
        q.select("*").from("mission m").where(new Where(new Any(new And("a", "b"), new Or("d", "e"))));
        Assert.assertEquals("select * from mission m where (a and b) or (d or e)", q.toString());
    }

    @Test
    public void inTest() {
        Query q = new Query();
        q.select("*").from("mission m").where(new Where(new StringBooleanExpression("m.id").in(1, 2, 3, 4)));
        Assert.assertEquals("select * from mission m where m.id in (1, 2, 3, 4)", q.toString());
    }

    @Test
    public void nestedQueryInTest() {
        Query subQuery = new Query();
        subQuery.select("m.id").from("mission m").join("m.traveler t").where("m.name like '%South%'");

        Query q = new Query();
        q.select("*").from("mission m").where(new Where(new StringBooleanExpression("m.id").in(subQuery)));
        Assert.assertEquals("select * from mission m where m.id in (select m.id from mission m join m.traveler t where m.name like '%South%')", q.toString());
    }

    @Test
    public void orderByTest() {
        Query q = new Query();
        q.select("*").from("mission m").where(new Where(new StringBooleanExpression("m.id").in(1, 2, 3, 4))).orderBy("m.name");
        Assert.assertEquals("select * from mission m where m.id in (1, 2, 3, 4) order by m.name", q.toString());
    }
}
