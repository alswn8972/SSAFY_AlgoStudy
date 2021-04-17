import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static int n;
	static boolean[] prime;
	static Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
	
	static boolean check(int p) {
		map.clear();
		map.put(p, true);
		
		while(true) {
			int sum = 0;
			String s = Integer.toString(p);
			
			for(int i = 0; i < s.length(); i++) {
				char m = s.charAt(i);
				int t = m - '0';
				t = (int) Math.pow(t, 2);
				sum += t;
			}
			if(sum == 1) return true;
			if(map.containsKey(sum)) break;
			p = sum;
			map.put(p, true);
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		prime = new boolean[n+1];
		
		for(int i = 2; i < prime.length; i++) {
			for(int j = i*2; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
		
		for(int i = 2; i <= n ; i++) {
			if(!prime[i]) {
				if(check(i))
					bw.write(i+"\n");
			}
		}
		bw.flush();
	}
}
