import java.io.*;
import java.util.*;
public class MAin_18235 {
	static class duck{
		int point;
		int day;
		public duck(int point, int day) {
			this.point = point;
			this.day = day;
		}
	}
	static int N,A,B;
	static int res= Integer.MAX_VALUE;
	static int[][] duckA,duckB;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		duckA = new int[500001][20];
		duckB = new int[500001][20];
		for (int i = 0; i < 500001; i++) {
			for (int j = 0; j < 20; j++) {
				duckA[i][j] = -1;
				duckB[i][j] = -1;
			}
		}

		moveA();
		moveB();
		
		System.out.println(res == Integer.MAX_VALUE?  -1 : res );
	}
	static int dir[] = {1,-1};

	static void moveA()
	{
		Queue<duck> que = new LinkedList<>();
		que.add(new duck(A, 0));

		while(!que.isEmpty())
		{
			duck cur = que.poll();
			int curpos = cur.point;
			int curday = cur.day;
			int dist = ( 1 << curday );
			for (int i = 0; i < 2; i++) {
				int nextpos = curpos + (dist * dir[i]);
				if(1 >nextpos || nextpos >N) continue;
				if(duckA[nextpos][curday+1] != -1) continue;

				duckA[nextpos][curday+1] = curday+1;
				que.add(new duck(nextpos, curday+1));
			}
		}
	}
	static void moveB()
	{
		Queue<duck> que = new LinkedList<>();
		que.add(new duck(B, 0));

		while(!que.isEmpty())
		{
			duck cur = que.poll();
			int curpos = cur.point;
			int curday = cur.day;
			int dist = ( 1 << curday );
			
			if (duckA[curpos][curday] != -1 && duckA[curpos][curday] == duckB[curpos][curday]) {
				res = curday;
				return;
			}
			
			for (int i = 0; i < 2; i++) {
				int nextpos = curpos + (dist * dir[i]);
				if(1 >nextpos || nextpos >N) continue;
				if(duckB[nextpos][curday+1] != -1) continue;

				duckB[nextpos][curday+1] = curday+1;
				que.add(new duck(nextpos, curday+1));
			}
		}	

	}
}
