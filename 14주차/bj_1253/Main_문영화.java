import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_문영화 {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> set = new HashMap<>();
		long[] map = new long[N];
		int res=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			long t = Long.parseLong(st.nextToken());
			map[i] = t;
			if(set.containsKey(t)) {
				set.put(t, set.get(t)+1);
			}else {
				set.put(t, 1);
			}
			
		}
		Arrays.sort(map);
		int Lf =0;
		int Rf =0;

		while(true) {
			if(Rf!=N-1) {
				Rf++;
			}else {
				Lf++;
				Rf=Lf;
				continue;
			}
			long sum = map[Lf]+map[Rf];
			boolean flag =false;
			if(set.containsKey(sum)&&set.get(sum)!=0) {
				for(int i=0;i<N;i++) {
					if(i==Lf||i==Rf) {
						continue;
					}
					if(map[i]==sum) {
						flag=true;
						break;
					}
				}
				if(flag) {
					res+= set.get(sum);
					set.put(sum, 0);
				}
			}
			if(Lf==N-2&&Rf==N-1) break;
		}
		System.out.println(res);
		
	}

}
