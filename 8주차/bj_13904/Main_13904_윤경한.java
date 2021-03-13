import java.util.*;
import java.io.*;

public class Main_13904_윤경한 {

	static int N;
	static ArrayList<HW> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N= Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		int lastday=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			
			list.add(new HW(day,score));
			lastday = Math.max(lastday, day);
		}
		Collections.sort(list, new Comparator<HW>() {
			@Override	
			public int compare(HW o1, HW o2) {
				return -(o1.score-o2.score);
			}
		});
		//System.out.println(list.toString());
		
		int res=0;
		int[] scores = new int[1001];	
		for(int i=0; i<N; i++) {		
			for(int j=list.get(i).day; j>0; j--) {	
				if(scores[j] == 0) {
					res += list.get(i).score;
					scores[j] = list.get(i).score;
					break;
				}
			}
		}
		

		
		System.out.println(res);
		
	}
	
	
	static class HW
	{
		int day,score;

		public HW(int day, int score) {
			this.day = day;
			this.score = score;
		}

		@Override
		public String toString() {
			return "HW [day=" + day + ", score=" + score + "]";
		}
		
	}
}
