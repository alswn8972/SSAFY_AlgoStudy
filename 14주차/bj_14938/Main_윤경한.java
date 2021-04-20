import java.io.*;
import java.util.*;
public class Main_14938 {
	static int N , M , R;
	static int item[], dist[];
	static boolean check[];
	static ArrayList<Node> list[]; 
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		item = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int start , from , dist;
			start = Integer.parseInt(st.nextToken());
			from = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());

			list[start].add(new Node(from, dist));
			list[from].add(new Node(start, dist));
		}


		dist = new int[N+1];
		check = new boolean[N + 1];

		int res = 0;
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			Arrays.fill(check, false);
			res = Math.max(res, bfs(i));
		}
		System.out.println(res+"");
	}
	static int bfs(int start)
	{
		int ans =0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while(!pq.isEmpty())
		{
			Node cur = pq.poll();

			int curnum = cur.areaNum;
			int curwei = cur.wei;

			if(!check[curnum]) { 
				check[curnum] = true;
				for (int i = 0; i < list[curnum].size(); i++) {
					if(dist[list[curnum].get(i).areaNum] > curwei + list[curnum].get(i).wei)
					{
						dist[list[curnum].get(i).areaNum] = curwei + list[curnum].get(i).wei;
						pq.add(new Node(list[curnum].get(i).areaNum, dist[list[curnum].get(i).areaNum]));
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (dist[i] <= M) {
				ans += item[i];
			}
		}
		return ans;
	}
	static class Node implements Comparable<Node>{
		int areaNum;
		int wei;
		public Node(int areaNum,int wei) {
			this.areaNum = areaNum;
			this.wei = wei;
		}
		public int compareTo(Node o)
		{
			return this.wei - o.wei;
		}

	}
}
