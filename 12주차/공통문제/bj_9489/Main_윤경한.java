import java.io.*;
import java.util.*;
public class Main_9489 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		while (true) {
			int a[] = new int[1111];
			int p[] = new int[1111];
			a[0] =-1;  p[0] =-1;
	        
	        st = new StringTokenizer(br.readLine());
	        int n = Integer.parseInt(st.nextToken());
	        int k = Integer.parseInt(st.nextToken());
			
			if (n==0 && k==0) break;

			int cnt = -1, idx = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				if (a[i] == k) idx = i;
				if (a[i] != a[i - 1] + 1) cnt++;
				p[i] = cnt;
			}

			int ans = 0;
			for (int i = 1; i <= n; i++)
				if (p[i] != p[idx] && p[p[i]] == p[p[idx]]) ans++;

			System.out.println(ans+"");
		}

		return;
	}
}
