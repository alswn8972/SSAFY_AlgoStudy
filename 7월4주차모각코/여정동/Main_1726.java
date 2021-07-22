import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726 {
	static int M ,N;
	static boolean[][] map;
	static boolean[][][] vi;
	static int[] dy = {0,0,0,1,-1};
	static int[] dx = {0,1,-1,0,0};
	static Robot robot;
	static Robot arrival;
	
	static int bfs() {
		Queue<Robot> q = new LinkedList<>();
		vi[robot.y][robot.x][robot.dir] = true;
		q.offer(robot);
		
		while(!q.isEmpty()) {
			Robot now = q.poll();
			if(now.equals(arrival)) {
				return now.com;
			} else {
				int turn_left = now.turn_left();
				int turn_right = now.turn_right();
				
				if(!vi[now.y][now.x][turn_left]) {
					q.offer(new Robot(now.y, now.x, turn_left, now.com+1));
					vi[now.y][now.x][turn_left] = true;
				}
				if(!vi[now.y][now.x][turn_right]) {
					q.offer(new Robot(now.y, now.x, turn_right, now.com+1));
					vi[now.y][now.x][turn_right] = true;
				}
				
				int ny = now.y; 
				int nx = now.x; 
				for(int i = 0; i < 3; i++) {
					ny += dy[now.dir];
					nx += dx[now.dir];
					if(ny <= M && nx <= N && ny > 0 && nx > 0 && !vi[ny][nx][now.dir] && map[ny][nx]) {
						q.offer(new Robot(ny, nx, now.dir, now.com+1));
						vi[ny][nx][now.dir] = true;
					}
					else if(ny <= M && nx <= N && ny > 0 && nx > 0 && vi[ny][nx][now.dir] && map[ny][nx]) continue;
					else break;
				}
			}
		}	
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new boolean[101][101];
		vi = new boolean[101][101][5];
		int temp;
		
		for(int i = 1; i <= M ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N ; j++) {
				temp = Integer.parseInt(st.nextToken());
				map[i][j] = (temp == 0) ? true : false;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		robot = new Robot(y,x,dir);
		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		arrival = new Robot(y, x, dir);
		
		System.out.println(bfs());
	}
	static class Robot{
		int y;
		int x;
		int dir;
		int com;
		
		public Robot(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.com = 0;
		}
		
		public Robot(int y, int x, int dir, int com) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.com = com;
		}

		public boolean equals(Robot obj) {
			if(this.y == obj.y && this.x == obj.x && this.dir == obj.dir) return true;
			return false;
		}
		
		public int turn_left() {
			if(this.dir == 1) {
				return 3;
			} else if(this.dir == 2) {
				return 4;
			} else if(this.dir == 3) {
				return 2;
			} else {
				return 1;
			}
		}
		
		public int turn_right() {
			if(this.dir == 1) {
				return 4;
			} else if(this.dir == 2) {
				return 3;
			} else if(this.dir == 3) {
				return 1;
			} else {
				return 2;
			}
		}
	}
}
