import java.util.Stack;

public class RPN {
    public RPN(String[] args){
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < args.length ; i++){
            String input = args[i];

            if (isAnOperator(input)){
                double y = Double.parseDouble(stack.pop()) ;
                double x = Double.parseDouble(stack.pop());
                double z = evaluate(x, y, input);

                stack.push(" " + z) ;
            }else {
                stack.push(input) ;
            }
        }
    }

    public boolean isAnOperator(String s){
        return ( s.length() == 1 && "ASMD".indexOf(s) >= 0) ;
    }

    public double evaluate(double x , double y , String s){
        double r = 0.0 ;

        if (s.equals("A")){
            r = x + y ;
        } else if (s.equals("S")){
            r = x - y ;
        } else if (s.equals("M")) {
            r = x * y ;
        }else {
            r = x / y  ;
        }

        System.out.println(x + " " + s + " " + y + " = " + r );

        return r ;
    }

    public static void main(String[] args) {
        String[] expression = {"4", "5", "7", "A", "D"} ;

        new RPN(expression) ;
    }
}
