import java.util.*;
import java.util.regex.Pattern;

public class Calc2 {


    private static Deque<Integer> values = new ArrayDeque<>();
    private static Deque<String> operators = new ArrayDeque<>();

    private static Pattern pattern = Pattern.compile("-?\\d+");

    private static Map<String, Operator> operatorsMap = new HashMap<String, Operator>();

    static
    {
        operatorsMap.put("+", Operator.ADD);
        operatorsMap.put("-", Operator.SUBTRACT);
        operatorsMap.put("*", Operator.MULTIPLY);
        operatorsMap.put("/", Operator.DIVIDE);
    }


    private static int getPrecedence(String token){
        if(operatorsMap.containsKey(token)) {
            return operatorsMap.get(token).precedence;
        }
        else {
            return 0;
        }
    }


    private static boolean isGreaterPrecedence(String operator, String token){
        if (!operatorsMap.containsKey(token) || !operatorsMap.containsKey(operator)){
            return false;
        }
        else{
            return operatorsMap.get(operator).precedence >= operatorsMap.get(token).precedence;
        }
    }


    private static Integer doMath(Integer a, Integer b, String operator){
        //System.out.println(b+operator+a);
        switch(operator){
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                return b / a;
            default:
                return 0;
        }
    }


    public static int calculate(String str) {

        StringTokenizer tokenizer = new StringTokenizer(str," ");
        while (tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken();

            //number
            if(pattern.matcher(token).matches()){
                values.push(Integer.parseInt(token));
            }
            else if(token.equals("(")){
                operators.push(token);
            }
            else if(token.equals(")")){
                while(!operators.peek().equals("(")){
                    Integer result = doMath(values.poll(), values.poll(), operators.poll());
                    values.push(result);
                }
                operators.pop();
            }
            //operator
            else if(operatorsMap.containsKey(token)){
                    //while(!operators.isEmpty() && (getPrecedence(operators.peek()) >= getPrecedence(token))){
                    while(!operators.isEmpty() && (isGreaterPrecedence(operators.peek(), token))){
                        Integer result = doMath(values.poll(), values.poll(), operators.poll());
                        values.push(result);
                    }
                    operators.push(token);
            }
        }

        while(!operators.isEmpty()){
            Integer result = doMath(values.poll(), values.poll(), operators.poll());
            values.push(result);
        }


        return values.peek();
    }

}
