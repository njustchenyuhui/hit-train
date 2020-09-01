package SQLInterpreter_cyh.Interpreter;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class ConditionInterpreter extends Interpreter{
    private String condition;

    public ConditionInterpreter(String condition) {
        this.condition = condition;
    }

    @Override
    public String doInterpreter() {
        return condition;
    }
}
