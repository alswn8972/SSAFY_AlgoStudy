import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2331 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		ArrayList<Integer> list=new ArrayList<>();
		
		String N=st.nextToken();
		int P=Integer.parseInt(st.nextToken());
		int ans=0;
		int cur=0;
		list.add(Integer.parseInt(N));
		flag : while(true) {
			int sum=0;
			char[] chs=list.get(cur).toString().toCharArray();
			for(int i=0;i<chs.length;i++) {
				sum+=Math.pow(Character.getNumericValue(chs[i]), P);
			}
			for(int j=0;j<list.size();j++) {
				if(sum==list.get(j)) {
					ans=j;
					break flag;
				} 
			}
			list.add(sum);
			cur++;
		}
		System.out.println(ans);
	}
}
