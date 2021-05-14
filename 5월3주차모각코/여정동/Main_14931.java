import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14931 {
	static int L; 
	static long max = 0, maxd = 0;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		arr = new int[L+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= L; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int d = 1; d <= L; d++) {
			long count = 0;
			
			for(int i = d; i <= L ; i += d) {
				count += arr[i];
			}
			
			if(max < count) {
				maxd = d;
				max = count;
			}
		}
		System.out.println(maxd+" "+max);
	}
}
