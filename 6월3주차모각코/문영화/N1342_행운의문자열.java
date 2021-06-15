import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1342_행운의문자열 {
	static char[] temp;
	static boolean[] check;
	static int[] alpha;
	static int N, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		alpha = new int[26];
		
		String str = br.readLine();
		N=str.length();
		for(int i=0;i<str.length();i++) {
			alpha[(int)str.charAt(i)-97]++;
		}
		temp = new char[N];
		check= new boolean[N];
		npm(0);
		System.out.println(ans);
	}
	public static void npm(int n) {
		if(n==N) {

			for(int i=1;i<N-1;i++) {
				if(temp[i-1]==temp[i]||temp[i]==temp[i+1]) {
					return;
				}
			}

			ans++;
//			System.out.println(Arrays.toString(temp));
			return;
		}
		
		for(int i=0;i<26;i++) {
			if(alpha[i]==0) continue;
			temp[n]=(char)(i+97);
			alpha[i]--;
			npm(n+1);
			alpha[i]++;
			
		}
	}

}
