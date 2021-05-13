import java.io.*;
import java.util.*;
public class Main_14931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;

		int L = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[L+1];
		for(int i = 1; i<=L; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long res = Integer.MIN_VALUE;

		int idx = -1;

		for(int d = 1; d<=L; d++){
			long sum = 0;
			for(int i = d; i<=L; i += d){
				sum += arr[i];
			}
			if(res<sum){
				res = sum;
				idx = d;
			}
		}

		if(res <= 0){
			System.out.println("0 0");
			return;
		}
		System.out.println(idx+" "+res);
	}
}

