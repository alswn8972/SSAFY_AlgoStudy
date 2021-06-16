import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1034 {
	
	static int N, M, K;
	static String[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		map = new String[N];
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine();
		}
		K = Integer.parseInt(br.readLine());
		
		for(int n = 0; n < N; n++) {
			int zc = 0;
			for(int c = 0; c < M; c++) {
				if(map[n].charAt(c) == '0') {
					zc++;
				}
			}
			if(zc > K || zc % 2 != K % 2) continue;
			int same = 0;
			for(int i = 0; i < N; i++) {
				if(map[n].equals(map[i])) {
					same++;
				}
			}
			max = Math.max(max, same);
		}
		System.out.println(max);
	}
}
