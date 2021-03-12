import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_13904_강민주 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		int[][] hw= new int[N][2];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			hw[i][0]=Integer.parseInt(st.nextToken());
			hw[i][1]=Integer.parseInt(st.nextToken());
		}	
		Arrays.sort(hw, new Comparator<int[]>() {
			@Override	
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o2[1], o1[1]);
			}
		});
		int result=0;
		int[] scores = new int[1001];
		for(int i=0; i<N; i++) {		
			for(int j=hw[i][0]; j>0; j--) {
				if(scores[j] == 0) {
					scores[j] = hw[i][1];
					result+=scores[j];
					break;
				}
			}
		}
		System.out.println(result);
	}
}
