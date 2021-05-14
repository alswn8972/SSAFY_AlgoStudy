import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num = new int[N+1];
		for(int i=1;i<=N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int resNum =0;
		long resSum=0;
		for(int i=1;i<=N;i++) {
			long sum=0;
			for(int j=i;j<=N;j+=i) {
				
					sum+=num[j];
			}
			if(sum>resSum) {
				resSum=sum;
				resNum=i;
			}
		}
		if(resSum==0) {
			System.out.println(0+" "+0);
			return;
		}
		System.out.println(resNum+ " " + resSum);
		
	}
	

}
