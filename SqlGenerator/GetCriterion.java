package SqlGenerator;

import SqlGenerator.SqlLinker.SqlLinker;
import SqlGenerator.SqlOperator.SqlOperator;

import java.util.Scanner;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class GetCriterion {
    public static void main(String[] args) {
        CriterionGenerator criterionGenerator = new CriterionGenerator();
        SqlLinker sqlLinker=null;
        SqlOperator operator=null;
        String fields = "";
        String param = "";

        System.out.println("请选择查询条件： 1.and   2.or  3.empty");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        switch (input) {
             case "1":
                 sqlLinker = SqlLinker.AND;
                 break;
             case "2":
                 sqlLinker = SqlLinker.OR;
                 break;
             case "3":
                 sqlLinker = SqlLinker.EMPTY;
                 break;
             default:
                 break;
        }


        System.out.print("请输入查询属性：");
        fields = sc.nextLine();

        System.out.println("请选择查询条件：1.=   2.!=   3.contains");
        input = sc.nextLine();
        switch (input) {
             case "1":
                operator = SqlOperator.EQUAL;
                break;
             case "2":
                 operator = SqlOperator.NOT_EQUAL;
                 break;
             case "3":
                 operator = SqlOperator.CONTAINS;
                 break;
             default:
                 break;
        }

        System.out.print("请选择需要查询的属性值：");
        param = sc.nextLine();
        criterionGenerator.createCriterion(sqlLinker, operator,  fields, param);
        System.out.println("最终生成的sql为：");
        System.out.println(criterionGenerator.generateSql());
    }
}
