import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Four implements Comparable<Four>{
	int fx,fy,cnt;
	public Four(int fx, int fy, int cnt) {
		this.fx = fx;
		this.fy = fy;
		this.cnt =cnt;
	}

	@Override
	public int compareTo(Four o) {
		return this.cnt-o.cnt;
	}
	
}
public class Main_문영화 {
	static int[] Enter;
	static int W,H;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int T=0;T<TC;T++) {
			HashMap<Character, Integer> attack = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			boolean[][] v = new boolean[H][W];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				attack.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
			}
			for(int k=0;k<H;k++) {
				String line = br.readLine();
				for(int j=0;j<W;j++) {
					char c= line.charAt(j);
					if(c=='E') {
						 Enter=new int[] {k,j};
						 map[k][j]=0;
						 continue;
					}
					map[k][j]= attack.get(c);
				}
			}
			if(Enter[0]==0||Enter[0]==H-1||Enter[1]==0||Enter[1]==W-1) {
				sb.append(0+"\n");
				continue;
			}
			int[] dx = {-1,1,0,0};
			int[] dy = {0,0,-1,1};
			
			PriorityQueue<Four> pq = new PriorityQueue<>();
			pq.offer(new Four(Enter[0],Enter[1],0));
			v[Enter[0]][Enter[1]]=true;
			Four nd;
			while(!pq.isEmpty()) {
				nd = pq.poll();
				if(nd.fx==0||nd.fx==H-1||nd.fy==0||nd.fy==W-1) {
					sb.append(nd.cnt+"\n");
					break;
				} 
				
				for(int i=0;i<4;i++) {
					int nx = nd.fx+dx[i];
					int ny = nd.fy+dy[i];
					
					if(nx<0||ny<0||nx>=H||ny>=W||v[nx][ny]) continue;
					v[nx][ny]=true;
					pq.offer(new Four(nx,ny,nd.cnt+map[nx][ny]));
					
				}
			}
			
		}
		System.out.println(sb.toString());
	}

}
