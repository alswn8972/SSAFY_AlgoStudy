import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179 {
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x =x;
			this.y =y;
		}
	}
	static int R,C,res;
	static int map[][];
	static boolean Fvisit[][];
	static boolean Jvisit[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static Queue<Point> J=new LinkedList<Point>();
	static Queue<Point> F=new LinkedList<Point>();

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 

		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());

		map = new int[R][C];
		Fvisit = new boolean[R][C];
		Jvisit = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String a = br.readLine();
			for(int j=0; j<C; j++) {
				if(a.charAt(j)=='#') {
					map[i][j] = 1;
				}else if(a.charAt(j)=='J') {
					map[i][j] = 2;
					J.add(new Point(i,j));
				}else if(a.charAt(j)=='F') {
					map[i][j] = 3;
					F.add(new Point(i,j));
					Fvisit[i][j]= true;
				}
			}
		}
		boolean exit=false;
		while(!J.isEmpty()) {
			res ++;
			int size=J.size();
			for(int i=0; i<size; i++) {
				Point cur=J.poll();
				int x=cur.x;
				int y=cur.y;

				if(map[x][y]==3)continue;

				for(int j=0;j<4;j++) {
					int nx=x+dx[j];
					int ny=y+dy[j];

					if(nx<0||ny<0||nx>=R||ny>=C) {
						exit=true;
						break;
					}
					if(map[nx][ny]==0&&!Jvisit[nx][ny]) {
						Jvisit[nx][ny] =true;
						J.add(new Point(nx,ny));
					}
				}
			}
			if(exit)break;

			int firesize=F.size();
			for(int i=0;i<firesize;i++) {
				Point curf=F.poll();
				int x=curf.x;
				int y=curf.y;

				for(int j=0; j<4; j++) {
					int nx=x+dx[j];
					int ny=y+dy[j];

					if(nx<0||ny<0||nx>=R||ny>=C)continue;
					if(map[nx][ny]==0) {
						map[nx][ny]=3;
						F.add(new Point(nx,ny));
					}
				}				
			}
		}
		if(exit)bw.write(res+"");
		else bw.write("IMPOSSIBLE");
		bw.flush();
		bw.close();
		br.close();
	}
}