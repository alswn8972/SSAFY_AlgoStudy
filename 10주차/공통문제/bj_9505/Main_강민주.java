import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_강민주 {
	static int[] dx={1,0,-1,0};
	static int[] dy={0,1,0,-1};
	static boolean[][] check;
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int sum;
		Point(int x, int y, int sum){
			this.x=x;
			this.y=y;
			this.sum=sum;
		}
		@Override
		public int compareTo(Point o) {
			return this.sum-o.sum;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			PriorityQueue<Point> pq=new PriorityQueue<>();
			st=new StringTokenizer(br.readLine());
			int K=Integer.parseInt(st.nextToken());
			int W=Integer.parseInt(st.nextToken());
			int H=Integer.parseInt(st.nextToken());
			
			int[] kind=new int[K+1];
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(br.readLine());
				int index=st.nextToken().charAt(0)-'A';
				kind[index]=Integer.parseInt(st.nextToken());
			}
			
			int[][] map=new int[H][W];
			check=new boolean[H][W];
			for(int i=0;i<H;i++) {
				String str=new String(br.readLine());
				for(int j=0;j<W;j++) {
					if(str.charAt(j)=='E') {
						map[i][j]=0;
						check[i][j]=true;
						pq.offer(new Point(i,j,map[i][j]));
					}
					else map[i][j]=kind[str.charAt(j)-'A'];
				}	
			}
		
			while(!pq.isEmpty()) {
				Point po=pq.poll();
				int cx=po.x;
				int cy=po.y;
				int cs=po.sum;
				if(cx==0||cy==0||cx==H-1||cy==W-1) {
					System.out.println(cs);
					break;
				}
				for(int d=0;d<4;d++) {
					int nx=cx+dx[d];
					int ny=cy+dy[d];
					if(nx<0||ny<0||nx>=H||ny>=W) continue;
					if(check[nx][ny]==true) continue;
					pq.offer(new Point(nx, ny, cs+map[nx][ny]));
					check[nx][ny]=true;
				}
			}
		}//tc끝
	}
}
