import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class N1976_여행가자 {

	static ArrayList<Integer>[] map;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());//도시의 수
		int M = Integer.parseInt(br.readLine());//여행도시 수
		StringTokenizer st;
		map= new ArrayList[N+1];
		int[] path = new int[M];
		 for(int i=0;i<=N;i++) {
			 map[i]=new ArrayList<>();
		 }
		 int temp;
		 for(int i=1;i<=N;i++) {
			 st= new StringTokenizer(br.readLine());
			 for(int j=1;j<=N;j++) {
				 temp=Integer.parseInt(st.nextToken());
				 if(temp==1)  map[i].add(j);
			 }
		 }
		 st= new StringTokenizer(br.readLine());
		 for(int i=0;i<M;i++) {
			 path[i]=Integer.parseInt(st.nextToken());
		 }
		 
		 for(int i=0;i<M-1;i++) {
			 if(!bfs(path[i],path[i+1])) {
				 System.out.println("NO");
				 return;
			 }
		 }
		 System.out.println("YES");
		 return;
		
	}
	public static boolean bfs(int start, int end) {
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] v = new boolean[N+1];
		q.add(start);
		v[start]=true;
		
		int temp;
		while(!q.isEmpty()) {
			temp=q.poll();
			if(temp==end) {
				return true;
			}
			for(int x: map[temp]) {
				if(v[x])continue;
				q.add(x);
				v[x]=true;
			}
		}
		
		return false;
	}

}
