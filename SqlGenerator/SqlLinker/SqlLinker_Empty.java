package SqlGenerator.SqlLinker;

import SqlGenerator.CriterionDecorator;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class SqlLinker_Empty extends CriterionDecorator {
    @Override
    public String getSQL() {
        return "";
    }
}
