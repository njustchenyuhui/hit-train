package SQLInterpreter_cyh.Interpreter;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class OrInterpreter extends Interpreter {
    protected Interpreter left;
    protected Interpreter right;

    public OrInterpreter(Interpreter left, Interpreter right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String doInterpreter() {
        return "("+left.doInterpreter() + " or " + right.doInterpreter()+")";
    }
}
