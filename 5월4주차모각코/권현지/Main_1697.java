import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean D[] = new boolean[200000];

		
		
		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> time = new LinkedList<>();
		
		
		D[N] = true;
		que.add(N);
		int sec = 0;
		time.add(sec);
		while(!que.isEmpty()) {
			int now = que.poll();
			sec = time.poll();
			
			if(now == K) {
				break;
			}
			
			if(now-1>=0 && !D[now-1]) {
				D[now-1] = true;
				que.add(now-1);
				time.add(sec+1);
			}
			if(now+1<200000 && !D[now+1]) {
				D[now+1] = true;
				que.add(now+1);
				time.add(sec+1);
			}
			if(now*2<200000 && !D[now*2]) {
				D[now*2] = true;
				que.add(now*2);
				time.add(sec+1);
			}
			
		}
		
		System.out.println(sec);
		
	}

}
