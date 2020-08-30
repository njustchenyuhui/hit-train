package SqlGenerator;

import SqlGenerator.SqlLinker.SqlLinker;
import SqlGenerator.SqlLinker.SqlLinker_And;
import SqlGenerator.SqlLinker.SqlLinker_Empty;
import SqlGenerator.SqlLinker.SqlLinker_Or;
import SqlGenerator.SqlOperator.SqlOperator;
import SqlGenerator.SqlOperator.SqlOperator_Contains;
import SqlGenerator.SqlOperator.SqlOperator_Eq;
import SqlGenerator.SqlOperator.SqlOperator_Neq;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class CriterionGenerator {

    private String baseSql = "select * from table where " ;
    private List<CriterionDecorator> list = new ArrayList<CriterionDecorator>();

    public String generateSql() {
        StringBuilder sb = new StringBuilder();
        sb.append(baseSql);
        for (Iterator<CriterionDecorator> it = list.iterator(); it.hasNext(); ) {
            sb.append(it.next().getSQL());
        }
        return sb.toString();
    }

    public void createCriterion(SqlLinker linker,SqlOperator operator, String fields, String param) {
        addLinker(linker);
        addOperator(operator, fields, param);
    }

    public void addLinker(SqlLinker sqlLink) {
        switch (sqlLink) {
            case AND:
                list.add(new SqlLinker_And());
                break;
            case OR:
                list.add(new SqlLinker_Or());
                break;
            case EMPTY:
                list.add(new SqlLinker_Empty());
                break;
            default:
                break;
        }
    }

    public void addOperator(SqlOperator operator,String fields, String param) {
        switch (operator) {
            case EQUAL:
                list.add(new SqlOperator_Eq(fields, param));
                break;
            case NOT_EQUAL:
                list.add(new SqlOperator_Neq(fields, param));
                break;
            case CONTAINS:
                list.add(new SqlOperator_Contains(fields, param));
                break;
            default:
                break;
        }
    }



}
