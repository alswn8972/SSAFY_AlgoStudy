import java.util.*;
import java.io.*;


public class Main_20168_윤경한 {
	static int N,M,A,B,C;
	static ArrayList<Node> list[];
	static int Mycost = Integer.MAX_VALUE;
	static boolean  flag;
	static boolean check[];
	
	public static class Node {
		int dest;
		int cost;
		public Node(int dest, int cost) {
			super();
			this.dest = dest;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken())-1;
		B = Integer.parseInt(st.nextToken())-1;
		C = Integer.parseInt(st.nextToken());
		
		check = new boolean[N+1];
		
		list = new ArrayList[N];
		for (int i = 0; i < N ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i <  N; i++) {
			st = new StringTokenizer(br.readLine());
			int a  = Integer.parseInt(st.nextToken())-1;
			int b  = Integer.parseInt(st.nextToken())-1;
			int c  = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
			
		}
		dfs(A,C,-1);
		
		
		System.out.println(Mycost == Integer.MAX_VALUE ? -1 : Mycost);

		br.close();
		bw.close();
	}

	static void dfs(int cur, int havemoney ,int maxi)
	{	
		if ( cur == B ) {
			Mycost = Math.min(Mycost,maxi);
			return;
		}
		if ( havemoney <= 0) return;
		
		for (int i = 0; i < list[cur].size(); i++) {
			int next = list[cur].get(i).dest;
			int newcost = list[cur].get(i).cost;

			if(check[next] ||  havemoney < newcost) continue;

			
			check[next]= true;
			dfs(next,havemoney-newcost, Math.max(newcost, maxi));
			check[next]=false;
		}
	}
}
