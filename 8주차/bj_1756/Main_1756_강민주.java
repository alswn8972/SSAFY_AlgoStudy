import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1756_강민주 {
	static int D, N;
	static int[] oven, pizza;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		D=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());

		oven=new int[D];
		pizza=new int[N];


		st=new StringTokenizer(br.readLine());
		for(int i=0;i<D;i++) {
			oven[i]=Integer.parseInt(st.nextToken());
		}

		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pizza[i]=Integer.parseInt(st.nextToken());
		}

		for(int i=0;i<D-1;i++) {
			if(oven[i]<oven[i+1])
				oven[i+1]=oven[i];
		}
		int count = 0;
		int result = 0;
		for (int i = D-1; i >= 0 ; i--) {

			if( oven[i] >= pizza[count] ) {
				count++;
			}


			if(count == N) {
				result = i+1;
				break;
			}

		}
		System.out.println(result);
	}


}
