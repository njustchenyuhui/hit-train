package SQLInterpreter_cyh;

import SQLInterpreter_cyh.Interpreter.*;

import java.util.Stack;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class CriterionGenerator {
    public static String getCriterion(String input) {
        Stack<String> stack1 = new Stack();
        Stack<String> stack2 = new Stack();
        Stack<Character> stack3 = new Stack();
        String str = "";

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i=0;i<input.length();i++) {
            char ch = input.charAt(i);
            if((i>1&&input.charAt(i-1)==32&&input.charAt(i-2)==')') || ch=='!') {
                flag=true;
                sb.append(ch);
            }else{
                if((i>0&&input.charAt(i-1)=='!') || (ch==32 && sb.length()>0)) {
                    flag=false;
                    String curOpt = sb.toString();
                    if(stack1.isEmpty()){
                        stack1.push(curOpt);
                    } else {
                        compute(stack1,stack2,curOpt);
                    }
                    if (ch!=32) stack3.push(ch);
                    sb.delete(0,sb.length());
                }else if(ch!=')') {
                    if(!flag && ch!=32) stack3.push(ch);
                }else {
                    str = ")";
                    while(true) {
                        char tmp = stack3.pop();
                        str += tmp;
                        if(tmp=='(') {
                            if(!str.replaceAll(" ","").equals("()")){
                                stack2.push(str);
                            }
                            str="";
                            break;
                        }
                    }
                }
                if(flag) sb.append(ch);
            }
            if(ch=='('&&input.charAt(i+1)=='('){
                stack1.push(String.valueOf(ch));
            }else if(ch==')'&&input.charAt(i-1)==')'){
                calcutor(stack1,stack2,true);
            }
        }
        if(!stack1.isEmpty()) calcutor(stack1,stack2,false);
        str = "select * from table where "+stack2.pop();
        return str;
    }

    private static void calcutor(Stack<String> optStack, Stack<String> exprStack, boolean isBracket) {
        String opt = optStack.pop();
        cal(opt,optStack,exprStack);
        if(isBracket){
            if("(".equals(optStack.peek())) {
                optStack.pop();
            }else {
                calcutor(optStack,exprStack,isBracket);
            }
        }else {
            if(!optStack.empty()) {
                calcutor(optStack, exprStack,isBracket);
            }
        }
    }

    private static void compute(Stack<String> optStack, Stack<String> exprStack,String curOpt) {
        String peekOpt = optStack.peek();
        if(getLabel((peekOpt))>=getLabel(curOpt)) {
            String opt = optStack.pop();
            cal(opt,optStack,exprStack);
            if(optStack.empty()) {
                optStack.push(curOpt);
            }else {
                compute(optStack, exprStack, curOpt);
            }
        }else {
            optStack.push(curOpt);
        }
    }

    private static int getLabel(String opt){
        if(opt.equals("!")){
            return 3;
        }
        if(opt.equals("AND")||opt.equals("OR")) {
            return 2;
        }
        return 0;
    }

    private static void cal(String opt, Stack<String> optStack, Stack<String> exprStack) {
        if(opt.equals("!")) {
            String tmp = exprStack.pop();
            Interpreter interpreter = new ConditionInterpreter(tmp);
            NotInterpreter notInterpreter = new NotInterpreter(interpreter);
            exprStack.push(notInterpreter.doInterpreter());
        }else {
            String tmp1 = exprStack.pop();
            String tmp2 = exprStack.pop();
            if(opt.equals("AND")) {
                Interpreter interpreter1 = new ConditionInterpreter(tmp2);
                Interpreter interpreter2 = new ConditionInterpreter(tmp1);
                AndInterpreter andInterpreter = new AndInterpreter(interpreter1, interpreter2);
                exprStack.push(andInterpreter.doInterpreter());
            }
            if(opt.equals("OR")) {
                Interpreter interpreter1 = new ConditionInterpreter(tmp2);
                Interpreter interpreter2 = new ConditionInterpreter(tmp1);
                OrInterpreter orInterpreter = new OrInterpreter(interpreter1, interpreter2);
                exprStack.push(orInterpreter.doInterpreter());
            }
        }
    }



}
