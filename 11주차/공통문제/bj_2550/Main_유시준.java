import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static long MOD=1000000000;
    static int dx[]= {0,0,1,-1};
    static int dy[]= {1,-1,0,0};
    static int n;
    static int a[]=new int[10001];
    static int e[]=new int[10001];
    static int b[]=new int[10001];
    static int c[]=new int[10001];
    static int d[]=new int[10001];
	public static void main(String[] args) throws IOException {
		n=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int now=Integer.parseInt(st.nextToken());
			e[i]=now;
			a[now]=i;
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			b[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<n;i++) {
			c[i]=a[b[i]];
		}
		int ans=1;
		ArrayList<Integer> list=new ArrayList<>();
		list.add(c[0]);
		d[0]=1;
		for(int i=1;i<n;i++) {
			if(list.get(list.size()-1)<c[i]) {
				ans++;
				list.add(c[i]);
				d[i]=ans;
			}else {
				int l=0,r=list.size()-1;
				int now=c[i];
				while(l<r) {
					int mid=(l+r)/2;
					if(list.get(mid)<now) {
						l=mid+1;
					}else {
						r=mid;
					}
				}
				list.set(r, c[i]);
				d[i]=r+1;
			}
		}
		System.out.println(ans);
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=n-1;i>=0&&ans>0;i--) {
			if(d[i]==ans) {
				pq.add(e[c[i]]);
				ans--;
			}
		}
		while(!pq.isEmpty()) {
			System.out.print(pq.poll()+" ");
		}
        bw.flush();
        bw.close();
        br.close();
	}
}