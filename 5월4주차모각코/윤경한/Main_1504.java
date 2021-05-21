import java.io.*;
import java.util.*;

public class Main_1504 {
	static int N,E;
	static ArrayList<Node> list[];
	static int dist[];
	private static final int INF = 200_000_000;
	static boolean check[];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];

		dist = new int[N + 1];
		check = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int to,from,dist;

			to = Integer.parseInt(st.nextToken());
			from = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());

			list[to].add(new Node(from, dist));
			list[from].add(new Node(to, dist));

		}

		st = new StringTokenizer(br.readLine());
		int require1 = Integer.parseInt(st.nextToken());
		int require2 = Integer.parseInt(st.nextToken());


		int answer = solve(require1, require2);
		System.out.println(answer);
	}
	private static int solve(int required1, int required2){
		int result1 = 0;
		int result2 = 0;

		result1 += dijkstra(1, required1);
		result1 += dijkstra(required1, required2);
		result1 += dijkstra(required2, N);


		result2 += dijkstra(1, required2);
		result2 += dijkstra(required2, required1);
		result2 += dijkstra(required1, N);


		if(result1 >= INF && result2 >= INF) return -1;
		else return Math.min(result1, result2);
	}

	private static int dijkstra(int start, int end){
		Arrays.fill(dist, INF);
		Arrays.fill(check, false);

		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		dist[start] = 0;

		while (!queue.isEmpty()){
			Node curPoint = queue.poll();
			int curNode = curPoint.idx;
			int curWeight = curPoint.dist;

			if(check[curNode] == true) continue;
			check[curNode] = true;

			for(int i = 0; i < list[curNode].size(); i++){
				int nextNode = list[curNode].get(i).idx;
				int nextWeight = list[curNode].get(i).dist;

				if(check[nextNode] == false && dist[nextNode] > curWeight + nextWeight){
					dist[nextNode] = curWeight + nextWeight;
					queue.add(new Node(nextNode, dist[nextNode]));
				}
			}
		}
		return dist[end];
	}
	static class Node implements Comparable<Node>
	{
		int idx,dist;
		public Node(int idx, int dist) {
			super();
			this.idx = idx;
			this.dist = dist;
		}
		
		
		@Override
		public int compareTo(Node o) {
			return dist - o.dist;
		}
	}
}
