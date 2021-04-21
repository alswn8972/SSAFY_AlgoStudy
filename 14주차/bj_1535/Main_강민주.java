import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1535 {
	static int N,res;
	static int[] power,happy;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		power=new int[N];
		happy=new int[N];
		check=new boolean[N];
		st=new StringTokenizer(br.readLine());
		StringTokenizer st2=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			power[i]=Integer.parseInt(st.nextToken());
			happy[i]=Integer.parseInt(st2.nextToken());
		}
		res=0;
		maxHappy(0);
		System.out.println(res);
	}
	private static void maxHappy(int k) {
		if(k==N) {
			int sum=0,max=0;
			for(int i=0;i<N;i++) {
				if(check[i]) {
					sum+=power[i];
				}
			}
			if(sum>=100) {
				return;
			}else {
				for(int i=0;i<N;i++) {
					if(check[i]) {
						max+=happy[i];
					}
				}
				res=Math.max(res, max);
				return;
			}
		}
		check[k]=false;
		maxHappy(k+1);
		check[k]=true;
		maxHappy(k+1);
	}
}
