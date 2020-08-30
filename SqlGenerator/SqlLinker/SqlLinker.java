package SqlGenerator.SqlLinker;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public enum SqlLinker {
    AND,OR,EMPTY;
    @Override
    public String toString()
    {
        switch (this)
        {
            case AND: return "and";
            case OR: return "or";
            case EMPTY: return "";
            default:return "OtherLink";
        }
    }
}
