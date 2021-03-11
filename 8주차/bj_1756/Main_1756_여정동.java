import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1756_여정동 {
	static int D,N;
	static int[] oven;
	static int[] pizza;
	static int bottom;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		bottom = D;
		oven = new int[D];
		pizza =  new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < D; i++) {
			oven[i] = Integer.parseInt(st.nextToken());
			if(i > 0 && oven[i-1] < oven[i]) {
				oven[i] = oven[i-1];
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pizza[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = bottom-1; j > -1; j--) {
				if(oven[j] >= pizza[i]) {
					count++;
					bottom = j;
					break;
				}
			}
		}
		if(count != N) {
			bw.write("0");
		}
		else {
			bw.write(Integer.toString(bottom+1));
		}
		bw.flush();
	}
}
