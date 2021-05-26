import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int map[][];
	static int N, M, K, max;
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N]; 
		for (int i = 0; i < N; i++) {
			String a = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(a.charAt(j) + "");
		}
		K = Integer.parseInt(br.readLine());
		find();
		System.out.println(max);
	}
	static void find() {
		for(int i = 0 ; i < N ; i++) {
			if(visit[i])
				continue;
			visit[i] = true;
			if(check(i)) {
				max = Math.max(cntsame(i),max);
			}
			
		}
	}
	static boolean check(int row) {
		int zero = 0;
		for(int i = 0 ; i < M ; i++) {
			if(map[row][i] == 0)
				zero++;
		}
		if(zero <= K && zero%2 == K%2)
			return true;
		return false;
	}
	static int cntsame(int origin) {
		int cnt = 1;
		for(int i = origin+1 ; i < N ; i++ ) {
			boolean issame = true; 
			for(int j = 0 ; j < M ; j++) {
				if(map[origin][j] != map[i][j]) {
					issame = false;
					break;
				}
			}
			if(issame) {
				visit[i] =true;
				cnt++;
			}
		}
		return cnt;
	}
	
	
}
