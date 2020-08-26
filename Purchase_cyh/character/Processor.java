package Purchase_cyh.character;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public enum Processor {
    INTER_I9,INTER_CORE,AMD,INTER_I7;
    @Override
    public String toString()
    {
        switch (this)
        {
            case INTER_I9:
                return "Inter_i9";
            case INTER_CORE:
                return "Inter_core";
            case AMD:
                return "AMD";
            case INTER_I7:
                return "Inter_i7";
            default:
                return "otherProcessor";
        }
    }
}
