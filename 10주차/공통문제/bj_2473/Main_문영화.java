import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_문영화 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		long[] num = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i]=Long.parseLong(st.nextToken());
		}
		Arrays.sort(num);
		
		long result=Long.MAX_VALUE;
		long[] tempArr = new long[3];
		boolean[] v = new boolean[N];
		for(int i=0;i<N-1;i++) {
			v[i]=true;
			long min = Long.MAX_VALUE;
			int R=N-1;
			int L=0;
			if(v[R]) R--;
			if(v[L]) L++;
			int rL=0;
			int rR=0;
			
			while(L!=R) {
				long temp = Math.abs(num[L]+num[R]+num[i]);
				if(min>temp) {
					min=temp;
					rL=L;
					rR=R;	
				}
				if(Math.abs(num[L+1]+num[R]+num[i])
						> Math.abs(num[L]+num[R-1]+num[i])) {
					if(v[R-1]&&R-2>=0) {
						R-=2;
					}else R--;
				}else {
					if(v[L+1]&&L+2<N) {
						L+=2;
					}else L++;
				}
			}
			v[i]=false;
			if(result>Math.abs(num[i]+num[rL]+num[rR])) {
				result=Math.abs(num[i]+num[rL]+num[rR]);
				tempArr[0]=num[rL];
				tempArr[1]=num[rR];
				tempArr[2]=num[i];
			}
		}
		Arrays.sort(tempArr);
		
		for(int i=0;i<3;i++) {
			System.out.print(tempArr[i]+" ");
		}

	}
}