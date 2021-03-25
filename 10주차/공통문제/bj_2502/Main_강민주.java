import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_강민주 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int D=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int fibo[][] = new int[31][2]; 
		
		fibo[1][0] = 1; 
		fibo[2][1] = 1; 
		for (int i=3;i<= D;i++) {
			for (int j=0;j<2;j++) 
				fibo[i][j]=fibo[i-2][j]+fibo[i-1][j]; 
			} 
		for (int i=1; i<=K; i++) {
			if((K-fibo[D][0]*i)%fibo[D][1]==0) {
				bw.write(i+"\n");
				bw.write((K-fibo[D][0]*i)/fibo[D][1]+" ");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
