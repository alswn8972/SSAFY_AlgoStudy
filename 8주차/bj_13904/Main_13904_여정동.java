import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13904_여정동 {
	static int N;
	static Hw[] hws;
	static boolean[] iv = new boolean[1001];
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		hws = new Hw[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			hws[i] = new Hw(d,p);
		}
		Arrays.sort(hws);
		
		for(int i = 0; i < N; i++) {
			int d = hws[i].dl;
			while(d > 0) {
				if(!iv[d]) {
					iv[d]=true;
					count += hws[i].pt;
					break;
				}
				else {
					--d;
				}
			}
		}	
		bw.write(Integer.toString(count));
		bw.flush();
	}
}
class Hw implements Comparable<Hw>{
	int dl;
	int pt;
	Hw(int dl, int pt){
		this.dl = dl;
		this.pt = pt;
	}
	@Override
	public int compareTo(Hw o) {
		return -(this.pt-o.pt);
	}
}