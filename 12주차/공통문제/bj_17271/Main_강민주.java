import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_17271 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[N+1];
		arr[0]=1;
		arr[1]=1;
		for(int i=2;i<=N;i++) {
			arr[i]=arr[i-1];
			if(i-M>=0) arr[i]=(arr[i-1]+arr[i-M])%10000007;
			
		}
		bw.write(arr[N]+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
