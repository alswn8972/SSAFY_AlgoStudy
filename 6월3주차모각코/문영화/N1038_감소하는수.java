import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N1038_감소하는수 {

	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		ArrayList<Long> arr = new ArrayList<>(); 

		for(int i=1;i<=1023;i++) {
			long num=0;
			int temp=i;
			for(int x=9;x>=0;x--) {
				if(temp %2==1)
					num=10*num+x;
				temp/=2;
			}
			arr.add(num);
		}
	
		Collections.sort(arr);
		int N = sc.nextInt();
		if(N>1023) {
			System.out.println("-1");
		}else {
			System.out.println(arr.get(N));
		}
		
		
	}

}
