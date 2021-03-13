import java.util.*;
import java.io.*;
public class Main_1756_윤경한 {
	static int[] oven ;
	static int dep,min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		oven = new int[D];
		

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < D; i++) {
			oven[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i =1; i<D; i++) {
			if(oven[i] > oven[i-1]) {
				oven[i] = oven[i-1];
			}
		}
		dep=D-1;
		min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(st.nextToken());
			binary(target, 0, dep );
		}
		
		min++;
		System.out.println(min);
		

	}
	static void binary(int target, int topIdx, int botIdx) {
		int res = -1;
		while (topIdx <= botIdx) {
			int mid = (topIdx + botIdx) / 2;
			if (oven[mid] >= target) {
				res = mid;
				topIdx = mid + 1;
			} else {
				botIdx = mid - 1;
			}
		}
		min = Math.min(min, res);
		dep = res-1;
	}
}
