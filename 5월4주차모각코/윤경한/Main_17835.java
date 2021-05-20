import java.util.*;
import java.io.*;
public class Main_17835 {
	static long N,M,K;
	static ArrayList<Node> list[];
	static long dist[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		list = new ArrayList[100001];
		dist = new long[100001];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			dist[i] = Long.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			int to,from,dist;
			to = Integer.parseInt(st.nextToken());
			from = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, dist));
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int temp = Integer.parseInt(st.nextToken());
			pq.add(new Node(temp, 0));
			dist[temp] =0;
		}


		while(!pq.isEmpty())
		{
			Node cur = pq.poll();
			long curidx = cur.from;
			long curdist = cur.dist;
			if(dist[(int)curidx] < curdist) continue;

			for (int i = 0; i < list[(int)curidx].size(); i++) {
				long next = list[(int)curidx].get(i).from;
				long nv =list[(int)curidx].get(i).dist;
				if (dist[(int)next] > curdist + nv) {
					dist[(int)next] = curdist + nv;
					pq.add(new Node(next, curdist+nv));
				}
			}
		}
		long max =0;
		long res =0;
		for (long i = 1; i <= N; i++) {
			if (dist[(int)i] > max) {
				max = dist[(int)i];
				res = i;
			}
		}
		System.out.println(res);
		System.out.println(max);
	}
	static class Node implements Comparable<Node>
	{
		long from,dist;
		public Node(long from, long dist) {
			this.from = from;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o)
		{
			return (int)(this.dist-o.dist);
		}

	}
}
