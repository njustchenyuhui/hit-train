package SqlGenerator.SqlOperator;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public enum SqlOperator {
    EQUAL,NOT_EQUAL,CONTAINS;
    @Override
    public String toString()
    {
        switch (this)
        {
            case EQUAL: return "=";
            case NOT_EQUAL: return "!=";
            case CONTAINS: return "contains";
            default:return "OtherOperator";
        }
    }
}
