import java.util.Stack;

class EvaluateSimpleExpression {

    public static void main(String[] args) {
        String exp = "1+2+3-6+9";
        int result = evaluateSimpleExpression(exp);
        System.out.println(result);
    }

    public static boolean isNumeric(char c) {
        if (c >= 48 & c <= 57) {
            return true;
        } else
            return false;
    }

    private static int evaluateSimpleExpression(String exp) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Character> stackOp = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            if (isNumeric(exp.charAt(i))) {
                stack.push(Integer.valueOf(exp.charAt(i)));
                if (stack.size() == 2) {
                    int b = stack.pop() - 48;
                    char operator = stackOp.pop();
                    int a = stack.pop() - 48;
                    switch (operator) {
                        case '+':
                            result = a + b;
                            break;
                        case '-':
                            result = a - b;
                            break;
                        case '*':
                            result = a * b;
                            break;
                        case '/':
                            result = a / b;
                            break;
                        default:
                            break;
                    }
                    stack.push(result + 48);
                }
            } else {
                stackOp.push(exp.charAt(i));
            }
        }
        return result;
    }
}
