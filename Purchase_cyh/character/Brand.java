package Purchase_cyh.character;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public enum Brand {
    LENOVO,THINKPAD,HUAWEI,DELL,HP,MI,APPLE;
    @Override
    public String toString()
    {
        switch (this)
        {
            case LENOVO:
                return "Lenovo";
            case THINKPAD:
                return "ThinkPad";
            case HUAWEI:
                return "Huawei";
            case DELL:
                return "Dell";
            case HP:
                return "HP";
            case MI:
                return "MI";
            case APPLE:
                return "Apple";
            default: return "otherBrand";
        }
    }
}
