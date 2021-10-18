package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1952_수영장 {
	
	static int[] price;
	static int[] used;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("src/inputfile/N1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=TC;i++) {
			
			price = new int[4];
			used = new int[13];
			min=Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int p=0;p<4;p++) {
				price[p] = Integer.parseInt(st.nextToken());
			}
			st= new StringTokenizer(br.readLine());
			for(int u=1;u<13;u++) {
				used[u] = Integer.parseInt(st.nextToken());
			}
			
			dfs(1,0);
			if(min>price[3]) {
				min=price[3];
			}
			sb.append("#").append(i).append(" ").append(min).append("\n");
		
		}
		System.out.println(sb.toString());
	}
	public static void dfs(int month,int p) {
		if(month>12) {
			if(min>p) {
				min=p;
			}
			return;	
		}
		if(used[month]==0) dfs(month+1,p);
		//1일
		dfs(month+1,p+(price[0]*used[month]));
		//1달 이용권
		dfs(month+1,p+price[1]);
		//3달
		dfs(month+3,p+price[2]);
		
	}

}
