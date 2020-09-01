package SQLInterpreter_cyh;

import SQLInterpreter_cyh.CriterionGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class CriterionGeneratorTest {
    @Test
    public void and_Test() {
        String str=CriterionGenerator.getCriterion("(id='1') AND (region='cn')");
        assertEquals("select * from table where ((id='1') and (region='cn'))", str);
    }

    @Test
    public void or_Test() {
        String str=CriterionGenerator.getCriterion("(id='1') OR (region='CN')");
        assertEquals("select * from table where ((id='1') or (region='CN'))", str);
    }

    @Test
    public void not_Test() {
        String str=CriterionGenerator.getCriterion("!(id='1')");
        assertEquals("select * from table where not (id='1')", str);
    }

    @Test
    public void testCriterion() {
        String str=CriterionGenerator.getCriterion("(id='1') AND ((region='CN') OR (companyName='HTSC')) AND !(postalCode=3)");
        assertEquals("select * from table where (((id='1') and ((region='CN') or (companyName='HTSC'))) and not (postalCode=3))", str);
    }
}
