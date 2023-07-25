// package DS;
import java.util.Scanner;

public class Lab529 {
	public static void main(String[] args) {
		/*
		 * 28. How stack can be used to recognize strings aca, bcb, abcba, abbcbba?
           29. Implement a program described in 5(A)
		 */
		Scanner sc = new Scanner(System.in);
		
		String reco;
		reco = sc.nextLine();
		Recognize rc = new Recognize(reco);
		char ch;
		int i =0;
		ch = reco.charAt(i);
		
		while(ch != 'c') {
			if(ch == ' ') {
				System.out.println("Invalid String");
				break;
			}
			else {
				rc.push(ch);
			}
			i++;
			ch = reco.charAt(i);			
		}		
		 
		rc.compare();

	}
	
}


class Recognize{
	String reco;
	int n;
	int top=0 ;
	char a [];
	int strIndex =0;
	
	
	public Recognize(String reco) {
		this.reco = reco;
		n = reco.length();
		if(reco.indexOf('c')<0) {
			// test case ababa
			System.out.println("Invalid string");
		}else {
			a = new char[reco.indexOf('c')];
		}
		try {
			System.out.println(a[top]);
		}catch (Exception e) {
			System.out.println("Invalid String");
		}
		 
		
	}
	public char pop() {
		
				
			
					
			try {
				if(top<0) {
					System.out.println("\nStack Underflow");
					
				}
				else {
					top--;					
					a[top+1]= '0';	
					
				}
			}catch (Exception e) {
				System.err.println(e);
			}
		
			return a[top];
	}

	public void push(char x ) {
		
		
		
			if(top>=n) {
				System.out.println("Stack Overflow");
				top--;
			
			}
			else {
				a[top]= x;
				top++;
				strIndex++;
				System.out.println("pushed "+ x);
			}			
				
	}
	
	
	 public void compare() {
		boolean isCorrect = true;
		
		
		int j=a.length;
			
		while(strIndex <reco.length()) {
			strIndex++;
			j--;
			if(j < 0) {
				  if(reco.charAt(strIndex) == ' ') {
					  isCorrect = true;
				  }
				  else {
					  isCorrect = false;
				  }
				
				break;
			}
			if(a[j] != reco.charAt(strIndex)) {
				isCorrect = false;
				
				break;
			}
				
			
		}
		if((reco.indexOf('c')+1) >= reco.length()) {
			// test case abbc 
			isCorrect =false;
		}
		
		if((reco.indexOf(' ')+1) != reco.length()) {
			// test case abcba a.
			isCorrect = false;		
		}
		
		 
		
		if(isCorrect) {
			System.out.println("Valid");
		}
		else {
			System.out.println("Invalid String");
		}
		
		
	}	
	
}
