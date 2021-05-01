import java.io.*;
import java.util.*;

public class Main_14267 {
	public static int N,M;
	public static ArrayList<Integer> list[];
	public static int res[];
	public static int weight[];
	public static void dfs(int pnum, int good) {
		res[pnum]+= good;
		
		for(int i=0;i<list[pnum].size();i++) {
			int next = list[pnum].get(i);
			dfs(next,good + weight[next]);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		weight = new int[N+1];
		
		res = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		st.nextElement();
		
		for(int i=2;i<=N;i++) {
			int num = Integer.parseInt(st.nextToken());
			list[num].add(i);
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int person = Integer.parseInt(st.nextToken());
			int good = Integer.parseInt(st.nextToken());
			weight[person] += good;
		}
		
		dfs(1,weight[1]);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			sb.append(res[i] + " ");
		}
		System.out.println(sb.toString());
	}
}
