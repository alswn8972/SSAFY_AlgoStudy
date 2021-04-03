import java.util.*;
import java.io.*;

public class Main_권현지 {
	static int[] fibo1;
	static int[] fibo2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken());
		
		
		fibo1 = new int[N+1];
		fibo2 = new int[N+1];
		
		fibo(N);
		
//		K = A*fibo1[N] + B*fibo2[N];
//		
		int A = 1;
		double B =0;
//		System.out.println(fibo1[N]+fibo2[N]);
		
		while(true) {
			B = ((double)K-A*fibo1[N])/fibo2[N];
			if(B - (int)B == 0) {
				break;
			}
			A++;
		}
		
		System.out.println(A+"\n"+(int)B);
		
	}
	
	public static void fibo(int n) {
		
		fibo1[0] = 0;
		fibo1[1] = 1;
		fibo1[2] = 0;
		
		for(int i = 3; i<n+1; i++) {
			fibo1[i] = fibo1[i-1] + fibo1[i-2];
		}
		
		fibo2[0] = 0;
		fibo2[1] = 0;
		fibo2[2] = 1;
		
		for(int i = 3; i<n+1; i++) {
			fibo2[i] = fibo2[i-1] + fibo2[i-2];
//			System.out.println(fibo2[i]);
		}
	}
 }
