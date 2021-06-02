import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9251 {
	static char[] s1, s2;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		s1 = new char[str1.length()];
		s2 = new char[str2.length()];
		
		for(int i = 0; i<str1.length(); i++) {
			s1[i] = str1.charAt(i);
		}
		for(int i = 0; i<str2.length(); i++) {
			s2[i] = str2.charAt(i);
		}
		
		dp = new int[str1.length()][str2.length()];
		for(int i = 0; i<str1.length(); i++) {
			Arrays.fill(dp[i], -1);
		}
		int ans = LCS(str1.length()-1, str2.length()-1);
		
		System.out.println(ans);
	}
	private static int LCS(int x, int y) {
		// TODO Auto-generated method stub
		if(x == -1 || y == -1) {
			return 0;
		}
 
		if(dp[x][y] == -1) {
			dp[x][y] = 0;
			if(s1[x] == s2[y]) {
				dp[x][y] = LCS(x - 1, y - 1) + 1;
			}
 
			else {
				dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
			}
		}
		
		return dp[x][y];
	}
}
