import java.util.Scanner;

class Stack {
    public static void main(String[] args) {
        
        StackOperations st = new StackOperations(4);

        System.out.println("PUSH Elements : ");
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4); // Stack Overflow

        st.display();

        System.out.println("Top Element : " + st.peek());
        System.out.println("Peep Element : " + st.peep(3));

        System.out.println("POP Elements : ");
        st.pop();
        st.pop();

        st.display();

        System.out.println("PUSH Elements : ");
        st.push(5);

        st.display();
        
        System.out.println("PUSH Elements : ");
        st.push(6);
        st.push(7);

        st.display();

        st.change(8, 3);
        System.out.println("After Changing an Element,");

        st.display();
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
            System.out.println(value + " pushed to the stack.");
        }
    }


    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow (Cannot pop element).");
            return -1;
        } else {
            int poppedElement = stackArray[top--];
            System.out.println(poppedElement + " popped from the stack.");
            stackArray[top+1] = 0;

            return poppedElement;
        }
    }


    public int peek() {
        if (top == -1) {
            System.out.println("Stack Underflow (Cannot pop element)");
            return -1;
        } else {
            return stackArray[top];
        }
    }


    public int peep(int index) {

        if (top == -1) {
            System.out.println("Stack Underflow (Cannot peep element)");
            return -1;
        }
        if(index < 0){
            System.out.println("Index cannot be Negative");
            return -1;
        }
        if(index > top){
            System.out.println("Stack Underflow");
            return -1;
        }

        return (stackArray[top - index]); 
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
        
        if (top == -1) {
            System.out.println("Stack Underflow (Cannot change element)");
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
