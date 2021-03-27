import java.util.Scanner;

public class Main_문영화 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int K = sc.nextInt();
		int[][] dp = new int[D+1][2];
		//x+y 각각의 계수를 넣어줌
		dp[1]= new int[]{1,0};
		dp[2]= new int[]{0,1};
		
		for(int i=3;i<=D;i++) {
			dp[i][0]= dp[i-1][0]+dp[i-2][0];
			dp[i][1]= dp[i-1][1]+dp[i-2][1];
		}
		
//		System.out.println(dp[D][0]+" "+dp[D][1]);
		int x=0;
		int y=0;
		while(true) {
			if((x*dp[D][0])+(y*dp[D][1])==K) break;
			x++;
			y=1;
			while(true) {
				if((x*dp[D][0])+(y*dp[D][1])>=K) break;
				y++;
			}
		}
		
		System.out.println(x);
		System.out.println(y);
	}

}
