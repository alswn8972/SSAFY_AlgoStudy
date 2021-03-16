import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_강민주 {
	static int[] country;
	static int[] setSize;
	static boolean[] state;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();

		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		country=new int[N+1];
		setSize=new int[N+1];
		state=new boolean[N+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			country[i]=i;
			setSize[i]=Integer.parseInt(st.nextToken());
		}

		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int O=Integer.parseInt(st.nextToken());
			int P=Integer.parseInt(st.nextToken());
			int Q=Integer.parseInt(st.nextToken());
			merge(O, P, Q);
		}
		Arrays.sort(setSize);
		int cnt=0;
		for(int i=1;i<=N;i++) {
			if(setSize[i]>0) {
				cnt++;
				sb.append(setSize[i]+" ");
			}
		}
		bw.write(cnt+" ");
		bw.newLine();
		bw.write(sb.toString()+" ");
		bw.flush();
		bw.close();
		br.close();
	}
	private static int find(int c) {
		if(c==country[c]) return c;
		return country[c]=find(country[c]);
	}
	private static void merge(int o, int p, int q) {
		p=find(p);
		q=find(q);
		if(p!=q) {
			if(o==1) {
				if(setSize[p]<setSize[q]) {
					country[p]=q;
					setSize[q]+=setSize[p];
					setSize[p]=0;
				}
				else {
					country[q]=p;
					setSize[p]+=setSize[q];
					setSize[q]=0;
				}
			}
			else {
				if(setSize[p]<setSize[q]) {
					country[p]=q;
					setSize[q]-=setSize[p];
					setSize[p]=0;
				}
				else {
					country[q]=p;
					setSize[p]-=setSize[q];
					setSize[q]=0;
				}
			}
		}
	}

}
