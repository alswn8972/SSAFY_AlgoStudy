import java.util.HashMap;
import java.util.Scanner;

public class Main_문영화 {

	static HashMap<Integer, Integer> map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] num = new boolean[n+1];
		num[0]=num[1]=true;
		
		for(int i=2;i*i<=n;i++) {
			if(num[i]==true) continue;
			
			for(int j=i*i;j<=n;j+=i) {
				num[j]=true;
			}
		}
		for(int i=2;i<=n;i++) {
			if(num[i]==false) {
				map= new HashMap<>();
				if(sosu(i)) {
					System.out.println(i);
				}
			}
				
		}
	}
	public static boolean sosu(int i) {
		
		int res=0;
		int tg=i;
		while(true) {
			if(tg==0) break;
			int mod = tg%10;
			res+=mod*mod;
			tg=tg/10;
		}
		if(res==1) return true;
		else {
			if(!map.containsKey(res)) {
				map.put(res, 1);
				if(sosu(res)) {
					return true;
				}
			}else {
				return false;
			}
		}
		return false;
	}

}
