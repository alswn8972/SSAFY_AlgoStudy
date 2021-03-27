import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_여정동 {
	static String P, S;
	
	static int kmp() {
		int[] pi = getPi();
		
		int j = 0;
		
		char[] s = S.toCharArray();
		char[] p = P.toCharArray();
		
		for(int i = 0; i < S.length(); i++) {
			while(j > 0 && s[i] != p[j]) {
				j = pi[j-1];
			}
			if(s[i] == p[j]) {
				if(j == p.length-1) {
					return 1;
				}
				else 
					j++;
			}
		}
		return 0;
	} 
	
	static int[] getPi() {
		int[] pi = new int[P.length()];
		char[] p = P.toCharArray();
		
		int j = 0;
		
		for(int i = 1; i < P.length(); i++) {
			while(j > 0 && p[i] != p[j]) {
				j = pi[j-1];
			}
			if(p[i] == p[j]) pi[i] = ++j;
		}
		
		return pi;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		P = br.readLine();
		
		int result = kmp();
		System.out.println(result);
	}
}