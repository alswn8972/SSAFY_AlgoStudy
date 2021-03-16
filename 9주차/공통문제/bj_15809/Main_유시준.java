import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_유시준 { 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int a[]=new int[100001];
	static int parent[]=new int[100001];
	static int n,m;
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		for(int i=1;i<=n;i++) {
			a[i]=Integer.parseInt(br.readLine());
			parent[i]=i;
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int o=Integer.parseInt(st.nextToken());
			int p=Integer.parseInt(st.nextToken());
			int q=Integer.parseInt(st.nextToken());
			union(p,q,o);
		}
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=1;i<=n;i++) {
			int x=find(i);
			if(x!=i) continue;
			if(a[x]>0) {
				list.add(a[x]);
			}
		}
		bw.write(Integer.toString(list.size())+"\n");
		Collections.sort(list);
		for(int num:list) {
			bw.write(Integer.toString(num)+" ");
		}
		bw.flush();
	}
	static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x]=find(parent[x]);
	}
	static void union(int x,int y,int z) {
		int rx=find(x);
		int ry=find(y);
		if(rx==ry) return;
		if(z==1) {
			a[ry]+=a[rx];
			a[rx]=0;
		}else {
			if(a[rx]>a[ry]) {
				int tmp=rx;
				rx=ry;
				ry=tmp;
			}
			a[ry]-=a[rx];
			a[rx]=0;
		}
		parent[rx]=ry;
		return;
	}
	
}



