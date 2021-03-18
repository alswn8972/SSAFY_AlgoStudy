import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_20166 { 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char c[][]=new char[10][10];
	static int dx[]= {0,0,1,-1,1,1,-1,-1};
	static int dy[]= {1,-1,0,0,1,-1,1,-1};
	static int n,m,k;
	static Map<String,Integer> map=new HashMap<>();
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++) {
			String now=br.readLine();
			for(int j=0;j<m;j++) {
				c[i][j]=now.charAt(j);
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				String s=String.valueOf(c[i][j]);
				if(map.containsKey(s)) map.put(s, map.get(s)+1);
				else map.put(s, 1);
				solve(i,j,1,s);
			}
		}
		for(int i=0;i<k;i++) {
			String now=br.readLine();
			bw.write(Integer.toString(map.containsKey(now)?map.get(now):0)+"\n");
		}

		bw.flush();
	}
	static void solve(int x,int y,int depth,String now) {
		if(depth==5) {
			return;
		}
		for(int i=0;i<8;i++) {
			int mx=x+dx[i];
			int my=y+dy[i];
			if(mx==n) mx-=n;
			if(my==m) my-=m;
			if(mx==-1) mx+=n;
			if(my==-1)my+=m;
			String s=now+c[mx][my];
			if(map.containsKey(s)) map.put(s, map.get(s)+1);
			else map.put(s, 1);
			solve(mx,my,depth+1,s);
		}
	}
}



