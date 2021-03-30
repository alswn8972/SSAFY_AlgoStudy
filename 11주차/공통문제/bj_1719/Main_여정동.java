import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_여정동{
	static int N, M;
	static ArrayList<Edge>[] edges;
	static int[][] arr;
	
	static void dij(int ind) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		int[] D = new int[N+1];
		int[] fnode = new int[N+1]; 
		boolean[] iv = new boolean[N+1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[ind] = 0;
		pq.offer(new Node(ind, 0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(iv[current.now]) continue;
			iv[current.now] = true;
			
			for(int i = 0; i < edges[current.now].size(); i++) {
				int next = edges[current.now].get(i).next;
				int cost = edges[current.now].get(i).cost;
				if(!iv[next] && D[next] > D[current.now] + cost) {
					D[next] = D[current.now] + cost;
					fnode[next] = current.now;
					pq.offer(new Node(next, D[next]));
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(i != ind) arr[i][ind] = fnode[i];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N+1];
		arr = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<Edge>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[a].add(new Edge(b, c));
			edges[b].add(new Edge(a, c));
		}
		
		for(int i = 1; i <= N; i++) {
			dij(i);
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i==j) bw.write("- ");
				else bw.write(arr[i][j]+" ");
			}bw.write("\n");
		}
		bw.flush();
	}
	
	static class Node implements Comparable<Node>{
		int now;
		int cost;
		Node(int now, int cost){
			this.now = now;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static class Edge{
		int next;
		int cost;
		Edge(int next, int cost){
			this.next = next;
			this.cost = cost;
		}
	}
}