import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16174_강민주 {
	static int N;
	static int[][] board;
	static boolean[][] v;
	static int[] dx= {0, 1};
	static int[] dy= {1, 0};
	static Queue<Point> que;
	static class Point{
		int x,y,dis;
		Point(int x, int y, int dis){
			this.x=x;
			this.y=y;
			this.dis=dis;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		que=new LinkedList<>();
		N=Integer.parseInt(br.readLine());
		board=new int[N][N];
		v=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
				if(i==0&&j==0) {
					v[i][j]=true;
					que.add(new Point(i,j,board[i][j]));
				} 
			}
		}
		boolean check=false;
		stop:while(!que.isEmpty()) {
			Point po=que.poll();
			for(int d=0;d<2;d++) {
				int nx=po.x+dx[d]*po.dis;
				int ny=po.y+dy[d]*po.dis;
				if(nx<0||ny<0||nx>=N||ny>=N||v[nx][ny]) {
					continue;
				} 
				if(board[nx][ny]==-1) {
					check=true;
					break stop;
				} 
				v[nx][ny]=true;
				que.add(new Point(nx, ny, board[nx][ny]));
			}
		}
		if(check==true) System.out.println("HaruHaru");
		else System.out.println("Hing");
	}
}
