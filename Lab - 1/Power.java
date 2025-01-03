import java.util.Scanner;

class Power {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Base : ");
		int x = sc.nextInt();

		System.out.print("Enter Power : ");
		int y = sc.nextInt();

		// FindPower fp = new FindPower();
		// int ans = fp.calcPower(x,y);
		// System.out.println("Answer = "+ ans);

		GFG gfg = new GFG();
		int ans = gfg.pow(x, y);
		System.out.println("Answer = "+ ans);
	}
}

// Write you own Power without using multiplication(*) and division(/) operators  
class GFG {
     
    /* Works only if a >= 0 and b >= 0 */
    public static int pow(int a, int b)
    {
        if (b == 0)
            return 1;
             
        int answer = a;
        int increment = a;
        int i, j;
         
        for (i = 1; i < b; i++) {
            for (j = 1; j < a; j++) {
                answer += increment;
            }
            increment = answer;
        }
         
        return answer;
    }
}

class FindPower{
	public static int calcPower(int x, int y) {
		int ans=1;

		for(int i=0; i<y; i++) {
			ans *= x;
		}
		// System.out.println("Answer = "+ans);
		return ans;
	}
}

