import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14931 {

	static int[] river;
	static long ans;
	static int L, ans_p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		river = new int[L+1];
		for(int i = 1; i<=L; i++) {
			river[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=L; i++) {
			throwStone(i);
		}
		
		
		System.out.println(ans_p+" "+ans);
	}
	
	private static void throwStone(int power) {
		// TODO Auto-generated method stub
		long sum = 0;
		for(int i = power; i<=L; i += power) {
			sum += river[i];
		}
		if(ans < sum) {
			ans = sum;
			ans_p = power;
		}
		
	}

}
