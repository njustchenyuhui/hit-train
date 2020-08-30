package SqlGenerator;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public abstract class Criterion extends CriterionDecorator{
    public String fields;
    public String param;

    public Criterion(String fields, String param) {
        this.fields = fields;
        this.param = param;
    }
}
