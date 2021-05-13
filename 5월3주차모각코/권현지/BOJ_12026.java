import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_12026{

	static char[] turn = {'B', 'O', 'J'};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String input = br.readLine();
		
		
		char now = 'B';
		
		int[][] D = new int[N][3];
		
		for(int i = 0; i<N; i++)
			Arrays.fill(D[i], -1);
//		만약 이전에 B를 방문했다면 O방문가능
//		BOJ순서 필수
		
		D[0][0] = 0;
		
		for(int i = 1; i<N; i++) {
			now = input.charAt(i); 
//			for(int k = 0; k<3; k++) {
//				System.out.print(D[i][k]);
//			}
//			System.out.println();
			for(int j = i-1; j>=0; j--) {
				if(now == 'B' && D[j][2] != -1) {	//B
					if(D[i][0] == -1)
						D[i][0] = (i-j)*(i-j) + D[j][2];
					else {
						D[i][0] = Math.min(D[i][0],(i-j)*(i-j) + D[j][2]);
						
					}
				}
				if(now == 'O' && D[j][0] != -1) {	//O
					if(D[i][1] == -1)
						D[i][1] = (i-j)*(i-j) + D[j][0];
					else {
						D[i][1] = Math.min(D[i][1],(i-j)*(i-j) + D[j][0]);
						
					}
				}
				if(now == 'J' && D[j][1] != -1) {	//J
					if(D[i][2] == -1)
						D[i][2] = (i-j)*(i-j) + D[j][1];
					else {
						D[i][2] = Math.min(D[i][2],(i-j)*(i-j) + D[j][1]);
						
					}
				}
			}
		}
		int ans = -1;
		for(int i = 0; i<3; i++) {
			if(D[N-1][i] != -1) {
				ans = D[N-1][i];
				break;
			}
		}
		
		System.out.println(ans);
	}

}
