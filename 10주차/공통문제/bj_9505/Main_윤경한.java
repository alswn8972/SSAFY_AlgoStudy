import java.util.*;
import java.io.*;

public class Main_9505 {
	static int T,K,W,H;
	static int map[][];
	static boolean check[][];
	static int Ex,Ey;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			check = new boolean[H][W];
			int temp[] = new int[50];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				char tidx = st.nextToken().charAt(0);
				temp[tidx-'A'] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<H; i++){
				String s = new String(br.readLine());
	            for(int j=0; j<W; j++){
	                if(s.charAt(j)=='E'){
	                    Ex=i;
	                    Ey=j;
	                }
	                else
	                	map[i][j] = temp[s.charAt(j)-'A']; // 배열에 점수 할당
	            }
			}
			
			long ans = bfs();
			System.out.println(ans);
		}
		
		
		
	}
	static int dir[][]= {{1,0},{0,1},{-1,0},{0,-1}};
	
	static long bfs()
	{
		int res =0;
		Node start = new Node(Ex, Ey, 0);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(start);
		check[Ex][Ey] = true;
		
		while(!pq.isEmpty())
		{
			Node cur = pq.poll();
			if(cur.x ==0 || cur.x == H-1 || cur.y ==0 || cur.y == W-1)
			{
				res = cur.dist;
				return res;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dir[i][0];
				int ny = cur.y + dir[i][1];
				
				if(nx < 0 || nx >=H || ny < 0 || ny >= W) continue;
				if(check[nx][ny]) continue;
				
				int nd = cur.dist + map[nx][ny];
				
				pq.add(new Node(nx,ny,nd));
				check[nx][ny] = true;
				
			}
		}
		return res;
	}
	static class Node implements Comparable<Node>
	{
		int x, y; 
		int dist;

		public Node(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		public int compareTo(Node obj) {
			return -((int)obj.dist-(int)this.dist);
	    }
	}
}
