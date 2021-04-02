import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static long MOD=1000000000;
    static int dx[]= {0,0,1,-1};
    static int dy[]= {1,-1,0,0};
    static boolean chk[]=new boolean[100001];
    static int degree[]=new int[100001];
    static Queue<Integer> q=new LinkedList<>();
    static int n,m;
    static ArrayList<Integer> list[]=new ArrayList[100001];
    static ArrayList<Integer> node;
	public static void main(String[] args) throws IOException {
		int k=1;
		boolean flag1=false;
		while(true) {
			memset();
			boolean flag2=false;
			while(!flag2) {
				st=new StringTokenizer(br.readLine());
				int size=st.countTokens();
				for(int i=0;i<size/2;i++) {
					int a=Integer.parseInt(st.nextToken());
					int b=Integer.parseInt(st.nextToken());
					if(a==-1&&b==-1) {
						flag1=true;
						flag2=true;
						break;
					}
					if(a==0 &&b==0) {
						flag2=true;
						break;
					}
					list[a].add(b);
					degree[b]++;
					node.add(a);
					node.add(b);
				}
				
			}
			for(int i=0;i<node.size();i++) {
				if(degree[node.get(i)]==0) {
					chk[node.get(i)]=true;
					q.add(node.get(i));
					break;
				}
			}
			if(flag1) break;
			bw.write("Case "+(k++)+" "+(bfs()?"is a tree.\n":"is not a tree.\n"));
		}
        bw.flush();
        bw.close();
        br.close();
	}
	static void memset() {
		for(int i=1;i<=100000;i++) {
			list[i]=new ArrayList<>();
			chk[i]=false;
			degree[i]=0;
		}
		node=new ArrayList<>();
		while(!q.isEmpty()) q.poll();
	}
	static boolean bfs() {
		while(!q.isEmpty()) {
			int x=q.poll();
			int size=list[x].size();
			for(int i=0;i<size;i++) {
				int next=list[x].get(i);
				if(chk[next]) return false;
				chk[next]=true;
				q.add(next);
			}
		}
		int size=node.size();
		for(int i=0;i<size;i++) {
			if(!chk[node.get(i)]) return false;
		}
		return true;
	}
}