package Purchase_cyh.character;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public enum Size {
    _11_INCH,_14_INCH,_15_INCH,_16_INCH;
    @Override
    public String toString()
    {
        switch (this)
        {
            case _11_INCH:
                return "11英寸";
            case _14_INCH:
                return "14英寸";
            case _15_INCH:
                return "15英寸";
            case _16_INCH:
                return "16英寸";
            default:
                return "otherSize";
        }
    }
}
