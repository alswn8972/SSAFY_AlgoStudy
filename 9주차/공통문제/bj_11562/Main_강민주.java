import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_강민주 {
	static int[][] map=new int[251][251];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());


		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j) 
					map[i][j]=0;
				else
					map[i][j]=987654321;
			}
		}


		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(b==0) {
				map[u][v]=0;
				map[v][u]=1;
			}
			else {
				map[u][v]=0;
				map[v][u]=0;
			}
		}

		//플로이드 와샬 알고리즘이 그래서 뭔디 ..ㅡㅡ
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(i==j) continue;
					else {
						if (map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}	
					}
				}
			}
		}
		int k=Integer.parseInt(br.readLine());
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			bw.write(Integer.toString(map[s][e])+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
