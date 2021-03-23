import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class N20166 {
	static int[] dx= {-1,-1,-1,0,0,1,1,1};
	static int[] dy= {-1,0,1,-1,1,-1,0,1};
	static char[][] map;
	static int maxlenStr = 0;
	static int N,M;
	static HashMap<String, Integer> godStr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map= new char[N][M];
		godStr = new HashMap<>();
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j);
			}
		}
		for(int i=0;i<K;i++) {
			String god =br.readLine();
			maxlenStr = Math.max(maxlenStr, god.length());
			godStr.put(god, 0);
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				dfs(i,j,Character.toString(map[i][j]),1);
			}
		}
		Set<String> keyset = godStr.keySet();
		Iterator<String> key = keyset.iterator();
		
		while(key.hasNext()) {
			System.out.println(godStr.get(key.next()));
		}
	}
	public static void dfs(int x, int y, String str, int len) {
		if(godStr.containsKey(str)) {
			godStr.put(str, godStr.get(str)+1);
		}
		if(len>=maxlenStr) {
			return;
		}
		
		for(int i=0;i<8;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0) {
				nx=N-1;
			}else if(nx>=N) {
				nx=0;
			}
			if(ny<0) {
				ny=M-1;
			}else if(ny>=M) {
				ny=0;
			}
			
			dfs(nx,ny,str+map[nx][ny],len+1);
		}
	}
}
