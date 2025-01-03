import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter an Expression (Without Space) : ");
        String exp = sc.nextLine();

        Stack<Integer> opnds = new Stack<>();
        Stack<Character> optors = new Stack<>();

        for(int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if(ch == '(') {
                optors.push(ch);
            } else if(Character.isDigit(ch)) {
                opnds.push(ch - '0'); // convert char to int
            } else if(ch == ')') {
                while(optors.peek() != '(') {
                    char op = optors.pop();
                    int operand2 = opnds.pop();
                    int operand1 = opnds.pop();

                    int opv = operation(operand1, operand2, op);
                    opnds.push(opv);
                }
                optors.pop(); // discrad opening bracket '('

            } else if(ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                // Higher priority operators will be solved first
                while(!optors.isEmpty() && optors.peek() != '(' && precedence(ch) <= precedence(optors.peek())) {
                    char op = optors.pop();
                    int operand2 = opnds.pop();
                    int operand1 = opnds.pop();

                    int opv = operation(operand1, operand2, op);
                    opnds.push(opv);
                }
                optors.push(ch); // push ch itself
            }
        }

        while(!optors.isEmpty()) {
            char op = optors.pop();
            int operand2 = opnds.pop();
            int operand1 = opnds.pop();

            int opv = operation(operand1, operand2, op);
            opnds.push(opv);
        }

        System.out.println(opnds.peek());
    }

    public static int operation(int operand1, int operand2, int op) {
        switch (op) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                return 0;
        }
    }

    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}
