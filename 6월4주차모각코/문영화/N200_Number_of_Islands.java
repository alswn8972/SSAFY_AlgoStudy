package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class N200_Number_of_Islands {

	public static void main(String[] args) {
		char[][] grid= {
			  {'1','1','1','1','0'},
			  {'1','1','0','1','0'},
			  {'1','1','0','0','0'},
			  {'0','0','0','0','0'}
			};
		System.out.println(numIslands(grid));
	}
	static boolean[][] check;
	static int N,M;
	public static int numIslands(char[][] grid) {
		int answer = 0;
		N = grid.length;
		M = grid[0].length;
		check = new boolean[N][M];
		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] == '1'&&!check[i][j]) {
					bfs(grid,i,j);
					answer++;
				}
			}
		}
		
		return answer;

	}
	
	public static void bfs(char[][] grid, int x,int y) {
		Queue<int[]> q = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		check[x][y]=true;
		q.add(new int[] {x,y});
		int[] temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(nx<0||ny<0||nx>=N||ny>=M||check[nx][ny]||grid[nx][ny]=='0') continue;
					
				check[nx][ny]=true;
				q.add(new int[] {nx,ny});
				

			}
			
		}

	}

}
