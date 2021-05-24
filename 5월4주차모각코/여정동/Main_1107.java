import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107 {
	static int N, M;
	static boolean[] work = new boolean[10];
	static int count = 0;

	static int getNearstNum() {
		int num0 = N;
		while(Math.abs(num0-N) < Math.abs(N-100)) {
			boolean found = true;
			String snum = Integer.toString(num0);
			for(int i = snum.length()-1; i > -1 ; i--) {
				int n = snum.charAt(i) - '0';
				if(work[n]) {
					found = false;
					break;
				}
			}
			if(found) {
				break;
			}
			else num0++;
		}

		int num1 = N;
		while(num1 > 0) {
			boolean found = true;
			String snum = Integer.toString(num1);
			for(int i = snum.length()-1; i > -1 ; i--) {
				int n = snum.charAt(i) - '0';
				if(work[n]) {
					found = false;
					break;
				}
			}
			if(found) {
				break;
			}
			else num1--;
		}

		if(num1 == 0 && work[0]) num1 = 50000000;

		return (Math.abs(N - num0) < Math.abs(N-num1)) ? num0 : num1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M ; i++) {
				work[Integer.parseInt(st.nextToken())] = true;
			}
		}
		int near = getNearstNum();

		int answer = Math.min(Math.abs(N-100), Integer.toString(near).length() + (Math.abs(N-near)));
		System.out.println(answer);
	}
}
