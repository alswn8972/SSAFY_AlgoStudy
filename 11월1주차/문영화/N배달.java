package dijkstrapq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class N배달 {
	static class Node implements Comparable<Node>{
		int ndnum,totaldis;

		public Node(int nd, int totaldis) {
			this.ndnum = nd;
			this.totaldis = totaldis;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.totaldis-o.totaldis;
		}

		
	}
	 public static void main(String[] args) {
		int[][] input1={{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int[][] input ={{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		System.out.println(solution(6,input,4));
	}
	 
	 public static int solution(int n, int[][] load,int k) {
		
		int[] D = new int[n+1]; //거리
		boolean[] v = new boolean[n+1];// 방문체크
		
		ArrayList<Node>[] list = new ArrayList[n+1];
		
		for(int i=0;i<n+1;i++) {
			list[i]= new ArrayList<>();
		}
		
		for(int i=0;i<load.length;i++) {
			int start = load[i][0];
			int end = load[i][1];
			int w = load[i][2];
			list[start].add(new Node(end,w));
			list[end].add(new Node(start,w));
		}
		Arrays.fill(D,Integer.MAX_VALUE);
		D[1]=0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
	
		pq.add(new Node(1,0)); // 출발 정점, 비용 (출발점이니 비용 없음)
		
		Node cur;
		while(!pq.isEmpty()) {
			cur=pq.poll();
			
			if(v[cur.ndnum]) continue;
			
			v[cur.ndnum] = true;
//			if(cur.ndnum==5) {
//				System.out.println("debug");
//			}
			for(Node ne:list[cur.ndnum]) {
//				if(ne.ndnum==5) {
//					System.out.println("debug");
//				}
				if(!v[ne.ndnum]&&D[ne.ndnum]>D[cur.ndnum]+ne.totaldis) {
					D[ne.ndnum]=D[cur.ndnum]+ne.totaldis;
					
					pq.add(new Node(ne.ndnum,D[ne.ndnum]));
				}
			}
			
		}
		
		int cnt=0;
		 for(int i=1;i<n+1;i++) {
			 if(D[i]<=k) cnt++;
		 }
		 
		 return cnt;
	 }
	 
	 

}
