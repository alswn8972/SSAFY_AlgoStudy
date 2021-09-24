package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1753 {
	static class Node implements Comparable<Node>{
		int num;
		int op;
		public Node(int num, int op) {
			super();
			this.num = num;
			this.op = op;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.op-o.op;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int Start = Integer.parseInt(br.readLine());
		boolean[] visit = new boolean[V+1];
		int[] answer = new int[V+1];
		Arrays.fill(answer, Integer.MAX_VALUE);
		
		answer[Start]=0;
		
		List<Node>[] maps = new ArrayList[V+1];
		
		for(int i=0;i<=V;i++) {
			maps[i]= new ArrayList<>(); 
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			maps[u].add(new Node(v,w));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Node nd;
		pq.offer(new Node(Start,0));
		while(!pq.isEmpty()) {
			nd = pq.poll();
			if(visit[nd.num]) continue;
			visit[nd.num]=true;
			
			for(Node n: maps[nd.num]) {
				if(!visit[n.num]&&answer[n.num]>answer[nd.num]+n.op) {
					
					answer[n.num]=answer[nd.num]+n.op;
					pq.offer(new Node(n.num,answer[n.num]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=V;i++) {
			if(answer[i]==Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
				continue;
			}
			
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
