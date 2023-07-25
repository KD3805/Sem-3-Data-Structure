import java.util.Scanner;

public class ExpEvalution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Which Expression do You want to Evaluate?\nEnter 'pre' for Prefix Evaluation and 'post' for Postfix Evaluation : ");
        String eval = sc.next();

        if(eval.equals("pre")){
            System.out.print("\nEnter Prefix Expression (Without Space) : ");
            String prefixExp = sc.next();

            PosPreEvalution pe = new PosPreEvalution();
            int result = pe.evaluatePrefix(prefixExp);
            System.out.println("Result: " + result);
        }
        
        else if(eval.equals("post")){
            System.out.print("\nEnter Postfix Expression (Without Space) : ");
            String postfixExp = sc.next();

            PosPreEvalution pe = new PosPreEvalution();
            int result = pe.evaluatePostfix(postfixExp);
            System.out.println("Result: " + result);
        }

        else{
            System.out.println("\nInvalid Input");
        }
    }
}

class PosPreEvalution {

    public static void separateDigit(char ch){
        String exp = "";

        StackOperations stack = new StackOperations(exp.length());
        if(ch != ','){
            exp += ch;
        }
        else{
            if(exp != ""){
                int x = Integer.parseInt(exp);
                stack.push(x);
            }
        }
    }

    public static int evaluatePrefix(String exp) {
        StackOperations stack = new StackOperations(exp.length());

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                //convert the character ch to its corresponding integer value
                stack.push(ch - '0');
            } 
            
            else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    case '%':
                        stack.push(operand1 % operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static int evaluatePostfix(String exp) {
        StackOperations stack = new StackOperations(exp.length());
        char ch;

        for (int i = 0; i < exp.length(); i++) {
            ch = exp.charAt(i);

            if (Character.isDigit(ch) || ch == ',') {
                //convert the character ch to its corresponding integer value
                separateDigit(ch);
            } 
            else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    case '%':
                        stack.push(operand1 % operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }

}

class StackOperations {
    int maxSize;
    int top;
    int[] stackArray;

    public StackOperations(int size) {
        maxSize = size;
        top = -1;
        stackArray = new int[maxSize];
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow (Cannot push element)");
        } else {
            top++;
            stackArray[top] = value;
            // System.out.println(value + " pushed to the stack.");
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow (Cannot pop element).");
            return -1;
        } else {
            int poppedElement = stackArray[top--];
            // System.out.println(poppedElement + " popped from the stack.");
            stackArray[top+1] = 0;

            return poppedElement;
        }
    }

    public int peep() {
        if (top == -1) {
            System.out.println("Stack Underflow (Cannot pop element)");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void display(){
        System.out.println("Stack Elements are : ");
        for(int i=top; i>=0; i--){
            System.out.println(stackArray[i]);
        }
    }

    public void change(int element, int index){
        if (top >= maxSize - 1) {
            System.out.println("Stack Overflow (Cannot push element)");
        }
        if (top == -1) {
            System.out.println("Stack Underflow (Cannot pop element)");
        }
        if(index < 0){
            System.out.println("Index cannot be Negative");
        }
        if(index > top){
            System.out.println("Stack Underflow");
        }

        stackArray[top - index] = element; 
    }

}
