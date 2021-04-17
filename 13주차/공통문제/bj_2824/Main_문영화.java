import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_문영화 {

	static String res ="";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		BigInteger A = BigInteger.valueOf(1);
		BigInteger B = BigInteger.valueOf(1);
		
		for(int i=0;i<N;i++) {
			A=A.multiply(new BigInteger(st.nextToken()));
		}
		for(int i=0;i<M;i++) {
			B=B.multiply(new BigInteger(st2.nextToken()));
		}
	
		String d =gcd(A,B);
		StringBuilder sb= new StringBuilder();
		int x = d.length();
		if(x>9) {
			for(int i=1;i<=9;i++) {
				sb.append(d.charAt(x-i));
			}
			System.out.println(sb.reverse().toString());
		}else {
			System.out.println(d);
		}
	}

	private static String gcd(BigInteger a, BigInteger b) {
		
		if(b.equals(BigInteger.valueOf(0))) {
			res = a.toString();
			return res;
		}
		return gcd(b,a.remainder(b));
	}
	

}
