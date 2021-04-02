import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int MAX=100000000;
    static int dx[]= {0,0,1,-1};
    static int dy[]= {1,-1,0,0};
    static int n,m;
    static String str;
    static Set<String> set=new HashSet<>();
    static int a[][]=new int[201][201];
    static int dist[][]=new int[201][201];
    static int path[][]=new int[201][201];
    static int ans=MAX;
//    static ArrayList<Integer> tree[]=new ArrayList[100001];
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				path[i][j]=j;
				dist[i][j]=MAX;
			}
			dist[i][i]=0;
		}
		for(int i=1;i<=m;i++) {
			int s,e,cost;
			st=new StringTokenizer(br.readLine());
			s=Integer.parseInt(st.nextToken());
			e=Integer.parseInt(st.nextToken());
			cost=Integer.parseInt(st.nextToken());
			a[s][e]=cost;
			a[e][s]=cost;
			dist[s][e]=Math.min(dist[s][e], cost);
			dist[e][s]=dist[s][e];
		}
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(dist[i][j]>dist[i][k]+dist[k][j]) {
						dist[i][j]=dist[i][k]+dist[k][j];
						path[i][j]=k;
					}
				}
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j) bw.write("- ");
				else {
					int k=j;
					while(a[i][k]!=dist[i][k]) {
						k=path[i][k];
					}
					bw.write(path[i][k]+" ");
				}
			}
			bw.write("\n");
		}
		bw.flush();
        bw.close();
        br.close();
	}
}