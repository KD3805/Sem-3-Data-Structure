import java.util.Scanner;

public class PrePosConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("\nEnter Infix Expression (Without Space) : ");
        String infixExp = sc.next();

        StringBuilder infix = new StringBuilder(infixExp);
        infix.reverse();

        System.out.print("\nEnter 'pre' for Prefix Conversion and 'post' for Postfix Conversion of Expression : ");
        String conversion = sc.next();

        PostfixConverter posc = new PostfixConverter();
        PrefixConverter prec = new PrefixConverter();

        if(conversion.equals("pre")){
            String prefixExp = prec.convertToPrefix(infix.toString());

            StringBuilder prefix = new StringBuilder(prefixExp);
            prefix.reverse();
            
            System.out.println("\nPrefix expression: " + prefix);
        }

        else if(conversion.equals("post")){
            String postfixExp = posc.convertToPostfix(infixExp);
            System.out.println("\nPostfix expression: " + postfixExp);
        }

        else{
            System.out.println("\nInvalid Input");
        }
    }
    
}

class PrefixConverter {

    public static String convertToPrefix(String infixExp) {
        StringBuilder prefix = new StringBuilder();
        CharStack stack = new CharStack(infixExp.length());
        String stackContent = "";
        int rank = 0;

        //print first stackContent
        stack.push(')');
        stackContent += stack.stackArray[0];
        System.out.print("Stack : "+stackContent);
        System.out.println("\tRevPolExp : "+prefix);
        // System.out.println("\tRank : "+rank);


        for (int i = 0; i < infixExp.length(); i++) {
            char c = infixExp.charAt(i);

            //Check whether given character is Letter or Digit
            if (Character.isLetterOrDigit(c)) {
                prefix.append(c);
                rank++;
            }

            else if (c == ')') {
                stack.push(c);
            }

            else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix.append(stack.pop());
                    rank--;
                }
                stack.pop(); // Discard the opening parenthesis
            }

            else if(c == '^' || c == '$'){
                stack.push(c);
            }

            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    prefix.append(stack.pop());
                    rank--;
                }
                stack.push(c);
            }

            //print table of content
            if(i!=0){
                stackContent = "";
                for(int j=0; j<i; j++){
                    stackContent += stack.stackArray[j];
                }

                System.out.print("Stack : "+stackContent);
                System.out.println("\tRevPolExp : "+prefix);
                // System.out.println("\tRank : "+rank);
            }

        }

        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
            rank--;
        }
        
        //print last stackContent & final postfix expresion
        stackContent = "";
        System.out.print("Stack : "+stackContent);
        System.out.println("\tRevPolExp : "+prefix);
        // System.out.println("\tRank : "+rank);

        return prefix.toString();
    }

    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
            case '$':
                return 3; 
            default:
                return 0;
        }
    }

}

class PostfixConverter {

    public static String convertToPostfix(String infixExp) {
        StringBuilder postfix = new StringBuilder();
        CharStack stack = new CharStack(infixExp.length());
        String stackContent = "";
        int rank = 0;

        //print first stackContent
        stack.push('(');
        stackContent += stack.stackArray[0];
        System.out.print("Stack : "+stackContent);
        System.out.println("\tRevPolExp : "+postfix);
        // System.out.println("\tRank : "+rank);


        for (int i = 0; i < infixExp.length(); i++) {
            char c = infixExp.charAt(i);

            //Check whether given character is Letter or Digit
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
                rank++;
            }

            else if (c == '(') {
                stack.push(c);
            }

            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                    rank--;
                }
                stack.pop(); // Discard the opening parenthesis
            }

            else if(c == '^' || c == '$'){
                stack.push(c);
            }

            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                    rank--;
                }
                stack.push(c);
            }   

            //print table of content
            if(i!=0){
                stackContent = "";
                for(int j=0; j<i; j++){
                    stackContent += stack.stackArray[j];
                }

                System.out.print("Stack : "+stackContent);
                System.out.println("\tRevPolExp : "+postfix);
                // System.out.println("\tRank : "+rank);
            }

        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
            rank--;
        }

        //print last stackContent & final postfix expresion
        stackContent = "";
        System.out.print("Stack : "+stackContent);
        System.out.println("\tRevPolExp : "+postfix);
        // System.out.println("\tRank : "+rank);

        return postfix.toString();
    }


    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
            case '$':
                return 3;
            default:
                return 0;
        }
    }

}

class CharStack {
    char[] stackArray;
    int top;
    int maxSize;

    public CharStack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char element) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full. Cannot push element: " + element);
            return;
        }
        stackArray[++top] = element;
        // System.out.println(stackArray[top]);
    }

    public char pop() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot pop element.");
            return '\0';
        }
        char popedEle = stackArray[top];
        stackArray[top] = '\0';
        top--;
        return  popedEle;
    }

    public char peek() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot peek element.");
            return '\0';
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == 0 || top == -1);
    }

    public void clear() {
        top = -1;
    }

}