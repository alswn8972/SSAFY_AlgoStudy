import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_13904_문영화 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> work = new ArrayList<>();
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			 
			work.add(new int[] {a,b});
		}
		
		Collections.sort(work,new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o2[1] -o1[1];
				}
				return o2[0]-o1[0];
			}
			
		});
		int cur = work.get(0)[0];
		int total=0;
		while(cur!=0) {
			int[] temp;
			int max=0;
			int maxIdx=0;
			boolean flag=false;
			for(int i=0;i<work.size();i++) {
				temp=work.get(i);
				if(cur<=temp[0]) {
					if(max<temp[1]) {
						max=temp[1];
						maxIdx=i;
						flag=true;
					}
					
				}
			}
			cur--;
			if(flag) {
				total+=max;
				work.remove(maxIdx);
			}
			
		}
		System.out.println(total);
	}

}

