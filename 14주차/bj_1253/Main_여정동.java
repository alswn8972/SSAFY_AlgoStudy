import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_여정동 {
	static int N;
	static long sum = 0;
	static long[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		int zc = 0;
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			if(arr[i] == 0) zc++;

		}
		Arrays.sort(arr);
		for(int i = 0; i < N; i++) {
			int sp = 0;
			int ep = N-1;
			while(true) {
				if(sp == i) sp++;
				if(ep == i) ep--;
				if(sp >= ep) break;
				long sum = arr[sp] + arr[ep];
				if(sum == arr[i]) {
					count++;
					break;
				}
				else if(sum > arr[i]) ep--;
				else if(sum < arr[i]) sp++;
			}
		}
		
		System.out.println(count);
	}
}
