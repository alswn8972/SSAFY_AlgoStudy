import java.util.Scanner;

public class BJ_9663_N_Queen {

	static int N;
	static int[] map;
	static int ans=0;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N];
		dfs(0);
		System.out.println(ans);
		
	}
	public static void dfs(int n) {
		if(n==N) {
			ans++;
			return;
		}
		for(int i=0;i<N;i++) {
			map[n]=i;
			if(possible(n)) {
				dfs(n+1);
			}
		}
		
		
	}
	public static boolean possible(int n) {
		
		for(int i=0;i<n;i++) {
			if(map[i]==map[n])
				return false;
			else if(Math.abs(n-i)==Math.abs(map[n]-map[i])) {
				return false;
			}
				
		}
		return true;
		
	}

}
