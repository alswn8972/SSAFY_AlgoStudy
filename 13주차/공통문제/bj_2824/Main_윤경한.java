import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main_boj_2824 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		BigInteger A = new BigInteger("1");
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A = A.multiply(new BigInteger(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		BigInteger B = new BigInteger("1");
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B = B.multiply(new BigInteger(st.nextToken()));
		}
		
		String res = A.gcd(B).toString();
		if(res.length() > 9) {
			res = res.substring(res.length()-9 , res.length());
		}
		System.out.println(res);
		
	}
}
