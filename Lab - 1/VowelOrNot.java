import java.util.Scanner;

class VowelOrNot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a Character : ");
		char ch = sc.next().charAt(0);

		Vowel v = new Vowel();
		v.checkVowel(ch);

	}
}
class Vowel {
	public static void checkVowel(char c) {
		if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
			System.out.println("Entered Character is a Vowel");
		}
		else{
			System.out.println("Entered Character is not a Vowel");
		}
	}
}