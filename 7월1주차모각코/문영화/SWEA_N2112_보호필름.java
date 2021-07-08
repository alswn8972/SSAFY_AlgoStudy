package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2112_보호필름 {
	static int D,W,K;
	static int[][] map;
	static boolean[] row;
	static int min;
	static int[] num= {0,1};
	static int[][] temparr;
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("res/input_swea_2112.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t =1;t<=TC;t++) {
			
			st = new StringTokenizer(br.readLine());
			D= Integer.parseInt(st.nextToken());
			W= Integer.parseInt(st.nextToken());
			K= Integer.parseInt(st.nextToken());
			
			map=new int[D][W];
			temparr=new int[D][W];
			for(int i=0;i<D;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					temparr[i][j]=map[i][j];
				}
			}
			if(check(map)||K==1) {
				sb.append("#").append(t).append(" ").append(0).append("\n");
				continue;
			}else {
				row=new boolean[D];
				min = Integer.MAX_VALUE;
				dfs(0,0);
				sb.append("#").append(t).append(" ").append(min).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	public static boolean check(int[][] arr) {
		int cnt;
		for(int i=0;i<W;i++) {
			cnt=1;
			for(int j=0;j<D-1;j++) {
				if (cnt >= K) break;
				if(arr[j][i]==arr[j+1][i]) {
					cnt++;
					
				}else {
					cnt=1;
				}
				
			}
			if(cnt<K) {
				return false;
			}
		}
		return true;
	}
	
	public static void dfs(int n, int layer) {
		if(layer==D) {
			if(check(temparr)) {
				min=Math.min(min, n);
			}
			return;
		}
		if(n==K) {
			return;
		}
		//주입x
		dfs(n,layer+1);
		
		change(layer,0,temparr);
		dfs(n+1,layer+1);
		
		change(layer,1,temparr);
		dfs(n+1,layer+1);
		
		System.arraycopy(map[layer], 0, temparr[layer], 0, W);
	
	}
	public static void change(int r,int x,int[][] m) {
		for(int i=0;i<W;i++) {
			m[r][i]=x;
		}
	}
	

}
