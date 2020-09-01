package SQLInterpreter_cyh.Interpreter;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class NotInterpreter extends Interpreter {
    protected Interpreter interpreter;

    public NotInterpreter(Interpreter interpreter) {
        this.interpreter = interpreter;
    }

    @Override
    public String doInterpreter() {
        return "not "+ interpreter.doInterpreter();
    }
}
