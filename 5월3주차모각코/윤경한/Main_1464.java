import java.util.*;
import java.io.*;
public class Main_1464 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder str = new StringBuilder(br.readLine());
		
		
		
		String s = str.substring(0, 1);
		for (int i = 1; i <str.length(); i++) {
			if(s.charAt(i-1) < str.charAt(i)) {
				s = str.charAt(i) + s;
			}
			else {
				s = s+ str.charAt(i);
			}
		}
		StringBuilder res = new StringBuilder(s);
		res = res.reverse();
		System.out.println(res);
	}
}
