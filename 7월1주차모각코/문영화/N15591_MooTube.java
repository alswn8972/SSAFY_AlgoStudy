import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N15591 {
	static class USADO{
		int target;
		long ud;
		public USADO(int target, long ud) {
			this.target = target;
			this.ud = ud;
		}
		
		
	}

	static ArrayList<USADO>[] map;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		map = new ArrayList[N+1];
		
		for(int i=0;i<=N;i++) {
			map[i]=new ArrayList<>();
		}
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			long ga = Integer.parseInt(st.nextToken());
			
			map[x].add(new USADO(y, ga));
			map[y].add(new USADO(x, ga));
			
		}
		
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(bfs(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))).append("\n");
		}
	
		System.out.println(sb.toString());
		
	}
	public static int bfs(long K, int start) {
		int ans=0;
		Queue<Integer> q =new LinkedList<>();
		q.add(start);
		boolean[] v=new boolean[N+1];
		v[start]=true;
		int x;
		while(!q.isEmpty()) {
			x=q.poll();
			
			for(USADO u : map[x]) {
				int t=u.target;
				if(v[t]) continue;
				long score=u.ud;
				
				if(score>=K) {
					v[t]=true;
					q.add(t);
					ans++;
				}
			}
		}
		
		return ans;
	}


}
