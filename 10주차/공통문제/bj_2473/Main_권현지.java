import java.util.*;
import java.io.*;

public class Main_권현지 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	long[] arr = new long[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<N; i++)
    		arr[i] = Long.parseLong(st.nextToken());
    	
    	Arrays.sort(arr);
    	
    	int first = 0;
    	int second = 0;
    	int third = 0;
    	long min = Long.MAX_VALUE;
    	
    	for(int i = 0; i<N-1; i++) {
    		int j = i+1;
    		int k = N-1;
    		while(j!=k) {
    			long sum = arr[i] + arr[j] + arr[k];
    			if(Math.abs(sum)<min) {
    				first = i;
    				second = j;
    				third = k;
    				min = Math.abs(sum);
    			}
    			if(sum < 0) {
    				j++;
    			}else {
    				k--;
    			}
    		}
    	}
    	
    	System.out.println(arr[first]+" "+ arr[second]+" "+arr[third]);
    	
    }
	

 
}
