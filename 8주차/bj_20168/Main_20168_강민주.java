import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.SynchronousQueue;

public class Main_20168_강민주 {
	static int N;
	static int M;
	static int A;
	static int B;
	static int C;
	static int[][] point;
	static boolean[] v;
	static int max, min;
	static ArrayList<Integer> sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		point=new int[N+1][N+1];
		sum=new ArrayList<Integer>();
		v=new boolean[N+1];
		max=Integer.MIN_VALUE;
		min=Integer.MIN_VALUE;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int g=Integer.parseInt(st.nextToken());
			point[a][b]=g;
			point[b][a]=g;
		}
		v[A]=true;
		dfs(A);
		if(min==Integer.MIN_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	private static void dfs(int start) {
		if(start==B) {
			int result=0;
			for(int i=0;i<sum.size();i++) {
				result+=sum.get(i);
			}
			if(result<=C) {
				if(max<result) {
					min=Integer.MIN_VALUE;
					max=result;
					for(int i=0;i<sum.size();i++) {
						if(min<sum.get(i)) {
							min=sum.get(i);
						}
					}
				}	
			}
			sum.clear();
			return;
		}		
		for(int i=1;i<N+1;i++) {
			if(point[start][i]!=0&&v[i]==false) {
				v[i]=true;
				sum.add(point[start][i]);
				dfs(i);
				v[i]=false;
			}
		}	
	}
}
