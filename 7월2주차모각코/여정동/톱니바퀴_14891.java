import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 톱니바퀴_14891 {
	static Gear[] gear = new Gear[5];
	
	static void spin(int tar, int dir) {
		int[] rs = new int[5];
		boolean[] vi = new boolean[5];
		Queue<Integer> q = new LinkedList<>();
		q.offer(tar);
		rs[tar] = dir;
		vi[tar] = true;
		
		while(!q.isEmpty()){
			int now = q.poll();
			
			int next = now-1;
			if(next > 0 && next < 5 && !vi[next]) {
				vi[next] = true;
				if(gear[now].teeth[gear[now].left_ind] != gear[next].teeth[gear[next].right_ind]) {
					if(rs[now] == -1) rs[next] = 1;
					else if(rs[now] == 1) rs[next] = -1;
					q.offer(next);
				}
			}
			
			next = now+1;
			if(next > 0 && next < 5 && !vi[next]) {
				vi[next] = true;
				if(gear[now].teeth[gear[now].right_ind] != gear[next].teeth[gear[next].left_ind]) {
					if(rs[now] == -1) rs[next] = 1;
					else if(rs[now] == 1) rs[next] = -1;
					q.offer(next);
				}
			}
		}
		
		for(int i = 1; i < 5; i++) {
			if(rs[i] == 1) gear[i].spin_clock();
			else if(rs[i] == -1) gear[i].spin_Rclock();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear = new Gear[5];
		
		for(int i = 1; i <= 4; i++) {
			String input = br.readLine();
			gear[i] = new Gear(input);
		}
		
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tar = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			spin(tar,dir);
		}
		int result = 0;
		int sum = 1;
		for(int i = 1; i < 5; i++) {
			if(gear[i].teeth[gear[i].top_ind] == '1') {
				result += sum;
			}
			sum *= 2;
		}
		System.out.println(result);
	}
	
	static class Gear{
		int left_ind;
		int right_ind;
		int top_ind;
		char[] teeth;
		
		Gear(String input){
			this.teeth = new char[input.length()];
			for(int i = 0; i < this.teeth.length; i++) {
				this.teeth[i] = input.charAt(i);
			}
			
			this.left_ind = 6;
			this.right_ind = 2;
			this.top_ind = 0;
		}
		
		void spin_clock(){
			this.left_ind--;
			this.right_ind--;
			this.top_ind--;
			
			if(this.right_ind < 0) this.right_ind = 7;
			if(this.left_ind < 0) this.left_ind = 7;
			if(this.top_ind < 0) this.top_ind = 7;
		}
		
		void spin_Rclock() {
			this.left_ind++;
			this.right_ind++;
			this.top_ind++;
			
			if(this.right_ind > 7) this.right_ind = 0;
			if(this.left_ind > 7) this.left_ind = 0;
			if(this.top_ind > 7) this.top_ind = 0;
		}
	}
}
