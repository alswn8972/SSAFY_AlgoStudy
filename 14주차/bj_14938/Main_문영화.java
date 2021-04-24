import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_문영화 {

	static class street implements Comparable<street>{
		int idx;
		int weight;
		
		public street(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(street o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
		
	}
	static int[] item;
	static int[][] map;
	static int n,m,r;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		r= Integer.parseInt(st.nextToken());
		
		item = new int[n+1];
		map = new int[n+1][n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			item[i]= Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[from][to]= weight;
			map[to][from]= weight;
		}
		int max = Integer.MIN_VALUE;
		
		for(int i=1;i<=n;i++) {
			max = Math.max(dij(i), max);
		}
		
		System.out.println(max);
	}
	private static int dij(int start) {
		boolean[] v = new boolean[n+1];
		int[] dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		PriorityQueue<street> pq = new PriorityQueue<>();
		dis[start]=0;
		pq.offer(new street(start, dis[start]));
		int res=0;
		street s;
		while(!pq.isEmpty()) {
			s = pq.poll();
			
			if(v[s.idx]) continue;
			v[s.idx]=true;
			
			for(int i=1;i<=n;i++) {
				if(!v[i]&&map[s.idx][i]!=0&&map[s.idx][i]+s.weight<dis[i]) {
					dis[i]=map[s.idx][i]+s.weight;
					pq.offer(new street(i, dis[i]));
				}
			}
		}
		for(int i=1;i<=n;i++) {
			if(dis[i]<=m)
				res+=item[i];
		}
		return res;
	}
	
	

}
