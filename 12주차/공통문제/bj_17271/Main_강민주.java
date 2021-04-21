import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[10001];
		arr[0]=1;
		for(int i=1;i<=N;i++) {
			arr[i]=arr[i-1];
			if(i-M>=0) arr[i]=(arr[i]+arr[i-M])%1000000007;
		}
		bw.write(arr[N]+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
