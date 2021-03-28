import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_여정동{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] result = new long[3];
		long[] list = new long[N];
		long min_sum = Long.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			list[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(list);
		
		s:for(int i = 0; i < list.length-2; i++) {
			int j = i+1;
			int k = list.length-1;
			
			while(j < k) {
				long temp = list[i]+list[j]+list[k];
				if(temp == 0) {
					result[0] = list[i];
					result[1] = list[j];
					result[2] = list[k];
					min_sum = 0;
					break s;
				}
				
				else {
					if(Math.abs(0-min_sum) > Math.abs(0-temp)) {
						result[0] = list[i];
						result[1] = list[j];
						result[2] = list[k];
						min_sum = temp;
					}
					
					if(temp < 0) {
						j++;
					}
					else if(temp > 0) {
						k--;
					}
				}
			}
			
		}
		
		Arrays.sort(result);
		
		for(int i = 0 ; i < 3; i++) {
			System.out.print(result[i]+" ");
		}
	}
}