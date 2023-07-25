/*How stack can be used to recognize strings aca, bcb, abcba, abbcbba?
 Implement a program described in 5(A)*/

import java.util.Scanner;

class RecognizeStrings{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter String : ");
        String str = sc.nextLine();

        Recognize rc = new Recognize();
        rc.recognize(str);
        
    }
}
class Recognize{
    public void recognize(String str){

        if(str.indexOf('c')<0 || str.indexOf('c') != Math.floor(str.length()/2)) {
			// test case ababa or abcbacab
			System.out.println("Invalid string");
            return;
		}

        CharStack st = new CharStack(str.length());
        st.push('c');

        char[] ch = str.toCharArray();
        int i = str.length() - 1;

        // ((Character)ch).toString();
        while(ch[i] != 'c') {
            if(ch[i] == ' '){
                System.out.println("Invalid String");
            }
            else{
                st.push(ch[i]);
            }
            i--;
            
        }

        while(st.stackArray[st.top] != 'c'){
            char x = st.pop();
            i--;
            if(i<0){
                System.out.println("Invalid String");
                return;
            }
            if(ch[i] != x){
                System.out.println("Invalid String");
                return;
            }

        }

        if(st.isEmpty()){
            System.out.println("Valid String");
        }
        else{
            System.out.println("Invalid String");
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

        return stackArray[top--];
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
