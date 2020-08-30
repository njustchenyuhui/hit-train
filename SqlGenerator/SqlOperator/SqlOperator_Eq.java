package SqlGenerator.SqlOperator;

import SqlGenerator.Criterion;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class SqlOperator_Eq extends Criterion {

    public SqlOperator_Eq(String fields, String param) {
        super(fields, param);
    }

    @Override
    public String getSQL() {
        return fields + " = '" + param + "'";

    }
}
