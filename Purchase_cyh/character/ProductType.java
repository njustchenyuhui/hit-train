package Purchase_cyh.character;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public enum ProductType {
    LAPTOP,DESKTOP,SERVER;
    @Override
    public String toString()
    {
        switch (this)
        {
            case LAPTOP: return "Laptop";
            case DESKTOP: return "Desktop";
            case SERVER: return "Server";
            default:return "Unspecified";
        }
    }
}
